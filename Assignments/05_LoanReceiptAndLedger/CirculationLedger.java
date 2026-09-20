public class CirculationLedger {
    private static final String BRANCH_CODE = "PageTurner";

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
            } else if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
            processed++;
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
    }
}
