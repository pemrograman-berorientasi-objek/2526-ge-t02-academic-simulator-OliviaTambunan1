package academic.model;

/**
 * @author 12S24048 - Olivia Tambunan
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;

    // Konstruktor untuk inisialisasi Course
    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Metode getter untuk mendapatkan kode course (jika diperlukan)
    public String getCode() {
        return code;
    }

    // Metode untuk mengembalikan representasi string dari Course sesuai format output
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
