class Instruktur extends Pengguna {
    public Instruktur(String nama, String email) {
        super(nama, email);
    }

    public void buatKonten(Konten konten, Kursus kursus) {
        kursus.tambahKonten(konten);
        System.out.println("Instruktur " + getNama() + " menambahkan konten: " + konten.getJudul());
    }
}

