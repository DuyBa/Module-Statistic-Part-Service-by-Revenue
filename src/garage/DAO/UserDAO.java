/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

import garage.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import garage.DAO.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ruy_pa_
 */
public class UserDAO extends DAO {
    
    public UserDAO()
    {
        super();
    }
    
    public boolean checkLogin(User user)
    {
        boolean result= false;
        
        try
        {
            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url= "jdbc:sqlserver://localhost:1433;DatabaseName=garage;encrypt=true;trustServerCertificate=true;";
//            String username= "sa";
//            String password= "1234567";
//            
//            Connection con= DriverManager.getConnection(url, username, password);
            
            String sql= "SELECT name, role FROM tbluser WHERE username = ? AND password = ?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());

            
//            String sql= "SELECT tbluser_ten, tbluser_role FROM tbluser WHERE tbluser_name = 'nokidding121002@gmail.com' AND tbluser_password = '1234567'";
//            PreparedStatement ps= con.prepareStatement(sql);

            ResultSet rs= st.executeQuery();
            if(rs.next())
            {
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
                result= true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }
}
