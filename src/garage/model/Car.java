/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.model;

/**
 *
 * @author ruy_pa_
 */
public class Car {
    private int id;
    private String name;
    private String tier;
    private String note;
    private Client client;

    public Car(int id, String name, String tier, String note, Client client) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.note = note;
        this.client = client;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTier() {
        return tier;
    }

    public String getNote() {
        return note;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    
    
}
