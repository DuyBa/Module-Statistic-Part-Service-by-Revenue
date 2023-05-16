/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.model;

import java.util.Date;

/**
 *
 * @author ruy_pa_
 */
public class PartStat extends Part{

    private int revenue;
    private int quantity;

    public PartStat() {
    }

    public PartStat(int revenue, int quantity) {
        this.revenue = revenue;
        this.quantity = quantity;
    }

    public PartStat(int revenue, int quantity, int id, String name, String des, int price) {
        super(id, name, des, price);
        this.revenue = revenue;
        this.quantity = quantity;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    
}
