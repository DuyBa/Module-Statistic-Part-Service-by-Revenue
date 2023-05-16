/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

import garage.model.Bill;
import garage.model.Car;
import garage.model.Client;
import garage.model.FixedCar;
import garage.model.Part;
import garage.model.PartUsing;
import garage.model.Service;
import garage.model.ServiceUsing;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ruy_pa_
 */
public class BillDAO extends DAO{
    
    
    public BillDAO()
    {
        super();
    }
    
    public ArrayList<Bill> searchBill(Date timeStart, Date endTime, Part part)
    {
        ArrayList<Bill> result= new ArrayList<>();
        
        String sql= " select tblPartUsing.date, tblClient.name, tblCar.name as 'car name', tblPart.name as 'part name', tblPartUsing.price , tblPartUsing.quantity from ((((tblPartUsing full join tblPart on tblPartUsing.ID_Part= tblPart.ID) full join tblFixedCar on tblFixedCar.ID= tblPartUsing.ID_FixedCar) full join tblCar on tblCar.ID= tblFixedCar.ID_Car) full join tblClient on tblClient.ID= tblCar.ID_Client) where tblPart.ID= ? and tblPartUsing.date BETWEEN ? AND ? GROUP BY tblPartUsing.date,tblClient.name, tblCar.name, tblPart.name, tblPartUsing.price, tblPartUsing.quantity";
        
        try{
            
            PreparedStatement ps= con.prepareStatement(sql);
            
            java.sql.Date aa= new java.sql.Date(timeStart.getTime());
            java.sql.Date aaa= new java.sql.Date(endTime.getTime());
            
            ps.setInt(1, part.getId());
            ps.setDate(2, aa);
            ps.setDate(3, aaa);
            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
            {
                
                Bill bill= new Bill();
                FixedCar fc= new FixedCar();
                Car car= new Car();
                Client client= new Client();
                PartUsing pu= new PartUsing();
                Part ppp= new Part();
                
                ppp.setName(rs.getString("part name"));
                               
                pu.setDate(rs.getDate("date"));
                pu.setPrice(rs.getInt("price"));
                pu.setQuantity(rs.getInt("quantity"));
                pu.setPart(ppp);
                
                ArrayList<PartUsing> listpu= new ArrayList<>();
                listpu.add(pu);
                
                client.setName(rs.getString("name"));
                
                car.setClient(client);
                car.setName(rs.getString("car name"));
                
                ArrayList<FixedCar> listfc= new ArrayList<>();
                
                fc.setCar(car);
                fc.setPartUsing(listpu);
//                fc.getPartUsing().add(pu);
                
                listfc.add(fc);

                bill.setFixedCar(listfc);
                
                result.add(bill);
                
                
            }
            Collections.sort(result, new Comparator<Bill>()
        {
            @Override
            public int compare(Bill truoc, Bill sau)
            {
                String ngaytruoc= String.valueOf(truoc.getFixedCar().get(0).getPartUsing().get(0).getDate());
                String ngaysau= String.valueOf(sau.getFixedCar().get(0).getPartUsing().get(0).getDate());
                return ngaysau.compareTo(ngaytruoc);
            }
        }
        );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public ArrayList<Bill> searchBill(Date timeStart, Date endTime, Service service)
    {
        ArrayList<Bill> result= new ArrayList<>();
        
        String sql= " select tblServiceUsing.date, tblClient.name, tblCar.name as 'car name', tblService.name as 'Service name', tblServiceUsing.price , tblServiceUsing.quantity from ((((tblServiceUsing full join tblService on tblServiceUsing.ID_Service= tblService.ID) full join tblFixedCar on tblFixedCar.ID= tblServiceUsing.ID_FixedCar) full join tblCar on tblCar.ID= tblFixedCar.ID_Car) full join tblClient on tblClient.ID= tblCar.ID_Client) where tblService.ID= ? and tblServiceUsing.date BETWEEN ? AND ? GROUP BY tblServiceUsing.date,tblClient.name, tblCar.name, tblService.name, tblServiceUsing.price, tblServiceUsing.quantity";
        
        try{
            
            PreparedStatement ps= con.prepareStatement(sql);
            
            java.sql.Date aa= new java.sql.Date(timeStart.getTime());
            java.sql.Date aaa= new java.sql.Date(endTime.getTime());
            
            ps.setInt(1, service.getId());
            ps.setDate(2, aa);
            ps.setDate(3, aaa);
            
            ResultSet rs= ps.executeQuery();
            
            while(rs.next())
            {
                
                Bill bill= new Bill();
                FixedCar fc= new FixedCar();
                Car car= new Car();
                Client client= new Client();
                ServiceUsing pu= new ServiceUsing();
                Service ppp= new Service();
                
                ppp.setName(rs.getString("Service name"));
                               
                pu.setDate(rs.getDate("date"));
                pu.setPrice(rs.getInt("price"));
                pu.setQuantity(rs.getInt("quantity"));
                pu.setService(ppp);
                
                ArrayList<ServiceUsing> listpu= new ArrayList<>();
                listpu.add(pu);
                
                client.setName(rs.getString("name"));
                
                car.setClient(client);
                car.setName(rs.getString("car name"));
                
                ArrayList<FixedCar> listfc= new ArrayList<>();
                
                fc.setCar(car);
                fc.setServiceUsing(listpu);
//                fc.getPartUsing().add(pu);
                
                listfc.add(fc);

                bill.setFixedCar(listfc);
                
                result.add(bill);
                
                
            }
                    Collections.sort(result, new Comparator<Bill>()
        {
            @Override
            public int compare(Bill truoc, Bill sau)
            {
                String ngaytruoc= String.valueOf(truoc.getFixedCar().get(0).getServiceUsing().get(0).getDate());
                String ngaysau= String.valueOf(sau.getFixedCar().get(0).getServiceUsing().get(0).getDate());
                return ngaysau.compareTo(ngaytruoc);
            }
        }
        );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }
    
//    public static void main(String[] args) throws ParseException {
//        BillDAO a= new BillDAO();
//        
//        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                    Date startin = dateFormat.parse("2023-02-01");
//                    SimpleDateFormat dateFormatt = new SimpleDateFormat("yyyy-MM-dd");
//                    Date endin= dateFormatt.parse("2023-04-27");
//                    Part part= new Part();
//                    part.setId(2);
//        
//        for(Bill i: a.searchBill(startin, endin, part))
//        {
//            System.out.println(i.getFixedCar().get(0).getCar().getClient().getName());
//        }
//    }
}
