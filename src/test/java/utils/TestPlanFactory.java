package utils;

import com.github.javafaker.Faker;
import models.TestPlan;


public class TestPlanFactory {

    static Faker faker = new Faker();

    public static TestPlan getFullInfoTestPlan() {
        return TestPlan.builder()
                .name(faker.name().title())
                .milestone(PropertyReader.getProperty("test_rail.test_milestones_name"))
                .description(faker.random().toString())
                .build();
    }
}
