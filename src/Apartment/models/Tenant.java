package Apartment.models;

import java.util.Date;

public class Tenant {
    private int sNo;
    private int registerNo;
    private String name;
    private String block;
    private String houseNo;
    private String address;
    private String vehicleDetails;
    private Date inDate;
    private String inTime;
    private Date outDate;
    private String outTime;
    private String parkingSlot;

    public Tenant(int sNo, int registerNo, String name, String block, String houseNo, String address, String vehicleDetails, Date inDate, String inTime, Date outDate, String outTime, String parkingSlot) {
        this.sNo = sNo;
        this.registerNo = registerNo;
        this.name = name;
        this.block = block;
        this.houseNo = houseNo;
        this.address = address;
        this.vehicleDetails = vehicleDetails;
        this.inDate = inDate;
        this.inTime = inTime;
        this.outDate = outDate;
        this.outTime = outTime;
        this.parkingSlot = parkingSlot;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
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

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
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

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    @Override
    public String toString() {
        return sNo + " |\t " +
                registerNo + " |\t" +
                name + " |\t" +
                block + " |\t" +
                houseNo + " |\t" +
                address + " |\t" +
                vehicleDetails + " |\t" +
                inDate + " |\t " +
                inTime + " |\t " +
                outDate + " |\t " +
                outTime + " |\t " +
                parkingSlot + " |\t ";
    }
}
