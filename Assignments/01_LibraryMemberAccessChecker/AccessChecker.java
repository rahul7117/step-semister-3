public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        } else if ("protected".equals(fieldModifier)) {
            return "SAME_PACKAGE".equals(accessorContext) ? "ALLOWED" : "DENIED";
        } else if ("default".equals(fieldModifier)) {
            return "SAME_PACKAGE".equals(accessorContext) ? "ALLOWED" : "DENIED";
        } else if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }
        return "UNKNOWN";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int[] privateAllowed = {0, 0};
        int[] privateDenied = {0, 0};
        int[] defaultAllowed = {0, 0};
        int[] defaultDenied = {0, 0};
        int[] protectedAllowed = {0, 0};
        int[] protectedDenied = {0, 0};
        int[] publicAllowed = {0, 0};
        int[] publicDenied = {0, 0};

        for (String[] attempt : attempts) {
            String fieldModifier = attempt[0];
            String accessorContext = attempt[1];
            if ("private".equals(fieldModifier)) {
                if ("SAME_CLASS".equals(accessorContext)) {
                    privateAllowed[0]++;
                } else {
                    privateDenied[0]++;
                }
            } else if ("protected".equals(fieldModifier)) {
                if ("SAME_PACKAGE".equals(accessorContext)) {
                    protectedAllowed[0]++;
                } else {
                    protectedDenied[0]++;
                }
            } else if ("default".equals(fieldModifier)) {
                if ("SAME_PACKAGE".equals(accessorContext)) {
                    defaultAllowed[0]++;
                } else {
                    defaultDenied[0]++;
                }
            } else if ("public".equals(fieldModifier)) {
                if ("SAME_PACKAGE".equals(accessorContext)) {
                    publicAllowed[0]++;
                } else {
                    publicDenied[0]++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("private: ").append(privateAllowed[0]).append(" allowed / ").append(privateDenied[0]).append(" denied | ");
        result.append("default: ").append(defaultAllowed[0]).append(" allowed / ").append(defaultDenied[0]).append(" denied | ");
        result.append("protected: ").append(protectedAllowed[0]).append(" allowed / ").append(protectedDenied[0]).append(" denied | ");
        result.append("public: ").append(publicAllowed[0]).append(" allowed / ").append(publicDenied[0]).append(" denied");
        return result.toString();
    }
}
