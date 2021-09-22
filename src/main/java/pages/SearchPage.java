package pages;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isUrlConsistAllWordsThatUserSearched(String search) {
        List<String> searchList = Arrays.stream(search.split(" ")).map(String::toLowerCase).toList();
        List<String> urlWords = Arrays.stream(Arrays.stream(getUrl().split("q="))
                .toList().get(1).split("\\+")).toList();
        return searchList.equals(urlWords);

    }
}
