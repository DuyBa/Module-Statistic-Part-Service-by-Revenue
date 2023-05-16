/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

import static garage.DAO.DAO.con;
import garage.model.PartStat;
import garage.model.ServiceStat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author ruy_pa_
 */
public class ServiceStatDAO extends DAO {

    public ServiceStatDAO()
    {
         super();       
    }
    
    
    public ArrayList<ServiceStat> searchServiceStat(Date timeStart, Date endtime)
    {
        ArrayList<ServiceStat> result= new ArrayList<ServiceStat>();
        
        String sql= "SELECT tblService.ID, tblService.name, SUM(tblServiceUsing.quantity) as 'soluong', tblServiceUsing.price FROM tblService INNER JOIN tblServiceUsing ON tblService.ID= tblServiceUsing.ID_Service WHERE tblServiceUsing.date BETWEEN ? AND ? GROUP BY tblService.ID, tblService.name,tblServiceUsing.price"; 
        
        try
        {
      
            PreparedStatement ps= con.prepareStatement(sql);
            
            java.sql.Date aa= new java.sql.Date(timeStart.getTime());
            java.sql.Date aaa= new java.sql.Date(endtime.getTime());
            
            ps.setDate(1,aa );
            ps.setDate(2, aaa);
            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
            {
                ServiceStat servicestat= new ServiceStat();
                servicestat.setId(rs.getInt("ID"));
                servicestat.setName(rs.getString("name"));
                servicestat.setQuantity(rs.getInt("soluong"));
                servicestat.setRevenue(rs.getInt("soluong")* rs.getInt("price"));
                
                result.add(servicestat);
                
            }
            
                    Collections.sort(result, new Comparator<ServiceStat>()
                    {
                        @Override
                        public int compare(ServiceStat truoc, ServiceStat sau)
                        {
                            return sau.getRevenue()-truoc.getRevenue();
                        }
                    }
                    );
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
