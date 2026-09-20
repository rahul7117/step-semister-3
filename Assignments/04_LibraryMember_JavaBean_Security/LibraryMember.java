public class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
        // No-argument constructor
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        if (securityAnswer == null) {
            securityAnswer = transform(answer);
        }
    }

    private String transform(String input) {
        // Simple one-way transformation (e.g., reverse the string)
        return new StringBuilder(input).reverse().toString();
    }
}
