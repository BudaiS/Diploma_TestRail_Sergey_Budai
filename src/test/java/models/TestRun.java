package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestRun {
    private String name;
    private String references;
    private String milestones;
    private String assignTo;
    private String description;
}
