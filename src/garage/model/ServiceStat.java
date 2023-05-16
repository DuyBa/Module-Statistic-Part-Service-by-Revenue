/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.model;

/**
 *
 * @author ruy_pa_
 */
public class ServiceStat extends Service {
    private int revenue;
    private int quantity;

    public ServiceStat() {
    }

    public ServiceStat(int revenue, int quantity) {
        this.revenue = revenue;
        this.quantity = quantity;
    }

    public ServiceStat(int revenue, int quantity, int id, String name, int price, String des) {
        super(id, name, price, des);
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
