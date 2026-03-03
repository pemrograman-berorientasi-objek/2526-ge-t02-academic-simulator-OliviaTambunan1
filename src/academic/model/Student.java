package academic.model;

/**
 * @author 12S24048-Olivia Tambunan
 */

public class Student {
    private String id; // NIM mahasiswa
    private String name;
    private int year; // Tahun angkatan
    private String major; // Program studi

    // Konstruktor untuk inisialisasi Student
    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // Metode getter untuk mendapatkan ID/NIM student (jika diperlukan)
    public String getId() {
        return id;
    }

    // Metode untuk mengembalikan representasi string dari Student sesuai format output
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}