package Quiz1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Instruktur> instrukturList = new ArrayList<>();
        instrukturList.add(new Instruktur(1, "Andi", "Software Development"));
        instrukturList.add(new Instruktur(2, "Budi", "Marketing"));

        ArrayList<Kursus> kursusList = new ArrayList<>();
        kursusList.add(new Kursus(1, "Java Programming", "Belajar pemrograman Java", 1000000, instrukturList.get(0)));
        kursusList.add(new Kursus(2, "Digital Marketing", "Belajar strategi pemasaran digital", 1200000, instrukturList.get(1)));

        System.out.print("Masukkan nama Anda: ");
        String namaPeserta = scanner.nextLine();

        System.out.print("Masukkan email Anda: ");
        String emailPeserta = scanner.nextLine();
        System.out.print("Masukkan password Anda: ");
        String passwordPeserta = scanner.nextLine();

        Peserta peserta = new Peserta(1, namaPeserta, emailPeserta, passwordPeserta);

        boolean lanjut = true;  

        while (lanjut) {
            System.out.println("\nDaftar Kursus yang Tersedia:");
            for (int i = 0; i < kursusList.size(); i++) {
                System.out.println((i + 1) + ". " + kursusList.get(i).getNama());
            }

            int pilihanKursus = -1;
            while (pilihanKursus < 1 || pilihanKursus > kursusList.size()) {
                System.out.print("Pilih kursus (masukkan nomor): ");
                pilihanKursus = scanner.nextInt();
                if (pilihanKursus < 1 || pilihanKursus > kursusList.size()) {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
            Kursus kursusTerpilih = kursusList.get(pilihanKursus - 1);

            System.out.println("\nDaftar Instruktur yang Tersedia:");
            for (int i = 0; i < instrukturList.size(); i++) {
                System.out.println((i + 1) + ". " + instrukturList.get(i).getNama());
            }

            int pilihanInstruktur = -1;
            while (pilihanInstruktur < 1 || pilihanInstruktur > instrukturList.size()) {
                System.out.print("Pilih instruktur (masukkan nomor): ");
                pilihanInstruktur = scanner.nextInt();
                if (pilihanInstruktur < 1 || pilihanInstruktur > instrukturList.size()) {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
            Instruktur instrukturTerpilih = instrukturList.get(pilihanInstruktur - 1);

            peserta.daftarKursus(kursusTerpilih);

            peserta.tampilkanKursus();

            System.out.print("\nMasukkan metode pembayaran (contoh: Transfer Bank): ");
            scanner.nextLine();  
            String metodePembayaran = scanner.nextLine();

            Pembayaran pembayaran = new Pembayaran(1, kursusTerpilih.getHarga(), metodePembayaran, peserta);
            pembayaran.tampilkanInfoPembayaran();

            System.out.print("\nApakah Anda ingin mendaftar kursus lain? (y/n): ");
            String jawaban = scanner.nextLine();
            if (jawaban.equalsIgnoreCase("n")) {
                lanjut = false;  
            }
        }

        System.out.println("\nTerima kasih telah mendaftar kursus!");
        scanner.close();
    }
}
