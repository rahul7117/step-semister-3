public class Main {
    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")); // Output: ALLOWED
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")); // Output: DENIED
    }
}
