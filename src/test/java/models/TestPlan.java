package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestPlan {
    private String name;
    private String milestone;
    private String description;
}
