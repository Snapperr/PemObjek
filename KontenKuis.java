class KontenKuis extends Konten {
    public KontenKuis(String judul) {
        super(judul);
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("Memulai kuis: " + getJudul());
    }
}
