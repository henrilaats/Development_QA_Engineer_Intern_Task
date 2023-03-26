# Solution to Development QA_Engineer Intern position task.

[Link to the task](https://playtech-my.sharepoint.com/:w:/p/kelly_reisbich/EZ2LWXhIC8BElSS_e3jlPosBl3M28Kjq5dFGF0eBjU4lpg?e=P1a9gX)

### Aim of the task
To verify if the "Development QA Engineer (Intern)" is shown on INTERNSHIP tab at the URL https://www.playtech.ee.

### Solution

The project includes two unit tests in the TaskTests.java class. 
One test clicks the INTERNSHIP tab using driver.findElement(By.linkText("INTERNSHIP")), and the other one uses coordinates to click on the INTERNSHIP tab.

**Before running the program:**

* Install chromedriver.exe first: https://chromedriver.chromium.org/downloads
* Change the chromedriver.exe path in the setUp() function of the TestHelper.java class.

**Running the tests:**

* Option 1: Run the tests in the IDE.
* Option 2: Maven -> Lifecycle -> test.
