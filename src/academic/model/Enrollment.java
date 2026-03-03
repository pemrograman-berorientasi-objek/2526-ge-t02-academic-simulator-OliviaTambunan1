package academic.model;

/**
 * @author 12S24048-Olivia Tambunan
 */

public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade; // Defaultnya "None"

    // Konstruktor untuk inisialisasi Enrollment
    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Grade default saat pendaftaran, sesuai output
    }

    // Metode setter untuk grade, jika di masa mendatang grade bisa diubah
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Metode getter (jika diperlukan untuk akses atribut secara individual)
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    // Metode untuk mengembalikan representasi string dari Enrollment sesuai format output
    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}