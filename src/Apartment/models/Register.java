package Apartment.models;

import java.util.Date;

public class Register {
    private int s_No;
    private int regno;
    private String Name;
    private String vehicle;
    private Date outdate;
    private String outtime;
    private Date indate;
    private String intime;

    public Register(int s_No, int regno, String name, String vehicle, Date outdate, String outtime, Date indate, String intime) {
        this.s_No = s_No;
        this.regno = regno;
        Name = name;
        this.vehicle = vehicle;
        this.outdate = outdate;
        this.outtime = outtime;
        this.indate = indate;
        this.intime = intime;
    }

    public int getS_No() {
        return s_No;
    }

    public void setS_No(int s_No) {
        this.s_No = s_No;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    @Override
    public String toString() {
        return "| " + s_No + "  |\t" +
                regno + "  |\t" +
                Name + "  |\t" +
                vehicle + "  |\t" +
                outdate + "  |\t" +
                outtime + "  |\t" +
                indate + "  |\t" +
                intime + "  |\t";
    }
}
