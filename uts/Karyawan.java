package uts;

public class Karyawan {
    String nama;
    String skill;

    public Karyawan(String nama, String skill) {
        this.nama = nama;
        this.skill = skill;
    }

    public void layani(Pelanggan pelanggan) {
        System.out.println(nama + " sedang melayani " + pelanggan.nama);
    }
}
