package Apartment.models;

import java.util.Date;

public class Guest extends BaseModel{
    private String reason;

    public Guest(int sNo,String vehicleDetails, String block, String houseNo, Date inDate, String inTime, Date outDate, String outTime, String parkingSlot, String reason) {
        super(sNo, block, houseNo, vehicleDetails, inDate, inTime, outDate, outTime, parkingSlot);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
