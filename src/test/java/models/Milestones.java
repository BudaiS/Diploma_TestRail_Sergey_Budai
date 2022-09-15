package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Milestones {
    private String name;                //elements = Input, label = "Name"
    private String references;          //elements = QuestionInput, label = "refs"
    private String parent;              //elements = DropDown, label = "Parent"
    private String description;         //elements = TextArea, label = "description"
    private String startDate;           //elements = Input, label = "Start Date"
    private String endDate;             //elements = Input, label = "End Date"

}
