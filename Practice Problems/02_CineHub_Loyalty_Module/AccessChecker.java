public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("protected".equals(fieldModifier)) {
            if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                return "ALLOWED";
            } else if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) {
                return "DENIED";
            }
        }
        return "DENIED"; // Default case for other modifiers or contexts
    }
}
