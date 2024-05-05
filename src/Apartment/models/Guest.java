package Apartment.models;

import java.util.Date;

public class Guest {
    private int id;
    private String Vehicle_details;
    private String Block;
    private String House_No;
    private String Parking_Slot;
    private String Reason;
    private Date Indate;
    private String Intime;
    private Date Outdate;
    private String Outtime;

    public Guest(int id, String vehicle_details, String block, String house_No, Date indate, String intime, Date outdate, String outtime, String parking_Slot, String reason) {
        this.id = id;
        Vehicle_details = vehicle_details;
        Block = block;
        House_No = house_No;
        Parking_Slot = parking_Slot;
        Reason = reason;
        Indate = indate;
        Intime = intime;
        Outdate = outdate;
        Outtime = outtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_details() {
        return Vehicle_details;
    }

    public void setVehicle_details(String vehicle_details) {
        Vehicle_details = vehicle_details;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String block) {
        Block = block;
    }

    public String getHouse_No() {
        return House_No;
    }

    public void setHouse_No(String house_No) {
        House_No = house_No;
    }

    public String getParking_Slot() {
        return Parking_Slot;
    }

    public void setParking_Slot(String parking_Slot) {
        Parking_Slot = parking_Slot;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Date getIndate() {
        return Indate;
    }

    public void setIndate(Date indate) {
        Indate = indate;
    }

    public String getIntime() {
        return Intime;
    }

    public void setIntime(String intime) {
        Intime = intime;
    }

    public Date getOutdate() {
        return Outdate;
    }

    public void setOutdate(Date outdate) {
        Outdate = outdate;
    }

    public String getOuttime() {
        return Outtime;
    }

    public void setOuttime(String outtime) {
        Outtime = outtime;
    }

    @Override
    public String toString() {
        return "| " + id + "  |\t" + Vehicle_details + "  |\t" + Block + "  |\t" +
                House_No + " |\t" +
                Indate + "   |\t" +
                Intime + "  |\t" +
                Outdate + "  |\t" +
                Outtime + " |\t" +
                Parking_Slot + "     |\t" +
                Reason + " \t| ";
    }
}
