package utils;

import com.github.javafaker.Faker;
import models.Milestones;


public class MilestonesFactory {

    static Faker faker = new Faker();

    public static Milestones getFullInfoMilestones() {
        return Milestones.builder()
                .name(faker.name().name())
                .references(faker.book().title())
                .parent(PropertyReader.getProperty("test_rail.test_milestones_name"))
                .description(faker.random().toString())
                .startDate(PropertyReader.getProperty("test_rail.milestone_start_date"))
                .endDate(PropertyReader.getProperty("test_rail.milestone_end_date"))
                .build();
    }
}
