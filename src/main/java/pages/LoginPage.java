package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//li[@id='loginErrorMessage']")
    private WebElement loginErrorMessageWhenIncorrectLogin;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement loginErrorMessageWhenInvalidLogin;

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public String getLoginErrorMessageWhenIncorrectLogin() {
        return loginErrorMessageWhenIncorrectLogin.getText();
    }

    public String getLoginErrorMessageWhenInvalidLogin() {
        return loginErrorMessageWhenInvalidLogin.getText();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputCorrectEmailAddress(String correctEmail) {
        emailAddressField.sendKeys(correctEmail);
    }

    public void inputCorrectPassword(String correctPassword) {
        passwordField.sendKeys(correctPassword);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }
}
