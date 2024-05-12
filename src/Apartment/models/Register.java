package Apartment.models;

import java.util.Date;

public class Register {
    private int sNo;
    private int regNo;
    private String name;
    private String vehicle;
    private Date outDate;
    private String outTime;
    private Date inDate;
    private String inTime;

    public Register(int sNo, int regNo, String name, String vehicle, Date outDate, String outTime, Date inDate, String inTime) {
        this.sNo = sNo;
        this.regNo = regNo;
        this.name = name;
        this.vehicle = vehicle;
        this.outDate = outDate;
        this.outTime = outTime;
        this.inDate = inDate;
        this.inTime = inTime;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    @Override
    public String toString() {
        return "| " + sNo + "  |\t" +
                regNo + "  |\t" +
                name + "  |\t" +
                vehicle + "  |\t" +
                outDate + "  |\t" +
                outTime + "  |\t" +
                inDate + "  |\t" +
                inTime + "  |\t";
    }
}
