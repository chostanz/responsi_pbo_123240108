package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Koneksi {
    public Connection connection;
    String url = "jdbc:mysql://localhost:3306/karyawan_db";
    String user = "root";
    String pass = "";
    
    public Koneksi(){
        try{
            connection = DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi Berhasil");
            System.out.println("Koneksi Berhasil");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
