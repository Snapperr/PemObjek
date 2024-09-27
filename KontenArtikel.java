class KontenArtikel extends Konten {
    public KontenArtikel(String judul) {
        super(judul);
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("Menampilkan artikel: " + getJudul());
    }
}
