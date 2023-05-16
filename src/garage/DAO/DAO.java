/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ruy_pa_
 */
public class DAO {
    public static Connection con;
    
    public DAO() 
    {
        if(con== null)
        {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://localhost:1433;DatabaseName=garage;encrypt=true;trustServerCertificate=true;";
            String username= "sa";
            String password= "1234567";    
            con= DriverManager.getConnection(url, username, password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }
}
