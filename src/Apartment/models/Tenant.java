package Apartment.models;

import java.util.Date;

public class Tenant {
    private int S_No;
    private int register_no;
    private String Name;
    private String Block;
    private String House_No;
    private String Address;
    private String Vehicle_details;
    private Date Indate;
    private String Intime;
    private Date Outdate;
    private String Outtime;
    private String Parking_slot;

    public Tenant(int s_No, int register_no, String name, String block, String house_No, String address, String vehicle_details, Date indate, String intime, Date outdate, String outtime, String parking_slot) {
        S_No = s_No;
        this.register_no = register_no;
        Name = name;
        Block = block;
        House_No = house_No;
        Address = address;
        Vehicle_details = vehicle_details;
        Indate = indate;
        Intime = intime;
        Outdate = outdate;
        Outtime = outtime;
        Parking_slot = parking_slot;
    }

    public int getS_No() {
        return S_No;
    }

    public void setS_No(int s_No) {
        S_No = s_No;
    }

    public int getRegister_no() {
        return register_no;
    }

    public void setRegister_no(int register_no) {
        this.register_no = register_no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getVehicle_details() {
        return Vehicle_details;
    }

    public void setVehicle_details(String vehicle_details) {
        Vehicle_details = vehicle_details;
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

    public String getParking_slot() {
        return Parking_slot;
    }

    public void setParking_slot(String parking_slot) {
        Parking_slot = parking_slot;
    }

    @Override
    public String toString() {
        return S_No + "  |\t" +
                register_no + "  |\t" +
                Name + "  |\t" +
                Block + "  |\t" +
                House_No + "  |\t" +
                Address + "  |\t" +
                Vehicle_details + "  |\t" +
                Indate + "  |\t" +
                Intime + "  |\t" +
                Outdate + "  |\t" +
                Outtime + "  |\t" +
                Parking_slot + "  |\t";
    }
}
