package Quiz1;

public class Pengguna {
    private int id;
    private String nama;

    public Pengguna(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("ID: " + id + ", Nama: " + nama);
    }
}
