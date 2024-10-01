package Quiz1;

public class Instruktur extends Pengguna {
    private String bidang;

    public Instruktur(int id, String nama, String bidang) {
        super(id, nama);
        this.bidang = bidang;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bidang: " + bidang);
    }
}
