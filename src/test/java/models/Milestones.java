package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Milestones {
    private String name;
    private String references;
    private String parent;
    private String description;
    private String startDate;
    private String endDate;

}
