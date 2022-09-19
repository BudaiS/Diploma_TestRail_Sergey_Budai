package models;


import enums.AutomationType;
import enums.Priority;
import enums.Type;
import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class TestCase {
    private String title;
    private String section;
    private Type type;
    private Priority priority;
    private String estimate;
    private String references;
    private AutomationType automationType;
    private String preconditions;
    private String steps;
    private String expectedResult;


}
