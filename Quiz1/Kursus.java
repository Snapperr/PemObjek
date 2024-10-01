package Quiz1;

public class Kursus {
    private int id;
    private String nama;
    private String deskripsi;
    private double harga;
    private Instruktur instruktur;

    public Kursus(int id, String nama, String deskripsi, double harga, Instruktur instruktur) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.instruktur = instruktur;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public Instruktur getInstruktur() {
        return instruktur;
    }

    public void tampilkanInfo() {
        System.out.println("Kursus ID: " + id);
        System.out.println("Nama Kursus: " + nama);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Harga: " + harga);
        System.out.println("Instruktur: " + instruktur.getNama());
    }
}