package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.stream.Collectors;

public class BootsPage extends BasePage {
    Actions move = new Actions(driver);

    @FindBy(xpath = "//article[contains(@id,'24276155')]//button[@data-auto-id='saveForLater']")
    private WebElement saveForLaterExclusiveBootsButton;

    @FindBy(xpath = "//article[contains(@id,'23676496')]//button[@data-auto-id='saveForLater']")
    private WebElement saveForLaterBootsWithChainButton;

    @FindBy(xpath = "//a[contains(@href,'saved-lists')]")
    private WebElement watchListButton;

    @FindBy(xpath = "//li[@data-dropdown-id='currentprice']")
    private WebElement priceRangeButton;

    @FindBy(xpath = "//div[@class='_2Z5laL6']//div[@aria-valuemin='15']")
    private WebElement minIndicatorButton;

    @FindBy(xpath = "//div[@class='_2FL-lxS']//div[@aria-valuemax='350']")
    private WebElement maxIndicatorButton;

    @FindBy(xpath = "//li[@data-dropdown-id='size_eu']")
    private WebElement sizeButton;

    @FindBy(xpath = "//li[@class='_3LB03xF']//div[text()='EU 37']")
    private WebElement specificSizeButton;

    @FindBy(xpath = "//li[@data-dropdown-id='base_colour']")
    private WebElement colorButton;

    @FindBy(xpath = "//li[@class='_3LB03xF']//div[text()='Pink']")
    private WebElement pinkColorButton;

    @FindBy(xpath = "//p[@data-auto-id=\"totalSelectedFacetValues\"]")
    private WebElement countOfSelectedFilters;

    @FindBy(xpath = "//p[@data-auto-id=\"selectedFacetValueList\"]")
    private WebElement specificNameOfFilterAfterApplying;

    @FindBy(xpath = "//p[@data-auto-id=\"priceRangeSelection\"]")
    private WebElement priceRangeAfterApplyingFilter;

    @FindBy(xpath = "//article[@id=\"product-201081106\"]" +
            "//div[@data-auto-id=\"productTileDescription\"]")
    private WebElement riverIslandBlackBootButton;

    @FindBy(xpath = "//li[@data-auto-id=\"sort\"]")
    private WebElement sortButton;

    @FindBy(xpath = "//li[contains(@id,\"price_high_to_low\")]\n")
    private WebElement sortByPriceHighToLowButton;

    @FindAll({@FindBy(xpath = "//span[@data-auto-id=\"productTilePrice\"]")})
    private List<WebElement> itemPriceList;

    public BootsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveForLaterExclusiveBootsButton() {
        saveForLaterExclusiveBootsButton.click();
    }

    public void clickOnSaveForLaterBootsWithChainButton() {
        saveForLaterBootsWithChainButton.click();
    }

    public void clickOnWatchListButton() {
        watchListButton.click();
    }

    public void clickOnPriceRangeButton() {
        priceRangeButton.click();
    }

    public void moveMinIndicatorToRight(int x, int y) {
        move.dragAndDropBy(minIndicatorButton, x, y).click();
        move.build().perform();
    }

    public void moveMaxIndicatorToLeft(int x, int y) {
        move.dragAndDropBy(maxIndicatorButton, x, y).click();
        move.build().perform();
    }

    public void clickOnSizeButton() {
        sizeButton.click();
    }

    public void clickOnSpecificSizeButton() {
        specificSizeButton.click();
    }

    public void clickOnColorButton() {
        colorButton.click();
    }

    public void clickOnPinkColorButton() {
        pinkColorButton.click();
    }

    public void clickOnRiverIslandBlackBootButton() {
        riverIslandBlackBootButton.click();
    }

    public void clickOnSortButton() {
        sortButton.click();
    }

    public void clickOnSortByPriceHighToLowButton() {
        sortByPriceHighToLowButton.click();
    }

    public String getCountOfSelectedFilters() {
        return countOfSelectedFilters.getText();
    }

    public String getSpecificNameOfFilterAfterApplying() {
        return specificNameOfFilterAfterApplying.getText();
    }

    public String getPriceRangeAfterApplyingFilter() {
        return priceRangeAfterApplyingFilter.getText().replace("£", "").replace(" ", "");
    }

    public List<Double> getItemsPrice() {
        return itemPriceList.stream().map(x -> Double.valueOf(x.getText()
                        .replace(String.valueOf(x.getText().charAt(0)), "")))
                .collect(Collectors.toList()).subList(0, 30);
    }

    public boolean isListOfItemsSorted() {
        return Ordering.natural().reverse().isOrdered(getItemsPrice());
    }

}
