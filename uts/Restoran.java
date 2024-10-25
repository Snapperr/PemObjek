package uts;

import java.util.*;

public class Restoran {
    Queue<Pelanggan> antrianPelanggan = new LinkedList<>();
    ManajemenStok manajemenStok;
    int keuangan;
    int reputasi;
    int skorKepuasan;

    public Restoran(int keuangan) {
        this.keuangan = keuangan;
        this.reputasi = 100;
        this.skorKepuasan = 0;
        this.manajemenStok = new ManajemenStok();
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        antrianPelanggan.offer(pelanggan);
        System.out.println("Pelanggan " + pelanggan.nama + " masuk ke antrian.");
    }

    public class ManajemenStok {
        private Map<String, Integer> stokBahan;

        public ManajemenStok() {
            stokBahan = new HashMap<>();
        }

        public void tambahStok(String namaBahan, int jumlah) {
            stokBahan.put(namaBahan, stokBahan.getOrDefault(namaBahan, 0) + jumlah);
            System.out.println("Stok " + namaBahan + " ditambah sebanyak " + jumlah + ". Total stok: " + stokBahan.get(namaBahan));
        }

        public boolean kurangiStok(String namaBahan, int jumlah) {
            if (stokBahan.getOrDefault(namaBahan, 0) >= jumlah) {
                stokBahan.put(namaBahan, stokBahan.get(namaBahan) - jumlah);
                System.out.println("Stok " + namaBahan + " berkurang sebanyak " + jumlah + ". Sisa stok: " + stokBahan.get(namaBahan));
                return true;
            } else {
                System.out.println("Stok " + namaBahan + " tidak mencukupi.");
                return false;
            }
        }

        public int cekStok(String namaBahan) {
            return stokBahan.getOrDefault(namaBahan, 0);
        }

        public void tampilkanStok() {
            System.out.println("Daftar Stok Bahan:");
            for (Map.Entry<String, Integer> entry : stokBahan.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void layaniPelanggan(Karyawan karyawan) {
        if (!antrianPelanggan.isEmpty()) {
            Pelanggan pelanggan = antrianPelanggan.poll();
            karyawan.layani(pelanggan);

            System.out.println("Pelanggan " + pelanggan.nama + " ingin memesan " + pelanggan.preferensi.nama + ".");

            boolean stokCukup = true;
            for (Map.Entry<Makanan.Bahan, Integer> entry : pelanggan.preferensi.bahanDibutuhkan.entrySet()) {
                if (manajemenStok.cekStok(entry.getKey().nama) < entry.getValue()) {
                    stokCukup = false;
                    break;
                }
            }

            if (stokCukup) {
                for (Map.Entry<Makanan.Bahan, Integer> entry : pelanggan.preferensi.bahanDibutuhkan.entrySet()) {
                    manajemenStok.kurangiStok(entry.getKey().nama, entry.getValue());
                }

                pelanggan.preferensi.masak();

                String[] metodePembayaran = {"Debit", "Tunai", "QRIS"};
                Random random = new Random();
                String metodeDipilih = metodePembayaran[random.nextInt(metodePembayaran.length)];
                System.out.println("Pembayaran otomatis menggunakan: " + metodeDipilih + " berhasil.");

                keuangan += pelanggan.preferensi.harga;
                skorKepuasan += pelanggan.kesabaran;
                System.out.println("Pelanggan " + pelanggan.nama + " membayar " + pelanggan.preferensi.harga + ". Total keuangan: " + keuangan);
                System.out.println("Skor Kepuasan saat ini: " + skorKepuasan);
            } else {
                System.out.println("Maaf, stok bahan tidak mencukupi untuk membuat " + pelanggan.preferensi.nama);
                reputasi -= 10;
                skorKepuasan -= 5;
                System.out.println("Skor Kepuasan turun. Skor Kepuasan saat ini: " + skorKepuasan);
            }
        }
    }

    public void tampilkanReputasi() {
        System.out.println("Reputasi restoran: " + reputasi);
    }

    public void tampilkanKepuasan() {
        System.out.println("Skor Kepuasan pelanggan: " + skorKepuasan);
    }

    public void tampilkanStokBahan() {
        manajemenStok.tampilkanStok();
    }

    public static void main(String[] args) throws InterruptedException {
        Restoran restoran = new Restoran(100000);
        restoran.manajemenStok.tambahStok("Roti", 20);
        restoran.manajemenStok.tambahStok("Daging", 10);
        restoran.manajemenStok.tambahStok("Kentang", 15);

        Karyawan koki = new Karyawan("Budi", "memasak");
        Makanan burger = new Makanan("Burger", 25000, 5, Map.of(new Makanan.Bahan("Roti", 1), 1, new Makanan.Bahan("Daging", 1), 1));
        Makanan kentangGoreng = new Makanan("Kentang Goreng", 15000, 3, Map.of(new Makanan.Bahan("Kentang", 1), 2));

        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            Makanan preferensi = random.nextBoolean() ? burger : kentangGoreng;
            Pelanggan pelanggan = new Pelanggan("Pelanggan" + i, preferensi, random.nextInt(10) + 1);
            restoran.tambahPelanggan(pelanggan);
            Thread.sleep(1000);  
        }

        while (!restoran.antrianPelanggan.isEmpty()) {
            restoran.layaniPelanggan(koki);
            restoran.tampilkanReputasi();
            restoran.tampilkanKepuasan();
            restoran.tampilkanStokBahan();
            Thread.sleep(2000);  
        }

        System.out.println("Keuangan akhir restoran: " + restoran.keuangan);
        System.out.println("Skor Kepuasan Akhir: " + restoran.skorKepuasan);
    }
}
