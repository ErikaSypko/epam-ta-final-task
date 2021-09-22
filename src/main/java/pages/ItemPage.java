package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    Actions action = new Actions(driver);

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeSelector;

    @FindBy(xpath = "//option[text()='EU 38']")
    private WebElement optionSizeSelector;

    @FindBy(xpath = "//button[@aria-label='Add to bag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div[@id='miniBagDropdown']")
    private WebElement bagButton;

    @FindBy(xpath = "//div[@class='product-hero']/h1")
    private WebElement nameOfSkirtFromItemPage;

    @FindBy(xpath = "//div[@class='_2g_Mcyd']//dd")
    private WebElement nameOfSkirtFromBag;

    @FindBy(xpath = "//div[@class='_2Z5GEI3']//dd")
    private WebElement sizeOfSkirtFromBag;

    @FindBy(xpath = "//a[@data-test-id=\"checkout-link\"]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@data-test-id=\"bag-link\"]")
    private WebElement viewBagButton;

    public String getNameOfSkirtFromItemPage() {
        return nameOfSkirtFromItemPage.getText();
    }

    public String getSizeOfSkirtFromBag() {
        return sizeOfSkirtFromBag.getText();
    }

    public String getNameOfSkirtFromBag() {
        return nameOfSkirtFromBag.getText();
    }

    public String getSizeOfSkirtFromItemPage() {
        return optionSizeSelector.getText();
    }

    public WebElement getBagButton() {
        return bagButton;
    }

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSizeSelector() {
        sizeSelector.click();
    }

    public void clickOnOptionSizeSelector() {
        optionSizeSelector.click();
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public void clickOnViewBagButton() {
        viewBagButton.click();
    }

    public void hoverOverBagButton() {
        action.moveToElement(bagButton).perform();
    }
}
