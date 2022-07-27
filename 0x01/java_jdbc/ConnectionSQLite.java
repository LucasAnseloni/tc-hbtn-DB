

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
    public static void main(String[] args) {
        initConnection();
    }

    public static void initConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sqlite_database_2022.db");
            System.out.println(connection);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if (connection != null){
                    connection.close();
                }else {
                    System.out.println("Problema com a conexão !");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
