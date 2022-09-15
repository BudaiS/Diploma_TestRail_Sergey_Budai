package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestPlan {
    private String name;
    private String milestone;           //elements = DropDown, label = "Milestone"
    private String description;         //elements = TextArea, label = "description"
}
