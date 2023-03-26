package devqa_task_2023;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHelper {

    private static final String CHROME_DRIVER_PATH = "C:\\Users\\henrilaa\\Desktop\\chromedriver.exe";
    private static final String URL = "https://www.playtech.ee";
    private static final String POSITION_NAME = "Development QA Engineer (Intern)";
    private static final String RESULT_FILE_PATH = Paths.get("").toAbsolutePath().toString() + "/result.txt";

    protected static WebDriver driver;
    protected static Actions actions;

    /**
     * MAIN TASK: 1. Open a web browser at the URL https://www.playtech.ee
     * NB! chromedriver.exe needs to be installed first. https://chromedriver.chromium.org/downloads
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
    }

    /**
     * MAIN TASK: 2. Click on the internship tab.
     */
    void navigateToInternshipPage() {
        WebElement internshipTab = driver.findElement(By.linkText("INTERNSHIP"));
        internshipTab.click();
    }

    /**
     * BONUS TASK: 1. Use coordinates to click on the tab at main task step2.
     */
    void navigateToPageByCoordinatesClick() {
        WebElement internshipTab = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/nav[1]/a[4]"));
        int x = internshipTab.getLocation().getX();
        int y = internshipTab.getLocation().getY();
        actions.moveByOffset(x + 1, y + 1).click().perform();
    }

    /**
     * MAIN TASK: 3. Verify if the “Development QA Engineer (Intern)” position is shown on the page.
     */
    void verifyIfPositionIsShown(String POSITION_NAME) {
        WebElement offerSection = driver.findElement(By.xpath("//section[@id='app']"));
        List<WebElement> offers = offerSection.findElements(By.xpath("//*[contains(text(),'" + POSITION_NAME + "')]"));

        exportResultToFile(offers.size() > 0);
        String message = "Offer was not shown on the page";
        Assert.assertTrue(message,offers.size() > 0);
    }

    /**
     * BONUS TASK: 2. Export main task step 3’s result as .txt file(s).
     */
    void exportResultToFile(boolean exists) {
        try (FileWriter writer = new FileWriter(RESULT_FILE_PATH)) {
            String result = exists ? "Position " + POSITION_NAME + " is shown on the page" : "Position " + POSITION_NAME + " is not shown on the page";
            writer.write(result);
            System.out.println("Result written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing result to the file.");
            e.printStackTrace();
        }
    }

    /**
     * MAIN TASK: 4. Close the browser.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
