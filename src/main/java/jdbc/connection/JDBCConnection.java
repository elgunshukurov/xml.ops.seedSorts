package jdbc.connection;

import jdbc.write.DatabaseAdder;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

public class JDBCConnection {

    public static void connect(Connection connection,long id, String name, int code, String hibrid_name,
                               String patent_number, LocalDate start_date, String patent_owner,
                               LocalDate end_date, int start_ragister_date) {

        DatabaseAdder adder = new DatabaseAdder();
        adder.addEmployees(connection, id, name, code, hibrid_name, patent_number, start_date
                , patent_owner, end_date, start_ragister_date);

    }
}
