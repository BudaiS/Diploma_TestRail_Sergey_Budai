package enums;

public enum Type {
    ACCEPTANCE("Acceptance"),
    ACCESSIBILITY("Accessibility"),
    AUTOMATED("Automated"),
    COMPATIBILITY("Compatibility"),
    DESTRUCTIVE("Destructive"),
    FUNCTIONAL("Functional"),
    OTHER("Other"),
    PERFORMANCE("Performance"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    SMOKE_SANITY("Smoke & Sanity"),
    USABILITY("Usability");


    private String name;

    Type(String name) {
        this.name = name;
    }

    public static Type fromString(String value) {
        for (Type contactType : Type.values()) {
            if (contactType.getName().equals(value)) {
                return contactType;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
