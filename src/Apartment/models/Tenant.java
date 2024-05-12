package Apartment.models;

import java.util.Date;

public class Tenant extends BaseModel{
    private int registerNo;
    private String name;
    private String address;

    public Tenant(int sNo, int registerNo, String name, String block, String houseNo, String address, String vehicleDetails, Date inDate, String inTime, Date outDate, String outTime, String parkingSlot) {
        super(sNo, block, houseNo, address, vehicleDetails, inDate, inTime, outDate, outTime, parkingSlot);
        this.registerNo = registerNo;
        this.name = name;
        this.address = address;
    }

    public int getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(int registerNo) {
        this.registerNo = registerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
