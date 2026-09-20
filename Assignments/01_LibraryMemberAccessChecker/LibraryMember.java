public class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    // Getters and setters for the fields
    public String getMembershipPin() {
        return membershipPin;
    }

    public void setMembershipPin(String membershipPin) {
        this.membershipPin = membershipPin;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public double getFinesOwed() {
        return finesOwed;
    }

    public void setFinesOwed(double finesOwed) {
        this.finesOwed = finesOwed;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
