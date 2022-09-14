package constans;

public class Constant {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 5;
        public static final int ZERO_IMPLICIT_WAIT = 0;
        public static final int PAE_LOAD_TIMEOUT = 60;
        public static final int EXPLICIT_WAIT = 20;
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
        public final static String TEST_CASES_HEADER = "Test Cases";
        public final static String EXPECTED_SECTION_COUNT = "2";
        public final static String CONFIRMATION_TEST_CASE_TEXT = "Yes, delete this section (cannot be undone)";
        public final static String ACCESS_MESSAGE_TEXT = "Successfully added the new test case. Add another";
        public final static String ACCESS_DELETE_TEST_CASE_MESSAGE_TEXT = "Successfully deleted the test case.";

    }

}
