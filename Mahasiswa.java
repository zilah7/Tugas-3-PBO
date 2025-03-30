//Class induk untuk menyimpan data dasar mahasiswa

public class Mahasiswa {
    protected String nim;
    protected String nama;
    protected int nilai;

    // Constructor
    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    // Getter methods
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;
    }

    // Method untuk mengecek validitas nilai
    protected boolean isNilaiValid() {
        return nilai >= 0 && nilai <= 100;
    }
}