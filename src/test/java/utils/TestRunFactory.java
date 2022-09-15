package utils;

import com.github.javafaker.Faker;
import models.TestRun;

public class TestRunFactory {
    static Faker faker = new Faker();

    public static TestRun getFullInfoTestRun() {
        return TestRun.builder()
                .name(faker.name().title())
                .references(faker.book().title())
                .milestones(PropertyReader.getProperty("test_rail.test_milestones_name"))
                .assignTo(PropertyReader.getProperty("test_rail.assign_to"))
                .description(faker.random().toString())
                .build();
    }
}
