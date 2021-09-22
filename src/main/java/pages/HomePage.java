package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    Actions action = new Actions(driver);

    @FindBy(xpath = "//div[@id='myAccountDropdown']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']//span[contains(text(),'Hi')]")
    private WebElement userGreetingsOnDropdownMenu;

    @FindBy(xpath = "//nav[@aria-label=concat(\"Women\",\"'\",\"s products\") " +
            "and not(@aria-hidden='true')]//button[@data-testid='primarynav-button']" +
            "//span[text()='Shoes']")
    private WebElement shoesButton;

    @FindBy(xpath = "//nav[@aria-label=concat(\"Women\",\"'\",\"s products\") " +
            "and not(@aria-hidden='true')]//a[contains(@href,'product|boots')]")
    private WebElement bootsButton;

    @FindBy(xpath = "//nav[@data-testid='primarynav-large' and not(@aria-hidden='true')]" +
            "//button[contains(@aria-controls,'96b432')]")
    private WebElement clothingButton;

    @FindBy(xpath = "(//a[contains(@href,'product|skirts')])[1]")
    private WebElement skirtsButton;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid=\"search-button-inline\"]")
    private WebElement searchButton;

    @FindBy(xpath = "(//div[@data-testid=\"country-selector\"])[1]")
    private WebElement countrySelectorButton;

    @FindBy(xpath = "//select[@id=\"currency\"]")
    private WebElement currencySelector;

    @FindBy(xpath = "//select[@id=\"currency\"]//option[@value=\"2\"]")
    private WebElement currencySelectorOption;

    @FindBy(xpath = "//button[@data-testid=\"save-country-button\"]")
    private WebElement updatePreferencesButton;

    public WebElement getSkirtsButton() {
        return skirtsButton;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getBootsButton() {
        return bootsButton;
    }

    public WebElement getUserGreetingsOnDropdownMenu() {
        return userGreetingsOnDropdownMenu;
    }

    public WebElement getCountrySelector() {
        return countrySelectorButton;
    }

    public WebElement getCurrencySelector() {
        return currencySelector;
    }

    public WebElement getCurrencySelectorOption() {
        return currencySelectorOption;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isBootsButtonVisible() {
        return bootsButton.isDisplayed();
    }

    public boolean isSkirtsButtonVisible() {
        return skirtsButton.isDisplayed();
    }

    public boolean isUserGreetingsOnDropdownMenuVisible() {
        return userGreetingsOnDropdownMenu.isDisplayed();
    }

    public void hoverOverMyAccountButton() {
        action.moveToElement(myAccountButton).perform();
    }

    public void hoverOverShoesButton() {
        action.moveToElement(shoesButton).perform();
    }

    public void hoverOverClothingButton() {
        action.moveToElement(clothingButton).perform();
    }

    public void clickOnBootsButton() {
        bootsButton.click();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickOnSkirtsButton() {
        skirtsButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnCountrySelectorButton() {
        countrySelectorButton.click();
    }

    public void clickOnCurrencySelector() {
        currencySelector.click();
    }

    public void clickOnCurrencySelectorOption() {
        currencySelectorOption.click();
    }

    public void clickOnUpdatePreferencesButton() {
        updatePreferencesButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public String getTextOfUserGreetingsOnDropdownMenu() {
        return userGreetingsOnDropdownMenu.getText();
    }

    public void inputSearchField(String input) {
        searchField.sendKeys(input);
    }
}
