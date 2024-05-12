package Apartment.models;

public class DeletedRecords {
    private Tenant tenant;
    private String Reason;

    public DeletedRecords(Tenant tenant, String reason) {
        this.tenant = tenant;
        Reason = reason;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    @Override
    public String toString() {
        return "| " + tenant + Reason + " |";
    }
}
