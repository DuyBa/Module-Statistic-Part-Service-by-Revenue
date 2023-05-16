/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

import garage.model.Bill;
import garage.model.Part;
import garage.model.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ruy_pa_
 */
public class BillDAOTest {
    
    @Test
    public void testgetbilbypart()
    {
        BillDAO bd= new BillDAO();
        
        Part p= new Part();
        p.setId(3);
        Date startin = new GregorianCalendar(2023,Calendar.FEBRUARY, 01).getTime();
        Date endin= new GregorianCalendar(2023,Calendar.APRIL, 27).getTime();
        
        ArrayList<Bill> lb= bd.searchBill(startin, endin, p);
        
        Assert.assertNotNull(lb);
        Assert.assertEquals(2, lb.size());
        
        
        Assert.assertTrue(lb.get(1).getFixedCar().get(0).getCar().getName().equalsIgnoreCase("mercerdes glc250"));
        Assert.assertTrue(String.valueOf(lb.get(1).getFixedCar().get(0).getPartUsing().get(0).getDate()).equalsIgnoreCase("2023-03-07"));
        Assert.assertTrue(lb.get(1).getFixedCar().get(0).getCar().getClient().getName().equalsIgnoreCase("Do Dinh Trong"));
        Assert.assertTrue(lb.get(1).getFixedCar().get(0).getPartUsing().get(0).getPart().getName().equalsIgnoreCase("mam mercerdes"));
        Assert.assertEquals(3000000, lb.get(1).getFixedCar().get(0).getPartUsing().get(0).getPrice());
        Assert.assertEquals(4, lb.get(1).getFixedCar().get(0).getPartUsing().get(0).getQuantity());
        Assert.assertEquals(12000000, lb.get(1).getFixedCar().get(0).getPartUsing().get(0).getPrice()* lb.get(1).getFixedCar().get(0).getPartUsing().get(0).getQuantity());
//        
//        
        Assert.assertTrue(lb.get(0).getFixedCar().get(0).getCar().getName().equalsIgnoreCase("mercerdes glc300"));
        Assert.assertTrue(String.valueOf(lb.get(0).getFixedCar().get(0).getPartUsing().get(0).getDate()).equalsIgnoreCase("2023-04-12"));
        Assert.assertTrue(lb.get(0).getFixedCar().get(0).getCar().getClient().getName().equalsIgnoreCase("Do Dieu Long"));
        Assert.assertTrue(lb.get(0).getFixedCar().get(0).getPartUsing().get(0).getPart().getName().equalsIgnoreCase("mam mercerdes"));
        Assert.assertEquals(3000000, lb.get(0).getFixedCar().get(0).getPartUsing().get(0).getPrice());
        Assert.assertEquals(2, lb.get(0).getFixedCar().get(0).getPartUsing().get(0).getQuantity());
        Assert.assertEquals(6000000, lb.get(0).getFixedCar().get(0).getPartUsing().get(0).getPrice()* lb.get(0).getFixedCar().get(0).getPartUsing().get(0).getQuantity());
 

        
    }
    
    @Test
    public void testgetbilbyservice()
    {
        BillDAO bd= new BillDAO();
        
        Service p= new Service();
        p.setId(3);
        Date startin = new GregorianCalendar(2023,Calendar.FEBRUARY, 01).getTime();
        Date endin= new GregorianCalendar(2023,Calendar.APRIL, 27).getTime();
        
        ArrayList<Bill> lb= bd.searchBill(startin, endin, p);
        
        Assert.assertNotNull(lb);
        Assert.assertEquals(2, lb.size());
        
        
        Assert.assertTrue(lb.get(0).getFixedCar().get(0).getCar().getName().equalsIgnoreCase("mercerdes glc250"));
        Assert.assertTrue(String.valueOf(lb.get(0).getFixedCar().get(0).getServiceUsing().get(0).getDate()).equalsIgnoreCase("2023-03-30"));
        Assert.assertTrue(lb.get(0).getFixedCar().get(0).getCar().getClient().getName().equalsIgnoreCase("Do Dinh Trong"));
        Assert.assertTrue(lb.get(0).getFixedCar().get(0).getServiceUsing().get(0).getService().getName().equalsIgnoreCase("don xe"));
        Assert.assertEquals(200000, lb.get(0).getFixedCar().get(0).getServiceUsing().get(0).getPrice());
        Assert.assertEquals(1, lb.get(0).getFixedCar().get(0).getServiceUsing().get(0).getQuantity());
        Assert.assertEquals(200000, lb.get(0).getFixedCar().get(0).getServiceUsing().get(0).getPrice()* lb.get(0).getFixedCar().get(0).getServiceUsing().get(0).getQuantity());
        
        
        Assert.assertTrue(lb.get(1).getFixedCar().get(0).getCar().getName().equalsIgnoreCase("mercerdes glc250"));
        Assert.assertTrue(String.valueOf(lb.get(1).getFixedCar().get(0).getServiceUsing().get(0).getDate()).equalsIgnoreCase("2023-03-05"));
        Assert.assertTrue(lb.get(1).getFixedCar().get(0).getCar().getClient().getName().equalsIgnoreCase("Do Dinh Trong"));
        Assert.assertTrue(lb.get(1).getFixedCar().get(0).getServiceUsing().get(0).getService().getName().equalsIgnoreCase("don xe"));
        Assert.assertEquals(200000, lb.get(1).getFixedCar().get(0).getServiceUsing().get(0).getPrice());
        Assert.assertEquals(1, lb.get(1).getFixedCar().get(0).getServiceUsing().get(0).getQuantity());
        Assert.assertEquals(200000, lb.get(1).getFixedCar().get(0).getServiceUsing().get(0).getPrice()* lb.get(1).getFixedCar().get(0).getServiceUsing().get(0).getQuantity());
    }
    
}
