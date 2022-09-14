package enums;

public enum Template {
    EXPLORATORY_SESSION("Exploratory Session"),
    TEST_CASE_STEPS("Test Case (Steps)"),
    TEST_CASE_TEXT("Test Case (Text)");

    private String name;

    Template(String name) {
        this.name = name;
    }

    public static Template fromString(String value) {
        for (Template contactTemplate : Template.values()) {
            if (contactTemplate.getName().equals(value)) {
                return contactTemplate;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
