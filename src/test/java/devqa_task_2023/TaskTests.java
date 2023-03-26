package devqa_task_2023;

import org.junit.Test;

public class TaskTests extends TestHelper {
    @Test
    public void verifyPositionShownOnInternshipPage() {
        navigateToInternshipPage();
        verifyIfPositionIsShown();
    }

    @Test
    public void verifyPositionShownOnPageUsingCoordinates() {
        navigateToPageByCoordinatesClick();
        verifyIfPositionIsShown();
    }
}
