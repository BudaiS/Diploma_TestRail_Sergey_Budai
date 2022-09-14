package enums;


public enum Priority {
    CRITICAL("Critical"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String name;

    Priority(String name) {
        this.name = name;
    }

    public static Priority fromString(String value) {
        for (Priority contactPriority : Priority.values()) {
            if (contactPriority.getName().equals(value)) {
                return contactPriority;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
