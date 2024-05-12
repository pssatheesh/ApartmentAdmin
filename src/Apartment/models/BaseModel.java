package Apartment.models;

import java.util.Date;

public class BaseModel {
        private int sNo;
        private String block;
        private String houseNo;
        private String vehicleDetails;
        private Date inDate;
        private String inTime;
        private Date outDate;
        private String outTime;
        private String parkingSlot;

    public BaseModel(int sNo, String block, String houseNo, String vehicleDetails, Date inDate, String inTime, Date outDate, String outTime, String parkingSlot) {
        this.sNo = sNo;
        this.block = block;
        this.houseNo = houseNo;
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
}
