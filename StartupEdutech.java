public class StartupEdutech {
    public static void main(String[] args) {
        // Membuat Instruktur
        Instruktur instruktur1 = new Instruktur("Andi", "andi@edutech.com");

        // Membuat Kursus
        Kursus kursus1 = new Kursus("Pemrograman Java", "Belajar dasar-dasar Java", 500000, instruktur1);

        // Instruktur menambahkan konten
        Konten video1 = new KontenVideo("Pengenalan Java");
        Konten artikel1 = new KontenArtikel("Java OOP Concepts");
        Konten kuis1 = new KontenKuis("Kuis Bab 1");

        instruktur1.buatKonten(video1, kursus1);
        instruktur1.buatKonten(artikel1, kursus1);
        instruktur1.buatKonten(kuis1, kursus1);

        // Menampilkan seluruh konten pada kursus
        System.out.println("\nKonten dalam kursus:");
        kursus1.tampilkanKonten();

        // Membuat Peserta
        Peserta peserta1 = new Peserta("Budi", "budi@edutech.com");

        // Peserta mendaftar dan melakukan pembayaran
        peserta1.daftarKursus(kursus1);
        Pembayaran pembayaran1 = new Pembayaran(kursus1.getHarga());
        peserta1.lakukanPembayaran(pembayaran1);
    }
}