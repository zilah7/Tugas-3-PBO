// Program utama untuk mengelola data nilai mahasiswa

import java.util.Scanner;
import java.util.ArrayList;

public class SistemNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<NilaiMahasiswa> daftarMahasiswa = new ArrayList<>();
        
        System.out.println("SISTEM ENTRY NILAI MAHASISWA");
        System.out.println("=============================");
        
        // Input data mahasiswa
        boolean tambahData = true;
        while (tambahData) {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            
            System.out.print("Masukkan Nilai: ");
            int nilai = Integer.parseInt(scanner.nextLine());
            
            // Validasi nilai
            if (nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah (harus 0-100)");
                continue;
            }
            
            daftarMahasiswa.add(new NilaiMahasiswa(nim, nama, nilai));
            
            System.out.print("Tambah data lagi? (y/n): ");
            String jawaban = scanner.nextLine();
            tambahData = jawaban.equalsIgnoreCase("y");
        }
        
        // Menampilkan hasil
        System.out.println("\nHASIL NILAI MAHASISWA");
        System.out.println("=====================");
        
        ArrayList<String> lulus = new ArrayList<>();
        ArrayList<String> tidakLulus = new ArrayList<>();
        ArrayList<String> gradeA = new ArrayList<>();
        ArrayList<String> gradeB = new ArrayList<>();
        ArrayList<String> gradeC = new ArrayList<>();
        ArrayList<String> gradeD = new ArrayList<>();
        ArrayList<String> gradeE = new ArrayList<>();
        
        double totalNilai = 0;
        
        for (NilaiMahasiswa mhs : daftarMahasiswa) {
            System.out.println("NIM   : " + mhs.getNim());
            System.out.println("Nama  : " + mhs.getNama());
            System.out.println("Nilai : " + mhs.getNilai());
            System.out.println("Grade : " + mhs.getGrade());
            System.out.println("===========================================================");
            
            totalNilai += mhs.getNilai();
            
            // Kategorisasi mahasiswa
            if (mhs.isLulus()) {
                lulus.add(mhs.getNama());
            } else {
                tidakLulus.add(mhs.getNama());
            }
            
            // Kategorisasi berdasarkan grade
            switch (mhs.getGrade()) {
                case "A": gradeA.add(mhs.getNama()); break;
                case "B": gradeB.add(mhs.getNama()); break;
                case "C": gradeC.add(mhs.getNama()); break;
                case "D": gradeD.add(mhs.getNama()); break;
                case "E": gradeE.add(mhs.getNama()); break;
            }
        }
        
        // Menampilkan statistik
        System.out.println("\nSTATISTIK NILAI MAHASISWA");
        System.out.println("=========================");
        System.out.println("Jumlah Mahasiswa : " + daftarMahasiswa.size());
        
        System.out.print("Jumlah Mahasiswa yg Lulus : " + lulus.size() + " yaitu ");
        System.out.println(String.join(", ", lulus));
        
        System.out.print("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus.size() + " yaitu ");
        System.out.println(String.join(", ", tidakLulus));
        
        System.out.print("Jumlah Mahasiswa dengan Nilai A = " + gradeA.size() + " yaitu ");
        System.out.println(gradeA.isEmpty() ? "-" : String.join(", ", gradeA));
        
        System.out.print("Jumlah Mahasiswa dengan Nilai B = " + gradeB.size() + " yaitu ");
        System.out.println(gradeB.isEmpty() ? "-" : String.join(", ", gradeB));
        
        System.out.print("Jumlah Mahasiswa dengan Nilai C = " + gradeC.size() + " yaitu ");
        System.out.println(gradeC.isEmpty() ? "-" : String.join(", ", gradeC));
        
        System.out.print("Jumlah Mahasiswa dengan Nilai D = " + gradeD.size() + " yaitu ");
        System.out.println(gradeD.isEmpty() ? "-" : String.join(", ", gradeD));
        
        System.out.print("Jumlah Mahasiswa dengan Nilai E = " + gradeE.size() + " yaitu ");
        System.out.println(gradeE.isEmpty() ? "-" : String.join(", ", gradeE));
        
        double rataRata = totalNilai / daftarMahasiswa.size();
        System.out.printf("Rata-rata nilai mahasiswa adalah : %.2f\n", rataRata);
        
        scanner.close();
    }
}
