package utils;

import com.github.javafaker.Faker;
import models.Reports;

public class ReportsFactory {
    static Faker faker = new Faker();

    public static Reports getMinInfoReports() {
        return Reports.builder()
                .name(PropertyReader.getProperty("test_rail.test_report_name"))
                .description(faker.name().username())
                .build();
    }

}
