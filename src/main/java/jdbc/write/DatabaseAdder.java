package jdbc.write;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseAdder {

    PreparedStatement ps;
    ResultSet rs;

    public void addEmployees(Connection connection, long id, String name, int code, String hibrid_name,
                             String patent_number, LocalDate start_date, String patent_owner,
                             LocalDate end_date, int start_register_date) {

        String sql = "INSERT INTO hr.seed(id, name, code, hibrid_name, patent_number, " +
                "start_date, patent_owner, end_date, start_register_date)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);

            ps.setLong(1, id);
            ps.setString(2, name);
            ps.setInt(3, code);
            ps.setString(4, hibrid_name);
            ps.setString(5, patent_number);
            ps.setDate(6, Date.valueOf(start_date));
            ps.setString(7, patent_owner);
            ps.setDate(8, Date.valueOf(end_date));
            ps.setInt(9, start_register_date);

            int rows = ps.executeUpdate();

            if (rows == 1) {
                System.out.println("yeni toxum sortu elave olundu");
            } else {
                System.out.println(" xeta bas verdi");
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
