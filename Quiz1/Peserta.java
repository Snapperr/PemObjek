package Quiz1;

import java.util.ArrayList;

public class Peserta extends Pengguna {
    private String email;
    private String password;
    private ArrayList<Kursus> kursusList;

    public Peserta(int id, String nama, String email, String password) {
        super(id, nama);
        this.email = email;
        this.password = password;
        this.kursusList = new ArrayList<>();
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(getNama() + " has logged out.");
    }

    public void daftarKursus(Kursus kursus) {
        kursusList.add(kursus);
        System.out.println(getNama() + " berhasil mendaftar kursus: " + kursus.getNama());
    }

    public void tampilkanKursus() {
        System.out.println("Daftar Kursus untuk " + getNama() + ": ");
        for (Kursus kursus : kursusList) {
            kursus.tampilkanInfo();
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Email: " + email);
    }
}
