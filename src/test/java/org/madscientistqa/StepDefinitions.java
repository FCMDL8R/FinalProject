package org.madscientistqa;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.Constants.HOME_PAGE_URL;
import static constants.Constants.ENROLLMENT_PAGE_URL;

import pageobjects.*;
import utils.Utils;

public class StepDefinitions {

    private final WebDriver driver;
    HomePage homePage;
    EnrollmentPage enrollmentPage;
    public StepDefinitions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
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
        driver.get(HOME_PAGE_URL);
    }

    @Then("The page title should say {string}")
    public void thePageTitleShouldSay(String pageTitle) {
        Assertions.assertTrue(driver.getTitle().startsWith(pageTitle));
    }

    @When("I click on the What You'll Learn navigation button")
    public void iClickOnTheNavigationWhatYouLearnButton() {
        homePage.clickWhatYouLearnNavigationButton();
    }

    @Then("I should see the Learn The Fundamentals heading")
    public void iShouldSeeTheLearnTheFundamentalsHeading() {
        Assertions.assertTrue(homePage.isLearnFundamentalsTextDisplayed());
    }

    @And("I type {string} in the email field")
    public void iTypeInTheEmailField(String textToType) {
        homePage.typeSomethingInEmailField(textToType);
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        homePage.clickSubmitEmailButton();
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see a pop-up saying {string}")
    public void iShouldSeeAPopUpSaying(String alertMessage) {
        Assertions.assertTrue(driver.switchTo().alert().getText().contains(alertMessage));
        driver.switchTo().alert().accept();
    }

    @Then("I should see a red outline on the email input field")
    public void iShouldSeeARedOutlineOnTheEmailInputField() {
        Assertions.assertTrue(homePage.isEmailValid());
    }

    @And("I scroll to the Frequently Asked Questions element")
    public void iScrollToTheFrequentlyAskedQuestionsElement() {
        Utils.scrollToElement(driver, homePage.getHeadingTextFAQ());
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the first question")
    public void iClickOnTheFirstQuestion() {
        homePage.clickFirstQuestion();
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the answer to the question")
    public void iShouldSeeTheAnswerToTheQuestion() {
        Assertions.assertTrue(homePage.isFirstQuestionBodyDisplayed());
    }

    @And("I scroll to the Our Instructors element")
    public void iScrollToTheOurInstructorsElement() {
        Utils.scrollToElement(driver, homePage.getHeadingInstructors());
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the {string} social button")
    public void iClickOnTheSocialButton(String socialButton) {
        homePage.clickSecondInstructorSocialButtons(socialButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the {string} page")
    public void iShouldSeeThePage(String socialPageTitle) {
        Utils.waitForElementToLoad(1);
        Assertions.assertTrue(driver.getTitle().startsWith(socialPageTitle));
    }

    @And("I scroll at the bottom of the page")
    public void iScrollAtTheBottomOfThePage() {
        Utils.scrollToElement(driver, homePage.getLastPageElement());
        Utils.waitForElementToLoad(1);
    }

    @When("I click on the back-to-top arrow")
    public void iClickOnTheBackToTopArrow() {
        homePage.clickBackToTopArrow();
    }

    @Then("I should see the Certified Software Tester text")
    public void iShouldSeeTheCertifiedSoftwareTesterText() {
        Assertions.assertTrue(homePage.isCertifiedSoftwareTesterDisplayed());
    }

    // Enrollment Page

    @Given("I am on the enrollment page")
    public void iAmOnTheEnrollmentPage() {
        driver.get(ENROLLMENT_PAGE_URL);
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
        Assertions.assertTrue(enrollmentPage.isContactInformationHeaderDisplayed());
    }

    @Then("I should see the Course Options header")
    public void iShouldSeeTheCourseOptionsHeader() {
        Assertions.assertTrue(enrollmentPage.isCourseOptionsHeaderDisplayed());
    }

    @And("I select the {string}")
    public void iSelectThe(String radioButton) {
        enrollmentPage.selectRadioButton(radioButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("I should see the Payment Information header")
    public void iShouldSeeThePaymentInformationHeader() {
        Assertions.assertTrue(enrollmentPage.isPaymentInformationHeaderDisplayed());
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
        Assertions.assertTrue(enrollmentPage.isSuccessHeaderDisplayed());
    }


    @When("I deselect the {string}")
    public void iDeselectThe(String radioButton) {
        enrollmentPage.deselectRadioButton(radioButton);
        Utils.waitForElementToLoad(1);
    }

    @Then("The {string} should be deselected")
    public void theShouldBeDeselected(String radioButton) {
        Assertions.assertFalse(enrollmentPage.isRadioButtonSelected(radioButton));
    }

}
