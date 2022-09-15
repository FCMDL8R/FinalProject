package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.function.Predicate;

public class MainPage {

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[1]/a")
    private WebElement whatYouLearnNavButton;

    @FindBy(xpath = "//*[@id=\"learn-fundamentals\"]/div/div/div[2]/h2")
    private WebElement learnFundamentalsText;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/input")
    private WebElement emailInputField;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/button")
    private WebElement submitEmailButton;

    @FindBy(xpath = "//*[@id=\"questions\"]/div/h2")
    private WebElement headingFAQ;

    @FindBy(xpath = "//*[@id=\"questions\"]/div[1]/h3/button")
    private WebElement firstQuestion;

    @FindBy(xpath = "//*[@id=\"question-one\"]/div")
    private WebElement firstQuestionBody;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/h2")
    private WebElement headingInstructors;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[2]/div/div//child::a")
    private List<WebElement> secondInstructorSocialButtons;

    @FindBy(xpath = "/html/body/footer/div/a/i")
    private WebElement backToTopArrow;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/h1/span")
    private WebElement certifiedSoftwareTester;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickWhatYouLearnNavigationButton() {
        this.whatYouLearnNavButton.click();
    }

    public boolean isLearnFundamentalsTextDisplayed() {
        return this.learnFundamentalsText.isDisplayed();
    }

    public void typeSomethingInEmailField(String textToType) {
        this.emailInputField.sendKeys(textToType);
    }

    public void clickSubmitEmailButton() {
        this.submitEmailButton.click();
    }

    public boolean isEmailValid() {
        return this.emailInputField.getAttribute("class").contains("error");
    }

    public WebElement getHeadingTextFAQ() {
        return this.headingFAQ;
    }

    public void clickFirstQuestion() {
        this.firstQuestion.click();
    }

    public boolean isFirstQuestionBodyDisplayed() {
        return this.firstQuestionBody.isDisplayed();
    }

    public WebElement getHeadingInstructors() {
        return this.headingInstructors;
    }

    public void clickSecondInstructorSocialButtons(String socialButton) {
        secondInstructorSocialButtons.stream().
                filter(webElementHasHref(socialButton)).findAny().ifPresent(WebElement::click);
    }

    public WebElement getLastPageElement() {
        return this.backToTopArrow;
    }

    public void clickBackToTopArrow() {
        this.backToTopArrow.click();
    }

    public boolean isCertifiedSoftwareTesterDisplayed() {
        return this.certifiedSoftwareTester.isDisplayed();
    }

    Predicate<WebElement> webElementHasHref(String attributeName) {
        return webElement -> webElement.getAttribute("href").contains(attributeName);
    }
}

