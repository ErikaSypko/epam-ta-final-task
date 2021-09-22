package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private static final int DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    BootsPage bootsPage;
    WatchlistPage watchlistPage;
    SkirtsPage skirtsPage;
    ItemPage itemPage;
    SearchPage searchPage;
    BagPage bagPage;
    PageFactoryManager factoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        factoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(String url) {
        homePage = factoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User holds the mouse over the account dropdown")
    public void userHoldsTheMouseOverTheAccountDropdown() {
        homePage.hoverOverMyAccountButton();
    }

    @And("User checks 'Sign in' button visibility")
    public void userChecksSignInButtonVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInButton());
        assertTrue(homePage.isSignInButtonVisible());
    }

    @And("User clicks sign in button")
    public void userClicksSignInButton() {
        homePage.clickOnSignInButton();
        loginPage = factoryManager.getLoginPage();
    }

    @And("User enters email address {string}")
    public void userEntersEmailAddressEmailAddress(String correctEmail) {
        loginPage.inputCorrectEmailAddress(correctEmail);
    }

    @And("User enters password {string}")
    public void userEntersPasswordPassword(String correctPassword) {
        loginPage.inputCorrectPassword(correctPassword);

    }

    @And("User clicks sign in button on login page")
    public void userClicksSignInButtonOnLoginPage() {
        loginPage.clickOnSignInButton();
    }

    @And("User waits until url is {string}")
    public void userWaitsUntilUrlIsHomePage(String url) {
        homePage.waitUrlContains(DEFAULT_TIMEOUT, url);
    }

    @And("User waits until page completely loads")
    public void userWaitsUntilPageCompletelyLoads() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks greeting message visibility")
    public void userChecksGreetingMessageVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getUserGreetingsOnDropdownMenu());
        assertTrue(homePage.isUserGreetingsOnDropdownMenuVisible());
    }

    @Then("User should see greeting message {string}")
    public void userShouldSeeGreetingMessageMessage(String message) {
        Assert.assertEquals(homePage.getTextOfUserGreetingsOnDropdownMenu(), message);
    }

    @Then("User should see warning message {string}")
    public void userShouldSeeWarningMessageMessage(String message) {
        Assert.assertTrue(loginPage.getLoginErrorMessageWhenIncorrectLogin().contains(message));
    }

    @When("User holds the mouse over the Shoes button")
    public void userHoldsTheMouseOverTheShoesButton() {
        homePage.hoverOverShoesButton();
    }

    @And("User checks Boots button visibility")
    public void userChecksBootsButtonVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getBootsButton());
        assertTrue(homePage.isBootsButtonVisible());
    }

    @And("User clicks Boots button")
    public void userClicksBootsButton() {
        homePage.clickOnBootsButton();
        bootsPage = factoryManager.getBootsPage();
    }

    @And("User saves for later first boots")
    public void userSavesForLaterFirstBoots() {
        bootsPage.clickOnSaveForLaterExclusiveBootsButton();
    }

    @And("User saves for later second boots")
    public void userSavesForLaterSecondBoots() {
        bootsPage.clickOnSaveForLaterBootsWithChainButton();
    }

    @And("User clicks Watchlist button")
    public void userClicksWatchlistButton() {
        bootsPage.clickOnWatchListButton();
        watchlistPage = factoryManager.getWatchlist();
    }

    @And("User waits until watchlist page completely loads")
    public void userWaitsUntilWatchlistPageCompletelyLoads() {
        watchlistPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User waits until visibility count of saved items")
    public void userWaitsUntilVisibilityCountOfSavedItems() {
        watchlistPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, watchlistPage.getCountOfSavedItems());

    }

    @Then("User should see all items that user added \\({string}) to the watchlist")
    public void userShouldSeeAllItemsThatUserAddedIsAllItemsShowedToTheWatchlist(String isAllItemsShowed) {
        Assert.assertEquals(watchlistPage.checkIfAllItemsThatAddedToFavouritesExist(),
                Boolean.valueOf(isAllItemsShowed));
    }

    @And("User clicks Price Range button")
    public void userClicksPriceRangeButton() {
        bootsPage.clickOnPriceRangeButton();
    }

    @And("User changes minimum price \\({string}, {string})")
    public void userChangesMinimumPrice(String x, String y) {
        bootsPage.moveMinIndicatorToRight(Integer.valueOf(x), Integer.valueOf(y));
    }

    @And("User changes maximum price \\({string}, {string})")
    public void userChangesMaximumPrice(String x, String y) {
        bootsPage.moveMaxIndicatorToLeft(Integer.valueOf(x), Integer.valueOf(y));
    }

    @And("User clicks Size button")
    public void userClicksSizeButton() {
        bootsPage.clickOnSizeButton();
    }

    @And("User clicks Specific Size button")
    public void userClicksSpecificSizeButton() {
        bootsPage.clickOnSpecificSizeButton();
    }

    @And("User clicks Colour button")
    public void userClicksColourButton() {
        bootsPage.clickOnColorButton();
    }

    @And("User clicks Pink Colour button")
    public void userClicksPinkColourButton() {
        bootsPage.clickOnPinkColorButton();
    }

    @And("User checks applied price range \\({string}, {string})")
    public void userChecksAppliedPriceRangeMinPriceMaxPrice(String min, String max) {
        List<String> minMax = Arrays.stream(bootsPage.getPriceRangeAfterApplyingFilter().split("-")).toList();
        Assert.assertEquals(minMax.get(0), min);
        Assert.assertEquals(minMax.get(1), max);

    }

    @And("User checks that the specific filter name is specific size\\({string})")
    public void userChecksThatTheSpecificFilterNameIsSpecificSizeSize(String size) {
        Assert.assertEquals(bootsPage.getSpecificNameOfFilterAfterApplying(), size);
    }

    @And("User checks that the specific filter name is specific color \\({string})")
    public void userChecksThatTheSpecificFilterNameIsSpecificColorColor(String color) {
        Assert.assertEquals(bootsPage.getSpecificNameOfFilterAfterApplying(), color);
    }


    @And("User checks count of selected filters \\({string})")
    public void userChecksCountOfSelectedFiltersCountFilters(String count) {
        Assert.assertEquals(bootsPage.getCountOfSelectedFilters(), count);
    }

    @When("User holds the mouse over the Clothing button")
    public void userHoldsTheMouseOverTheClothingButton() {
        homePage.hoverOverClothingButton();
    }

    @And("User checks Skirts button visibility")
    public void userChecksSkirtsButtonVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSkirtsButton());
        assertTrue(homePage.isSkirtsButtonVisible());
    }

    @And("User clicks Skirts button")
    public void userClicksSkirtsButton() {
        homePage.clickOnSkirtsButton();
        skirtsPage = factoryManager.getSkirtsPage();

    }

    @And("User clicks Certain Skirts button")
    public void userClicksCertainSkirtsButton() {
        skirtsPage.clickOnCertainSkirtButton();
        itemPage = factoryManager.getItemPage();

    }

    @And("User clicks 'Size' button")
    public void userClicksSizeButtonOnItemPage() {
        itemPage.clickOnSizeSelector();

    }

    @And("User clicks to chosen size option")
    public void userClicksToChosenSizeOption() {
        itemPage.clickOnOptionSizeSelector();
    }

    @And("User clicks Add to Bag button")
    public void userClicksAddToBagButton() {
        itemPage.clickOnAddToBagButton();
    }

    @And("User waits until visibility Bag button")
    public void userWaitsUntilVisibilityBagButton() {
        itemPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, itemPage.getBagButton());
    }

    @And("User holds the mouse over the Bag button")
    public void userHoverOverBagButton() {
        itemPage.hoverOverBagButton();
    }

    @Then("User checks size of item")
    public void userChecksSizeOfItem() {
        Assert.assertEquals(itemPage.getSizeOfSkirtFromItemPage(), itemPage.getSizeOfSkirtFromBag());
    }

    @And("User checks name of item")
    public void userChecksNameOfItem() {
        Assert.assertEquals(itemPage.getNameOfSkirtFromItemPage(), itemPage.getNameOfSkirtFromBag());
    }

    @And("User clicks Certain Boots button")
    public void userClicksCertainBootsButton() {
        bootsPage.clickOnRiverIslandBlackBootButton();
        itemPage = factoryManager.getItemPage();
    }

    @And("User clicks Checkout button")
    public void userClicksCheckoutButton() {
        itemPage.clickOnCheckoutButton();
        loginPage = factoryManager.getLoginPage();
    }

    @And("User clicks sign in button on checkout page")
    public void userClicksSignInButtonOnCheckoutPage() {
        loginPage.clickOnSignInButton();
    }

    @Then("User should see warning message that invalid data {string}")
    public void userShouldSeeWarningMessageThatInvalidDataInvalidEmail(String errorMessage) {
        Assert.assertTrue(loginPage.getLoginErrorMessageWhenInvalidLogin().contains(errorMessage));
    }

    @When("User enters what user wants to find {string}")
    public void userEntersWhatUserWantsToFindSearchText(String input) {
        homePage.inputSearchField(input);
    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {
        homePage.clickOnSearchButton();
        searchPage = factoryManager.getSearchPage();

    }

    @Then("User checks that URL contains {string}")
    public void userChecksThatURLContainsSearchText(String input) {
        Assert.assertTrue(searchPage.isUrlConsistAllWordsThatUserSearched(input));
    }

    @And("User waits until sign in page completely loads")
    public void userWaitsUntilSignInPageCompletelyLoads() {
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getEmailAddressField());
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordField());
    }

    @When("User clicks Country Selector button")
    public void userClicksCountrySelectorButton() {
        homePage.clickOnCountrySelectorButton();
    }

    @And("User clicks Currency Selector button")
    public void userClicksCurrencySelectorButton() {
        homePage.clickOnCurrencySelector();
    }

    @And("User selects certain currency")
    public void userSelectsCertainCurrency() {
        homePage.clickOnCurrencySelectorOption();
    }

    @And("User clicks Update Preferences button")
    public void userClicksUpdatePreferencesButton() {
        homePage.clickOnUpdatePreferencesButton();
    }

    @Then("User checks that properly currency is selected")
    public void userChecksThatProperlyCurrencyIsSelected() {
        System.out.println(homePage.getCurrencySelectorOption().isSelected());
    }

    @When("User waits until visibility Country Selector button")
    public void userWaitsUntilVisibilityCountrySelectorButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCountrySelector());
    }

    @And("User waits until visibility Currency Selector button")
    public void userWaitsUntilVisibilityCurrencySelectorButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCurrencySelector());
    }

    @And("User clicks View Bag button")
    public void userClicksViewBagButton() {
        itemPage.clickOnViewBagButton();
        bagPage = factoryManager.getBagPage();
    }

    @And("User clicks Quantity Items button")
    public void userClicksQuantityItemsButton() {
        bagPage.clickOnQuantityItemsButton();
    }

    @And("User clicks Certain Quantity Items button")
    public void userClicksCertainQuantityItemsButton() {
        bagPage.clickOnCertainQuantityItemsButton();
    }

    @And("User clicks Update button")
    public void userClicksUpdateButton() {
        bagPage.clickOnUpdateButton();
    }

    @Then("User checks that price increments properly")
    public void userChecksThatPriceIncrementsProperly() {
        Double actual = bagPage.subtotalPrice();
        Double expected = bagPage.ItemPrice() * bagPage.getQuantityItems();
        Assert.assertEquals(expected, actual);
    }

    @And("User waits until visibility Quantity Items button")
    public void userWaitsUntilVisibilityQuantityItemsButton() {
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getQuantityItemsButton());
    }

    @And("User waits until Update button")
    public void userWaitsUntilUpdateButton() {
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getUpdateButton());
    }

    @And("User waits until visibility Subtotal price")
    public void userWaitsUntilVisibilitySubtotalPrice() {
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getSubtotalPrice());

    }

    @And("User waits until visibility Item Price")
    public void userWaitsUntilVisibilityItemPrice() {
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getItemPrice());
    }

    @And("User wait until clickable of Update button")
    public void userWaitUntilClickableOfUpdateButton() {
        bagPage.waitClickableOfElement(DEFAULT_TIMEOUT, bagPage.getUpdateButton());
    }

    @And("User refreshed page")
    public void userRefreshedPage() {
        driver.navigate().refresh();
    }

    @And("User waits until bag page completely loads")
    public void userWaitsUntilBagPageCompletelyLoads() {
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks Sort button")
    public void userClicksSortButton() {
        bootsPage.clickOnSortButton();
    }

    @And("User clicks Price From High To Low button")
    public void userClicksPriceFromHighToLowButton() {
        bootsPage.clickOnSortByPriceHighToLowButton();
    }

    @Then("User checks if price sorted")
    public void userChecksIfPriceSorted() {
        Assert.assertTrue(bootsPage.isListOfItemsSorted());
    }

    @And("User waits until boots page completely loads")
    public void userWaitsUntilBootsPageCompletelyLoads() {
        driver.navigate().refresh();
        bootsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
