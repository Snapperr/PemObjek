package Quiz1;

public class Pembayaran {
    private int id;
    private double jumlah;
    private String metode;
    private Peserta peserta;

    public Pembayaran(int id, double jumlah, String metode, Peserta peserta) {
        this.id = id;
        this.jumlah = jumlah;
        this.metode = metode;
        this.peserta = peserta;
    }

    public void tampilkanInfoPembayaran() {
        System.out.println("--------------------");
        System.out.println("Pembayaran ID: " + id);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Metode Pembayaran: " + metode);
        System.out.println("Peserta: " + peserta.getNama());
        System.out.println("---------------------");
    }
}
