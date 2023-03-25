package devqa_task_2023;

import org.junit.Test;

public class TaskTests extends TestHelper {

    @Test
    public void isPositionShown() {
        goToPage("INTERNSHIP");
        verifyIfPositionIsShown("Development QA Engineer (Intern)");
    }

    @Test
    public void isPositionShownCoordinates() {
        goToPageByCoordinatesClick();
        verifyIfPositionIsShown("Development QA Engineer (Intern)");
    }
}