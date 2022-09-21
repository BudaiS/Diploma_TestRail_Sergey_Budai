package constans;

public class Constant {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 5;
        public static final int ZERO_IMPLICIT_WAIT = 0;
        public static final int PAE_LOAD_TIMEOUT = 60;
        public static final int EXPLICIT_WAIT = 30;
    }

    public static class LoginTestsConstants {
        public final static String ERROR_MESSAGE_TEXT = "Email/Login or Password is incorrect. Please try again.";
        public final static String INCORRECT_EMAIL = "abcd";
        public final static String INCORRECT_PASSWORD = "abcde";
    }

    public static class ProjectTestsConstants {
        public final static String EXPECTED_SUCCESS_MESSAGE = "Successfully added the new project.";
        public final static String EXPECTED_DELETE_SUCCESS_MESSAGE = "Successfully deleted the project.";
        public final static String CONFIRMATION_TEXT = "Yes, delete this project (cannot be undone)";
    }

    public static class TestCaseTestsConstants {
        public final static String TEST_CASE_BUTTON_NAME = "Add Test Case";
        public final static String TEST_CASES_HEADER = "Test Cases";
        public final static String EXPECTED_SECTION_COUNT = "2";
        public final static String CONFIRMATION_TEST_CASE_TEXT = "Yes, delete this section (cannot be undone)";
        public final static String ACCESS_MESSAGE_TEXT = "Successfully added the new test case. Add another";
        public final static String ACCESS_DELETE_TEST_CASE_MESSAGE_TEXT = "Successfully deleted the test case.";

    }

    public static class MilestonesTestsConstants {
        public final static String MILESTONES_HEADER = "Milestones";
        public final static String MILESTONE_BUTTON_NAME = "Add Milestone";
        public final static String EXPECTED_ACCESS_MESSAGE_TEXT = "Successfully added the new milestone.";
        public final static String EXPECTED_DELETE_MESSAGE_TEXT = "Successfully deleted the milestone (s).";
    }

    public static class TestRunsResultsTestsConstants {
        public final static String TEST_RUNS_RESULTS_HEADER = "Test Runs & Results";
        public final static String EXPECTED_ACCESS_TEST_RUN_MESSAGE_TEXT = "Successfully added the new test run.";
        public final static String CONFIRM_DELETE_TEST_RUN_TEXT = "Yes, delete this test run (cannot be undone)";
        public final static String EXPECTED_DELETE_TEST_RUN_MESSAGE_TEXT = "Successfully deleted the test run.";
        public final static String TEST_RUN_BUTTON_NAME = "Add Test Run";
        public final static String TEST_PLAN_BUTTON_NAME = "Add Test Plan";
        public final static String EXPECTED_ACCESS_TEST_PLAN_MESSAGE_TEXT = "Successfully added the new test plan.";
        public final static String CONFIRM_DELETE_TEST_PLAN_TEXT = "Yes, delete this test plan (cannot be undone)";
        public final static String EXPECTED_DELETE_TEST_PLAN_MESSAGE_TEXT = "Successfully deleted the test plan and the related test runs.";
    }

    public static class ReportsTestsConstants {
        public final static String REPORTS_HEADER = "Reports";
        public final static String EXPECTED_ACCESS_REPORT_MESSAGE_TEXT = "Successfully added the new report/scheduled report.";
        public final static String EXPECTED_DELETE_REPORT_MESSAGE_TEXT = "Report deleted";
    }


}
