package uts;
import java.util.*;

public class Makanan {
    String nama;
    int harga;
    int waktuMemasak;
    Map<Bahan, Integer> bahanDibutuhkan;

    public Makanan(String nama, int harga, int waktuMemasak, Map<Bahan, Integer> bahanDibutuhkan) {
        this.nama = nama;
        this.harga = harga;
        this.waktuMemasak = waktuMemasak;
        this.bahanDibutuhkan = bahanDibutuhkan;
    }

    public boolean cekStok() {
        for (Map.Entry<Bahan, Integer> entry : bahanDibutuhkan.entrySet()) {
            if (entry.getKey().stok < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void masak() {
        for (Map.Entry<Bahan, Integer> entry : bahanDibutuhkan.entrySet()) {
            entry.getKey().kurangiStok(entry.getValue());
        }
        System.out.println(nama + " sedang dimasak selama " + waktuMemasak + " detik.");
    }

    public static class Bahan {
        String nama;
        int stok;

        public Bahan(String nama, int stok) {
            this.nama = nama;
            this.stok = stok;
        }

        public boolean kurangiStok(int jumlah) {
            if (stok >= jumlah) {
                stok -= jumlah;
                return true;
            }
            return false;
        }
    }
}
