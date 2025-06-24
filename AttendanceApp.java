import java.sql.*;
import java.util.Scanner;

public class AttendanceApp {
    static final String DB_URL = "jdbc:mysql://localhost:3306/attendance";
    static final String USER = "root";
    static final String PASS = "yourpassword";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Enter student name (or 'exit'): ");
                String name = sc.nextLine();
                if (name.equalsIgnoreCase("exit")) break;

                String sql = "INSERT INTO records (name, time) VALUES (?, NOW())";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.executeUpdate();
                    System.out.println("Attendance marked for " + name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
