package academic.driver;

import java.util.ArrayList;
import java.util.Scanner;

import academic.model.Course;

/**
 * @author 12S24048-Olivia Tambunan
 */
public class Driver1 {

    public static void main(String[] _args) {

      Scanner input = new Scanner(System.in);
        // Menggunakan ArrayList agar ukuran penyimpanan Course bisa dinamis,
        // karena jumlah Course yang akan diinput tidak diketahui sebelumnya.
        // Jika harus menggunakan array statis, kita perlu tahu ukuran maksimal
        // atau membuat array baru saat penuh. Untuk kemudahan, ArrayList lebih cocok.
        ArrayList<Course> courses = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Cek apakah input adalah perintah berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memisahkan setiap segmen input berdasarkan '#'
            String[] courseData = line.split("#");

            // Memastikan ada 4 segmen data sebelum memproses
            if (courseData.length == 4) {
                String code = courseData[0];
                String name = courseData[1];
                int credits = Integer.parseInt(courseData[2]); // Mengonversi String ke int
                String grade = courseData[3];

                // Membuat objek Course baru dan menambahkannya ke ArrayList
                Course newCourse = new Course(code, name, credits, grade);
                courses.add(newCourse);
            } else {
                // Menangani kasus jika format input tidak sesuai (opsional, untuk robustness)
                System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Setelah loop berhenti, tampilkan semua course yang tersimpan
        for (Course course : courses) {
            System.out.println(course.toString()); // Memanggil metode toString() dari objek Course
        }

        input.close(); // Menutup scanner
    }
}


    