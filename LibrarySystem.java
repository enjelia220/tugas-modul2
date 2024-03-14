import java.util.Scanner;

public class LibrarySystem {
    static Scanner scanner = new Scanner(System.in);
    static int studentCount = 0;

    // Dummy data for books
    static String[][] books = {
            {"875g-e474-8756", "title", "Author", "sejarah", "4"},
            {"984r-t487-2323", "title", "Author", "Sejarah", "6"},
            {"029k-345f-0394", "title", "Author", "sejarah", "8"}
    };

    static String[][] students = new String[100][4]; // Assuming maximum 100 students, each with 4 attributes

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== library system===");
            System.out.println("1.login mahasiswa");
            System.out.println("2.login admin");
            System.out.println("3.exit");
            System.out.print("Masukkan pilihan (1-3): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println("Terimakasih.keluar dari program.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void studentLogin() {
        System.out.print("Enter your nim (input 99 untuk back): ");
        String nim = scanner.next();
        if (nim.equals("99"))
            return;
        // Implement student login logic here
        // For simplicity, assuming successful login and proceeding to student menu
        studentMenu();
    }

    static void studentMenu() {
        while (true) {
            System.out.println("\n=== student menu===");
            System.out.println("1.buku terpinjam");
            System.out.println("2.pinjam buku");
            System.out.println("3.pinjam buku atau logout");
            System.out.print("Masukkan pilihan (1-3): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Implement borrowed books display logic
                    break;
                case 2:
                    // Implement borrow book logic
                    break;
                case 3:
                    System.out.println("System logout…");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void adminLogin() {
        System.out.print("Masukkan username(admin): ");
        String username = scanner.next();
        System.out.print("Masukkan password(admin): ");
        String password = scanner.next();
        // For simplicity, hardcoding the admin credentials
        if (username.equals("admin") && password.equals("admin")) {
            adminMenu();
        } else {
            System.out.println("Invalid credentials for admin.");
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n=== admin menu===");
            System.out.println("1.add student");
            System.out.println("2.display registered student");
            System.out.println("3.logout");
            System.out.print("Masukkan pilihan (1-3): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Loggin out from admin account.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Masukan nama mahasiswa: ");
        String name = scanner.next();
        System.out.print("Enter student nim: ");
        String nim = scanner.next();
        while (nim.length() != 15) {
            System.out.println("Nim harus 15 digit");
            System.out.print("Enter student nim: ");
            nim = scanner.next();
        }
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.next();
        System.out.print("Masukkan jurusan mahasiswa: ");
        String program = scanner.next();

        students[studentCount][0] = name;
        students[studentCount][1] = nim;
        students[studentCount][2] = faculty;
        students[studentCount][3] = program;

        studentCount++;

        System.out.println("Student successfully registered.");
    }

    static void displayStudents() {
        System.out.println("List of registered student:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i][0]);
            System.out.println("Nim: " + students[i][1]);
            System.out.println("Faculty: " + students[i][2]);
            System.out.println("Program: " + students[i][3]);
            System.out.println();
        }
    }
}
