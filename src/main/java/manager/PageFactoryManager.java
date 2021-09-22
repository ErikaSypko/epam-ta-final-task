package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public BootsPage getBootsPage() {
        return new BootsPage(driver);
    }

    public WatchlistPage getWatchlist() {
        return new WatchlistPage(driver);
    }

    public SkirtsPage getSkirtsPage() {
        return new SkirtsPage(driver);
    }

    public ItemPage getItemPage() {
        return new ItemPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public BagPage getBagPage() {
        return new BagPage(driver);
    }

}
