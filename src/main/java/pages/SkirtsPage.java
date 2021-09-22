package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkirtsPage extends BasePage {
    @FindBy(xpath = "//article[contains(@id,'200309276')]//div[@data-auto-id='productTileDescription']")
    private WebElement certainSkirtButton;

    public SkirtsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCertainSkirtButton() {
        certainSkirtButton.click();
    }
}
