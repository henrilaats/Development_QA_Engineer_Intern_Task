package devqa_task_2023;

import org.junit.Test;

public class TaskTests extends TestHelper {

    private static final String POSITION_NAME = "Development QA Engineer (Intern)";

    @Test
    public void verifyPositionShownOnInternshipPage() {
        navigateToInternshipPage();
        verifyIfPositionIsShown(POSITION_NAME);
    }

    @Test
    public void verifyPositionShownOnPageUsingCoordinates() {
        navigateToPageByCoordinatesClick();
        verifyIfPositionIsShown(POSITION_NAME);
    }
}