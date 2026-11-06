import java.sql.*;

public class connect {
    public static void main(String[] args) {
        //databse url
        String url="jdbc:mysql://localhost:3306/psim";
        String username="root";
        String password="root";
        String query="SELECT * FROM demo";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("EmpId");
                String name = rs.getString("EName");
                double salary = rs.getDouble("Salary");

                System.out.println();
                System.out.println("====================");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
