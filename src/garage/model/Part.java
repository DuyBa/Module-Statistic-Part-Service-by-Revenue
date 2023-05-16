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
public class Part implements Serializable{
    private int id;
    private String name;
    private String des;
    private int price;

    public Part() {
    }

    public Part(int id, String name, String des, int price) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
    
}
