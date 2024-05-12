package Apartment.models;

import java.util.Date;

public class Guest {
    private int sNo;
    private String vehicleDetails;
    private String block;
    private String houseNo;
    private Date inDate;
    private String inTime;
    private Date outDate;
    private String outTime;
    private String parkingSlot;

    private String reason;


    public Guest(String vehicleDetails, String block, String houseNo, Date inDate, String inTime, String parkingSlot, String reason) {
        this.vehicleDetails = vehicleDetails;
        this.block = block;
        this.houseNo = houseNo;
        this.inDate = inDate;
        this.inTime = inTime;
        this.parkingSlot = parkingSlot;
        this.reason = reason;
    }

    public Guest(int sNo, String vehicleDetails, String block, String houseNo, Date inDate, String inTime, Date outDate, String outTime, String parkingSlot, String reason) {
        this.sNo = sNo;
        this.vehicleDetails = vehicleDetails;
        this.block = block;
        this.houseNo = houseNo;
        this.inDate = inDate;
        this.inTime = inTime;
        this.outDate = outDate;
        this.outTime = outTime;
        this.parkingSlot = parkingSlot;
        this.reason = reason;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return sNo + " | \t" +
                vehicleDetails + " | \t" +
                block + " | \t" +
                houseNo + " | \t" +
                inDate + " | \t" +
                inTime + " | \t" +
                outDate + " | \t" +
                outTime + " | \t" +
                parkingSlot + " | \t" +
                reason + " | \t";
    }
}
