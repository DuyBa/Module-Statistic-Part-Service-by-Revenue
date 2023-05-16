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
public class FixedCar implements Serializable{
    private int id;
    private Date timestart;
    private Date endtime;
    private ArrayList<ServiceUsing> serviceUsing;
    private ArrayList<PartUsing> partUsing;
    private Car car;

    public FixedCar() {
    }

    public FixedCar(int id, Date timestart, Date endtime, ArrayList<ServiceUsing> serviceUsing, ArrayList<PartUsing> partUsing, Car car) {
        this.id = id;
        this.timestart = timestart;
        this.endtime = endtime;
        this.serviceUsing = serviceUsing;
        this.partUsing = partUsing;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public Date getTimestart() {
        return timestart;
    }

    public Date getEndtime() {
        return endtime;
    }

    public ArrayList<ServiceUsing> getServiceUsing() {
        return serviceUsing;
    }

    public ArrayList<PartUsing> getPartUsing() {
        return partUsing;
    }

    public Car getCar() {
        return car;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public void setServiceUsing(ArrayList<ServiceUsing> serviceUsing) {
        this.serviceUsing = serviceUsing;
    }

    public void setPartUsing(ArrayList<PartUsing> partUsing) {
        this.partUsing = partUsing;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    
    
    
    
}
