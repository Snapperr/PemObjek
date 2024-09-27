abstract class Konten {
    private String judul;

    public Konten(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public abstract void tampilkanKonten();
}