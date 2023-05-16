/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.DAO;

/**
 *
 * @author ruy_pa_
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import garage.DAO.PartStatDAO;
import garage.model.PartStat;
import java.text.SimpleDateFormat;
public class PartStatDAOTest {
    
    
    @Test
    public void testgetpartstart1()
    {
        PartStatDAO psd= new PartStatDAO();

        Date startin = new GregorianCalendar(2023,Calendar.FEBRUARY, 01).getTime();
        Date endin= new GregorianCalendar(2023,Calendar.APRIL, 27).getTime();
        
        ArrayList<PartStat> lps= psd.searchPart(startin, endin);
        
        Assert.assertNotNull(lps);
        Assert.assertEquals(3, lps.size());
        
        
        Assert.assertTrue(lps.get(0).getName().equalsIgnoreCase("mam mercerdes"));
        Assert.assertEquals(6, lps.get(0).getQuantity());
        Assert.assertEquals(18000000, lps.get(0).getRevenue());
        
        Assert.assertTrue(lps.get(1).getName().equalsIgnoreCase("guong chieu hau mercerdes"));
        Assert.assertEquals(5, lps.get(1).getQuantity());
        Assert.assertEquals(10000000, lps.get(1).getRevenue());
        
        
        Assert.assertTrue(lps.get(2).getName().equalsIgnoreCase("vo lang mercerdes"));
        Assert.assertEquals(2, lps.get(2).getQuantity());
        Assert.assertEquals(10000000, lps.get(2).getRevenue());
        
    }
    
    @Test
    public void testgetpartstart2()
    {
        PartStatDAO psd= new PartStatDAO();

        Date startin = new GregorianCalendar(2023,Calendar.FEBRUARY, 02).getTime();
        Date endin= new GregorianCalendar(2023,Calendar.FEBRUARY, 02).getTime();
        
        ArrayList<PartStat> lps= psd.searchPart(startin, endin);
        
        Assert.assertNotNull(lps);
        Assert.assertEquals(2, lps.size());
        
        
        Assert.assertTrue(lps.get(0).getName().equalsIgnoreCase("vo lang mercerdes"));
        Assert.assertEquals(1, lps.get(0).getQuantity());
        Assert.assertEquals(5000000, lps.get(0).getRevenue());
        
        Assert.assertTrue(lps.get(1).getName().equalsIgnoreCase("guong chieu hau mercerdes"));
        Assert.assertEquals(2, lps.get(1).getQuantity());
        Assert.assertEquals(4000000, lps.get(1).getRevenue());
        
    }
    
    @Test
    public void testgetpartstart3()
    {
        PartStatDAO psd= new PartStatDAO();

        Date startin = new GregorianCalendar(2022,Calendar.FEBRUARY, 02).getTime();
        Date endin= new GregorianCalendar(2022,Calendar.FEBRUARY, 02).getTime();
        
        ArrayList<PartStat> lps= psd.searchPart(startin, endin);
        
        Assert.assertNotNull(lps);
        Assert.assertEquals(0, lps.size());
    }
}
