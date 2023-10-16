package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.Predicate;

public class EnrollmentPage {

    // Personal Information
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/h3")
    private WebElement personalInformationHeader;
    @FindBy(xpath = "/html/body/div/div/section/div//child::input")
    private List<WebElement> enrollmentInputFields;

    // Contact Information
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/h3")
    private WebElement contactInformationHeader;

    // Course Options
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/h3")
    private WebElement courseOptionsHeader;

    // Payment Information
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/h3")
    private WebElement paymentInformationHeader;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]//child::input")
    private List<WebElement> paymentInformationInputFields;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/div/div[2]//child::select")
    private List<WebElement> expirationDateSelectButtons;

    // Success
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[5]/h3")
    private WebElement successHeader;

    // Navigation
    @FindBy(xpath = "/html/body/div/div/section/div//child::button")
    private List<WebElement> stepNavigationButtons;

    public EnrollmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessHeaderDisplayed() {
        return this.successHeader.isDisplayed();
    }

    public void selectExpirationDate(String id, int selection) {
        expirationDateSelectButtons.stream()
                .filter(webElementHasId(id)).
                findAny().ifPresent(webElement -> new Select(webElement).selectByIndex(selection));
    }

    public void inputPaymentInformation(String inputField, String myCardInfo) {
        paymentInformationInputFields.stream().
                filter(webElementHasName(inputField)).
                findAny().ifPresent(webElement -> webElement.sendKeys(myCardInfo));
    }

    public boolean isPaymentInformationHeaderDisplayed() {
        return this.paymentInformationHeader.isDisplayed();
    }

    public boolean isRadioButtonSelected(String id) {
        return enrollmentInputFields.stream().
                filter(webElementHasId(id))
                .anyMatch(WebElement::isSelected);
    }

    public void selectRadioButton(String id) {
        enrollmentInputFields.stream().
                filter(webElementHasId(id)).
                findAny().ifPresent(WebElement::click);
    }

    public void deselectRadioButton(String id) {
        enrollmentInputFields.stream().
                filter(webElementHasId(id)).
                filter(WebElement::isSelected).
                findAny().ifPresent(WebElement::click);
    }

    public boolean isCourseOptionsHeaderDisplayed() {
        return this.courseOptionsHeader.isDisplayed();
    }

    public boolean isContactInformationHeaderDisplayed() {
        return this.contactInformationHeader.isDisplayed();
    }

    public void clickPreviousButton(String previousButton) {
        stepNavigationButtons.stream().
                filter(webElementHasClass(previousButton)).
                filter(WebElement::isDisplayed).
                findAny().ifPresent(WebElement::click);
    }

    public void clickNextButton(String nextButton) {
        stepNavigationButtons.stream().
                filter(webElementHasClass(nextButton)).
                filter(WebElement::isDisplayed).
                findAny().ifPresent(WebElement::click);
    }

    public void typeInInputBox(String id, String textToType) {
        enrollmentInputFields.stream().
                filter(webElementHasId(id)).
                findAny().ifPresent(webElement -> webElement.sendKeys(textToType));
    }

    // Helper
    Predicate<WebElement> webElementHasClass(String attributeName) {
        return webElement -> webElement.getAttribute("class").contains(attributeName);
    }

    Predicate<WebElement> webElementHasId(String attributeName) {
        return webElement -> webElement.getAttribute("id").contains(attributeName);
    }

    Predicate<WebElement> webElementHasName(String attributeName) {
        return webElement -> webElement.getAttribute("name").contains(attributeName);
    }
}
