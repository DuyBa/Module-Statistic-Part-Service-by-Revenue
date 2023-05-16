/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.model;

import java.io.Serializable;

/**
 *
 * @author ruy_pa_
 */
public class Service implements Serializable{
    private int id;
    private String name;
    private int price;
    private String des;

    public Service() {
    }

    public Service(int id, String name, int price, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDes() {
        return des;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDes(String des) {
        this.des = des;
    }

    
    
    
    
}
