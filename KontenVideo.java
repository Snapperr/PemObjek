class KontenVideo extends Konten {
    public KontenVideo(String judul) {
        super(judul);
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("Memutar video: " + getJudul());
    }
}