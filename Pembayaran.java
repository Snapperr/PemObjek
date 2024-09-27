class Pembayaran {
    private double jumlah;

    public Pembayaran(double jumlah) {
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void prosesPembayaran() {
        System.out.println("Proses pembayaran sebesar: " + jumlah);
    }
}

