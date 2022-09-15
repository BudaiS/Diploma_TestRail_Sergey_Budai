package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestRun {
    private String name;                    //elements = Input, label = "Name"
    private String references;              //elements = QuestionInput, label = "refs"
    private String milestones;              //elements = DropDown, label = "Milestone"
    private String assignTo;                //elements = DropDown, label = "Assign To"
    private String description;             //elements = TextArea, label = "description"
}
