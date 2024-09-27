class Peserta extends Pengguna {
    public Peserta(String nama, String email) {
        super(nama, email);
    }

    public void daftarKursus(Kursus kursus) {
        System.out.println(getNama() + " mendaftar pada kursus: " + kursus.getNamaKursus());
    }

    public void lakukanPembayaran(Pembayaran pembayaran) {
        pembayaran.prosesPembayaran();
        System.out.println("Peserta " + getNama() + " telah membayar sebesar: " + pembayaran.getJumlah());
    }
}

