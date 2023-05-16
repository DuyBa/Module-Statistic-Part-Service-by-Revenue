/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

import static garage.DAO.DAO.con;
import garage.model.PartStat;
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
public class PartStatDAO extends DAO{
        public PartStatDAO()
    {
        super();
    }
    
    
    public ArrayList<PartStat> searchPart(Date timeStart, Date endtime)
    {
        ArrayList<PartStat> result= new ArrayList<PartStat>();
        
        String sql= "SELECT tblPart.ID, tblPart.name, SUM(tblPartUsing.quantity) as 'soluong', tblPartUsing.price FROM tblPart INNER JOIN tblPartUsing ON tblPart.ID= tblPartUsing.ID_Part WHERE tblPartUsing.date BETWEEN ? AND ? GROUP BY tblPart.ID, tblPart.name,tblPartUsing.price"; 
        
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
                PartStat partstat= new PartStat();
                partstat.setId(Integer.parseInt(rs.getString("ID")));
                partstat.setName(rs.getString("name"));
                partstat.setQuantity(rs.getInt("soluong"));
                partstat.setRevenue(rs.getInt("soluong")* rs.getInt("price"));
                
                result.add(partstat);
                
            }
            
            Collections.sort(result, new Comparator<PartStat>()
            {
                @Override
                public int compare(PartStat truoc, PartStat sau)
                {
                    return sau.getRevenue()-truoc.getRevenue();
                }
            });
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
