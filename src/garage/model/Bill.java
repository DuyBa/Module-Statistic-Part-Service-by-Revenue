/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ruy_pa_
 */
public class Bill implements Serializable{
    private int id;
    private Date date;
    private int saleoff;
    private String payby;
    private ArrayList<FixedCar> fixedCar;

    public Bill() {
    }

    
    
    public Bill(int id, Date date, int saleoff, String payby, ArrayList<FixedCar> fixedCar) {
        this.id = id;
        this.date = date;
        this.saleoff = saleoff;
        this.payby = payby;
        this.fixedCar = fixedCar;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getSaleoff() {
        return saleoff;
    }

    public String getPayby() {
        return payby;
    }

    public ArrayList<FixedCar> getFixedCar() {
        return fixedCar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }

    public void setPayby(String payby) {
        this.payby = payby;
    }

    public void setFixedCar(ArrayList<FixedCar> fixedCar) {
        this.fixedCar = fixedCar;
    }

    
    
    
}
