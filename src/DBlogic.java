import java.sql.*;

public class DBlogic {

    private final String DB = "jdbc:mysql://localhost:3306/07_crud";
    private final String USER = "root";
    private final String PASS = "qwe123";


    // connection to DB
    private Statement connectToDB() {
        Statement stmt = null;
        try {
            Connection conn = DriverManager.getConnection(DB, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }


    // insert
    public void insert() {
        try {
            // connection to DB
            Statement stmt = connectToDB();

            // sql statement to execute
            String sql = "INSERT INTO users (email, name) VALUES ('s@s.com', 'Sandra')";
            stmt.executeUpdate(sql);
            System.out.println("Dati ir ievadiiti");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // update
    public void update() {
        try {
            // connection to DB
            Statement stmt = connectToDB();

            // sql statement to execute
            String sql = "UPDATE users SET email = 'k@m.lv' WHERE id = 4";
            stmt.executeUpdate(sql);
            System.out.println("Dati ir atjaunoti");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // delete
    public void delete() {
        try {
            // connection to DB
            Statement stmt = connectToDB();

            // sql statement to execute
            String sql = "DELETE FROM users WHERE id = 4";
            stmt.executeUpdate(sql);
            System.out.println("Dati ir izdzesti");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // select
    public void select() {
        try {
            // connection to DB
            Statement stmt = connectToDB();

            // sql statement to execute
            ResultSet rs = stmt.executeQuery("SELECT id, email, name FROM users");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
