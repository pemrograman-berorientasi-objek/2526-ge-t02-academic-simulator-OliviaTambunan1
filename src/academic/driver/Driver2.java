package academic.driver;

import academic.model.Student; // Mengimpor kelas Student
import java.util.Scanner;     // Mengimpor kelas Scanner untuk input
import java.util.ArrayList;   // Mengimpor ArrayList sebagai pengganti array biasa agar lebih dinamis

/**
 * @author 12S24048-Olivia Tambunan
 */

public class Driver2 {

    public static void main(String[] _args) {

         Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList agar ukuran penyimpanan Student bisa dinamis,
        // karena jumlah Student yang akan diinput tidak diketahui sebelumnya.
        ArrayList<Student> students = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Cek apakah input adalah perintah berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memisahkan setiap segmen input berdasarkan '#'
            String[] studentData = line.split("#");

            // Memastikan ada 4 segmen data sebelum memproses
            if (studentData.length == 4) {
                String id = studentData[0];
                String name = studentData[1];
                int year = Integer.parseInt(studentData[2]); // Mengonversi String ke int
                String major = studentData[3];

                // Membuat objek Student baru dan menambahkannya ke ArrayList
                Student newStudent = new Student(id, name, year, major);
                students.add(newStudent);
            } else {
                // Menangani kasus jika format input tidak sesuai (opsional, untuk robustness)
                System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Setelah loop berhenti, tampilkan semua student yang tersimpan
        for (Student student : students) {
            System.out.println(student.toString()); // Memanggil metode toString() dari objek Student
        }

        input.close(); // Menutup scanner
    }
}