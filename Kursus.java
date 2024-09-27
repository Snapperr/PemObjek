class Kursus {
    private String namaKursus;
    private String deskripsi;
    private double harga;
    private Instruktur instruktur;
    private Konten[] kontenList;
    private int index;

    public Kursus(String namaKursus, String deskripsi, double harga, Instruktur instruktur) {
        this.namaKursus = namaKursus;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.instruktur = instruktur;
        this.kontenList = new Konten[10]; // Maksimal 10 konten
        this.index = 0;
    }

    public String getNamaKursus() {
        return namaKursus;
    }

    public double getHarga() {
        return harga;
    }

    public void tambahKonten(Konten konten) {
        if (index < kontenList.length) {
            kontenList[index] = konten;
            index++;
        } else {
            System.out.println("Tidak dapat menambahkan konten, kursus penuh!");
        }
    }

    public void tampilkanKonten() {
        for (int i = 0; i < index; i++) {
            kontenList[i].tampilkanKonten();
        }
    }
}
