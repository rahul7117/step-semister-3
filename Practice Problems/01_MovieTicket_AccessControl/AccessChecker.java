public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private")) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        } else if (fieldModifier.equals("protected")) {
            return "SAME_PACKAGE".equals(accessorContext) || "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        } else if (fieldModifier.equals("default")) {
            return "SAME_PACKAGE".equals(accessorContext) || "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        } else if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;
        for (String[] attempt : attempts) {
            if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                allowed++;
            } else {
                denied++;
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}
