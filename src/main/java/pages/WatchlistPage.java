package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchlistPage extends BasePage {
    @FindAll({@FindBy(xpath = "//a[contains(@href,'Saved+Items')]")})
    private List<WebElement> bootsAriaLabelsList;

    @FindBy(xpath = "//div[contains(@class,'itemCount')]")
    private WebElement countOfSavedItems;

    public WebElement getCountOfSavedItems() {
        return countOfSavedItems;
    }

    public WatchlistPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfAllItemsThatAddedToFavouritesExist() {
        return bootsAriaLabelsList.stream().anyMatch(x -> x.getAttribute("href").contains("23676496")) &&
                bootsAriaLabelsList.stream().anyMatch(x -> x.getAttribute("href").contains("24276155"));

    }
}
