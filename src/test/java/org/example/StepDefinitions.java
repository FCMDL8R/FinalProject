package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.EnrollmentPage;
import pageobjects.MainPage;
import utils.Utils;

public class StepDefinitions {

    private final WebDriver driver = new ChromeDriver();
    MainPage mainPage;
    EnrollmentPage enrollmentPage;

    public StepDefinitions() {
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        }
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    // Main Page
    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
        driver.get("file:///Users/madscientist/Desktop/Azimut%20stuff%20xD/testingenv/Testing-Env/index.html");
    }

    @Then("The page title should say {string}")
    public void thePageTitleShouldSay(String pageTitle) {
        Assert.assertTrue(driver.getTitle().startsWith(pageTitle));
    }

    @When("I click on the What You'll Learn navigation button")
    public void iClickOnTheNavigationWhatYouLearnButton() {
        mainPage.clickWhatYouLearnNavigationButton();
    }

    @Then("I should see the Learn The Fundamentals heading")
    public void iShouldSeeTheLearnTheFundamentalsHeading() {
        Assert.assertTrue(mainPage.isLearnFundamentalsTextDisplayed());
    }

    @And("I type {string} in the email field")
    public void iTypeInTheEmailField(String textToType) {
        mainPage.typeSomethingInEmailField(textToType);
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        mainPage.clickSubmitEmailButton();
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see a pop-up saying {string}")
    public void iShouldSeeAPopUpSaying(String alertMessage) {
        Assert.assertTrue(driver.switchTo().alert().getText().contains(alertMessage));
        driver.switchTo().alert().accept();
    }

    @Then("I should see a red outline on the email input field")
    public void iShouldSeeARedOutlineOnTheEmailInputField() {
        Assert.assertTrue(mainPage.isEmailValid());
    }

    @And("I scroll to the Frequently Asked Questions element")
    public void iScrollToTheFrequentlyAskedQuestionsElement() {
        Utils.scrollToElement(driver, mainPage.getHeadingTextFAQ());
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the first question")
    public void iClickOnTheFirstQuestion() {
        mainPage.clickFirstQuestion();
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the answer to the question")
    public void iShouldSeeTheAnswerToTheQuestion() {
        Assert.assertTrue(mainPage.isFirstQuestionBodyDisplayed());
    }

    @And("I scroll to the Our Instructors element")
    public void iScrollToTheOurInstructorsElement() {
        Utils.scrollToElement(driver, mainPage.getHeadingInstructors());
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the {string} social button")
    public void iClickOnTheSocialButton(String socialButton) {
        mainPage.clickSecondInstructorSocialButtons(socialButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the {string} page")
    public void iShouldSeeThePage(String socialPageTitle) {
        Utils.waitForElementToLoad(1);
        Assert.assertTrue(driver.getTitle().startsWith(socialPageTitle));
    }

    @And("I scroll at the bottom of the page")
    public void iScrollAtTheBottomOfThePage() {
        Utils.scrollToElement(driver, mainPage.getLastPageElement());
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the back-to-top arrow")
    public void iClickOnTheBackToTopArrow() {
        mainPage.clickBackToTopArrow();
    }

    @Then("I should see the Certified Software Tester text")
    public void iShouldSeeTheCertifiedSoftwareTesterText() {
        Assert.assertTrue(mainPage.isCertifiedSoftwareTesterDisplayed());
    }

    // Enrollment Page

    @Given("I am on the enrollment page")
    public void iAmOnTheEnrollmentPage() {
        driver.get("file:///Users/madscientist/Desktop/testingenv/Testing-Env/routes/enrollment.html");
    }

    @And("I type in the {string} field {string}")
    public void iTypeInTheField(String id, String textToType) {
        enrollmentPage.typeInInputBox(id, textToType);
        Utils.waitForElementToLoad(1);
    }

    @When("I click the {string}")
    public void iClickThe(String nextButton) {
        enrollmentPage.clickNextButton(nextButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the Contact Information header")
    public void iShouldSeeTheContactInformationHeader() {
        Assert.assertTrue(enrollmentPage.isContactInformationHeaderDisplayed());
    }

    @Then("I should see the Course Options header")
    public void iShouldSeeTheCourseOptionsHeader() {
        Assert.assertTrue(enrollmentPage.isCourseOptionsHeaderDisplayed());
    }

    @And("I select the {string}")
    public void iSelectThe(String radioButton) {
        enrollmentPage.selectRadioButton(radioButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the Payment Information header")
    public void iShouldSeeThePaymentInformationHeader() {
        Assert.assertTrue(enrollmentPage.isPaymentInformationHeaderDisplayed());
    }

    @And("I put in the {string} field {string}")
    public void iPutInTheField(String inputName, String textToType) {
        enrollmentPage.inputPaymentInformation(inputName, textToType);
        Utils.waitForElementToLoad(1);
    }

    @And("I select from {string} {int}")
    public void iSelectFrom(String id, int selection) {
        enrollmentPage.selectExpirationDate(id,selection);
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the Success page")
    public void iShouldSeeTheSuccessPage() {
        Assert.assertTrue(enrollmentPage.isSuccessHeaderDisplayed());
    }


    @When("I deselect the {string}")
    public void iDeselectThe(String radioButton) {
        enrollmentPage.deselectRadioButton(radioButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("The {string} should be deselected")
    public void theShouldBeDeselected(String radioButton) {
        Assert.assertFalse(enrollmentPage.isRadioButtonSelected(radioButton));
    }
}
