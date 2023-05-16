/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ruy_pa_
 */
public class PartUsing implements Serializable{
    private int id;
    private Date date;
    private int quantity;
    private int price;
    private Part part;

    public PartUsing() {
    }

    public PartUsing(int id, Date date, int quantity, int price, Part part) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.part = part;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Part getPart() {
        return part;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    

    
}
