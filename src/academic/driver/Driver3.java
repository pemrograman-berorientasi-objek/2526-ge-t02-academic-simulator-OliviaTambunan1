package academic.driver;

import academic.model.Enrollment; // Mengimpor kelas Enrollment
import java.util.Scanner;        // Mengimpor kelas Scanner untuk input
import java.util.ArrayList;      // Mengimpor ArrayList sebagai pengganti array biasa agar lebih dinamis
/**
 * @author 12S24048-Olivia Tambunan
 */

public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList agar ukuran penyimpanan Enrollment bisa dinamis,
        // karena jumlah Enrollment yang akan diinput tidak diketahui sebelumnya.
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Cek apakah input adalah perintah berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memisahkan setiap segmen input berdasarkan '#'
            String[] enrollmentData = line.split("#");

            // Memastikan ada 4 segmen data sebelum memproses
            if (enrollmentData.length == 4) {
                String courseCode = enrollmentData[0];
                String studentId = enrollmentData[1];
                String academicYear = enrollmentData[2];
                String semester = enrollmentData[3];

                // Membuat objek Enrollment baru dan menambahkannya ke ArrayList
                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            } else {
                // Menangani kasus jika format input tidak sesuai (opsional, untuk robustness)
                System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Setelah loop berhenti, tampilkan semua enrollment yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString()); // Memanggil metode toString() dari objek Enrollment
        }

        input.close(); // Menutup scanner
    }
}
