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
public class Client implements Serializable{
    private int id;
    private String name;
    private String tel;
    private String addressl;
    private String note;
    private String email;

    public Client() {
    }

    public Client(int id, String name, String tel, String addressl, String note, String email) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.addressl = addressl;
        this.note = note;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getAddressl() {
        return addressl;
    }

    public String getNote() {
        return note;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddressl(String addressl) {
        this.addressl = addressl;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
 
    
}