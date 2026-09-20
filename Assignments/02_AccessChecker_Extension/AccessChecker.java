package library.access;

public class AccessChecker {
    public static final String DENIED = "DENIED";
    public static final String ALLOWED = "ALLOWED";

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private") || fieldModifier.equals("default")) {
            return DENIED;
        } else if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                return ALLOWED;
            } else if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
                return DENIED;
            }
        }
        return "UNKNOWN";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String fieldModifier = attempts[i][0];
            String accessorContext = attempts[i][1];
            if (classifyAccess(fieldModifier, accessorContext).equals(DENIED)) {
                return fieldModifier + " via " + accessorContext + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}
