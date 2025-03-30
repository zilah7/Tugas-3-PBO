
 //Class turunan yang menangani perhitungan grade dan kelulusan

public class NilaiMahasiswa extends Mahasiswa {
    // Constructor
    public NilaiMahasiswa(String nim, String nama, int nilai) {
        super(nim, nama, nilai);
    }

    // Method untuk menentukan grade
    public String getGrade() {
        if (!isNilaiValid()) {
            return "Input nilai anda salah";
        } else if (nilai >= 80) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    // Method untuk menentukan status kelulusan
    public boolean isLulus() {
        String grade = getGrade();
        return grade.equals("A") || grade.equals("B") || grade.equals("C");
    }
}
