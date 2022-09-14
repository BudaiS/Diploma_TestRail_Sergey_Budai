package models;


import enums.AutomationType;
import enums.Priority;
import enums.Type;
import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class TestCase {
    private String title;                   //elements = Input, label = "Title"
    private String section;                //elements = DropDown, label = "Section"
    private Type type;                      //elements = DropDown, label = "Type"
    private Priority priority;              //elements = DropDown, label = "Priority"
    private String estimate;                //elements = Input, label = "Esimate"
    private String references;              //elements = QuestionInput, label = "refs"
    private AutomationType automationType;  //elements = DropDown, label = "Automation Type"
    private String preconditions;           //elements = TextArea, label = "custom_preconds"
    private String steps;                   //elements = TextArea, label = "custom_steps"
    private String expectedResult;          //elements = TextArea, label = "custom_expected"


}
