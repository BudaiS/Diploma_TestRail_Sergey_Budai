package utils;

import com.github.javafaker.Faker;
import enums.AutomationType;
import enums.Priority;
import enums.Type;
import models.TestCase;


public class TestCaseFactory {

    static Faker faker = new Faker();

    public static TestCase getFullInfoTestCase() {
        return TestCase.builder()
                .title(faker.name().title())
                .section(PropertyReader.getProperty("test_rail.test_section_name"))
                .type(Type.REGRESSION)
                .priority(Priority.HIGH)
                .estimate(faker.number().digit())
                .references(faker.book().title())
                .automationType(AutomationType.RANOREX)
                .preconditions(faker.name().lastName())
                .steps(faker.name().username())
                .expectedResult(faker.name().firstName())
                .build();
    }
}
