package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author 12S24048-Olivia Tambunan
 */  

public class Driver4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Menggunakan ArrayList untuk menyimpan setiap jenis entitas secara terpisah
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Cek apakah input adalah perintah berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memisahkan seluruh segmen input berdasarkan '#'
            String[] segments = line.split("#");

            // Memastikan ada setidaknya satu segmen untuk identifikasi jenis operasi
            if (segments.length > 0) {
                String command = segments[0]; // Segmen pertama adalah perintah

                switch (command) {
                    case "course-add":
                        // Memastikan ada 5 segmen untuk course-add (command + 4 data Course)
                        if (segments.length == 5) {
                            String code = segments[1];
                            String name = segments[2];
                            int credits = Integer.parseInt(segments[3]);
                            String grade = segments[4];
                            Course newCourse = new Course(code, name, credits, grade);
                            courses.add(newCourse);
                        } else {
                            System.err.println("Peringatan: Format input 'course-add' tidak valid: " + line);
                        }
                        break;
                    case "student-add":
                        // Memastikan ada 5 segmen untuk student-add (command + 4 data Student)
                        if (segments.length == 5) {
                            String id = segments[1];
                            String name = segments[2];
                            int year = Integer.parseInt(segments[3]);
                            String major = segments[4];
                            Student newStudent = new Student(id, name, year, major);
                            students.add(newStudent);
                        } else {
                            System.err.println("Peringatan: Format input 'student-add' tidak valid: " + line);
                        }
                        break;
                    case "enrollment-add":
                        // Memastikan ada 5 segmen untuk enrollment-add (command + 4 data Enrollment)
                        if (segments.length == 5) {
                            String courseCode = segments[1];
                            String studentId = segments[2];
                            String academicYear = segments[3];
                            String semester = segments[4];
                            // Grade akan otomatis "None" dari konstruktor Enrollment
                            Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                            enrollments.add(newEnrollment);
                        } else {
                            System.err.println("Peringatan: Format input 'enrollment-add' tidak valid: " + line);
                        }
                        break;
                    default:
                        System.err.println("Peringatan: Perintah tidak dikenal: " + command + " pada baris: " + line);
                        break;
                }
            } else {
                System.err.println("Peringatan: Baris input kosong atau tidak berformat: " + line);
            }
        }

        // Setelah loop berhenti (input "---"), tampilkan semua entitas yang tersimpan
        // Tampilkan Courses
        for (Course course : courses) {
            System.out.println(course.toString());
        }
        // Tampilkan Students
        for (Student student : students) {
            System.out.println(student.toString());
        }
        // Tampilkan Enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        input.close(); // Menutup scanner
    }
}