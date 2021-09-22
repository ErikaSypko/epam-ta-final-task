package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage {
    @FindBy(xpath = "//span[@aria-label=\"Quantity\"]//span[@class=\"select2-selection__rendered\"]")
    private WebElement quantityItemsButton;

    @FindBy(xpath = "//span[@class=\"select2-results\"]//li[text()='6']")
    private WebElement certainQuantityItemsButton;

    @FindBy(xpath = "//button[text()=\"UPDATE\"]")
    private WebElement updateButton;

    @FindBy(xpath = "//span[@class=\"bag-subtotal-price\"]")
    private WebElement subtotalPrice;

    @FindBy(xpath = "//span[@class=\"bag-item-price bag-item-price--current\"]")
    private WebElement itemPrice;

    @FindBy(xpath = "//bag-move-to-saved[@class=\"bag-item-save\"]")
    private WebElement saveForLaterButton;

    public WebElement getQuantityItemsButton() {
        return quantityItemsButton;
    }

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public WebElement getSubtotalPrice() {
        return subtotalPrice;
    }

    public WebElement getItemPrice() {
        return itemPrice;
    }

    public double subtotalPrice() {
        return Double.parseDouble(subtotalPrice.getText().substring(1));
    }

    public double getQuantityItems() {
        return Double.parseDouble(quantityItemsButton.getText());
    }

    public double ItemPrice() {
        return Double.parseDouble(itemPrice.getText().substring(1));
    }

    public BagPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnQuantityItemsButton() {
        quantityItemsButton.click();
    }

    public void clickOnCertainQuantityItemsButton() {
        certainQuantityItemsButton.click();
    }

    public void clickOnUpdateButton() {
        updateButton.click();
    }
}
