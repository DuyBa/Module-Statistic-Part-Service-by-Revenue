/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

import garage.model.PartStat;
import garage.model.ServiceStat;
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
public class ServiceStatDAOTest {
    
    
    
    @Test
    public void testgetservicestat1()
    {
        ServiceStatDAO psd= new ServiceStatDAO();

        Date startin = new GregorianCalendar(2023,Calendar.FEBRUARY, 01).getTime();
        Date endin= new GregorianCalendar(2023,Calendar.APRIL, 27).getTime();
        
        ArrayList<ServiceStat> lps= psd.searchServiceStat(startin, endin);
        
        Assert.assertNotNull(lps);
        Assert.assertEquals(3, lps.size());
        
        
        Assert.assertTrue(lps.get(0).getName().equalsIgnoreCase("thay dau nhot"));
        Assert.assertEquals(4, lps.get(0).getQuantity());
        Assert.assertEquals(4000000, lps.get(0).getRevenue());
        
        Assert.assertTrue(lps.get(1).getName().equalsIgnoreCase("rua xe"));
        Assert.assertEquals(3, lps.get(1).getQuantity());
        Assert.assertEquals(1500000, lps.get(1).getRevenue());
        
        
        Assert.assertTrue(lps.get(2).getName().equalsIgnoreCase("don xe"));
        Assert.assertEquals(2, lps.get(2).getQuantity());
        Assert.assertEquals(400000, lps.get(2).getRevenue());
    }
    
    @Test
    public void testgetservicestat2()
    {
        ServiceStatDAO psd= new ServiceStatDAO();

        Date startin = new GregorianCalendar(2023,Calendar.MARCH, 20).getTime();
        Date endin= new GregorianCalendar(2023,Calendar.MARCH, 20).getTime();
        
        ArrayList<ServiceStat> lps= psd.searchServiceStat(startin, endin);
        
        Assert.assertNotNull(lps);
        Assert.assertEquals(1, lps.size());
        
        
        Assert.assertTrue(lps.get(0).getName().equalsIgnoreCase("thay dau nhot"));
        Assert.assertEquals(2, lps.get(0).getQuantity());
        Assert.assertEquals(2000000, lps.get(0).getRevenue());
        
    }
    
    @Test
    public void testgetservicestat3()
    {
        ServiceStatDAO psd= new ServiceStatDAO();

        Date startin = new GregorianCalendar(2022,Calendar.MARCH, 20).getTime();
        Date endin= new GregorianCalendar(2022,Calendar.MARCH, 20).getTime();
        
        ArrayList<ServiceStat> lps= psd.searchServiceStat(startin, endin);
        
        Assert.assertNotNull(lps);
        Assert.assertEquals(0, lps.size());
        
        
    }
    
}
