package enums;

public enum AutomationType {
    NONE("None"),
    RANOREX("Ranorex");


    private String name;

    AutomationType(String name) {
        this.name = name;
    }

    public static AutomationType fromString(String value) {
        for (AutomationType contactAutomationType : AutomationType.values()) {
            if (contactAutomationType.getName().equals(value)) {
                return contactAutomationType;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
