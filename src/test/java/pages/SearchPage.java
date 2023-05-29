package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.NoSuchElementException;

import static driver.EmulatorHelper.*;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class SearchPage extends BasePage {

    private SelenideElement searchField = $(MobileBy.id("view_search_tv"));
    private SelenideElement searchFieldInExpandedSearch = $(MobileBy.id("search_et_query"));
    private SelenideElement searchFieldExpanded = $(MobileBy.id("search_src_text"));

    private ElementsCollection allSearchQueriesInSearchExpandedField = $$(MobileBy.xpath("//android.widget.TextView[contains(@resource-id, 'search_tv_title')]"));

    private ElementsCollection semanticSearchQueries = $$(MobileBy.xpath("//android.widget.ImageView[" +
            "contains(@resource-id, 'iv_right')]//..//android.widget.TextView[contains(@resource-id, 'search_tv_title')]"));

    private SelenideElement tempItem;


    @Step("Search {item}")
    public SearchPage search(String item) {
        searchField.should(Condition.visible).click();
        sendKeysAndFind(searchFieldInExpandedSearch, item);
        closeKeyBoard();
        return this;
    }

    @Step("Type {searchValuer} to the search field")
    public SearchPage typeValueToSearchField(String searchValue) {
        searchField.should(Condition.visible).click();
        closeKeyBoard();
        swipeBack();
        sendKeys(searchFieldInExpandedSearch, searchValue);
        return this;
    }

    @Step("Get name of first product on the page")
    public String getFirstFoundedFullItemName() {
        tempItem = $(MobileBy.xpath(""));
        return tempItem.getText();
    }

    @Step("Open the 'Product' page for first found product")
    public ItemPage openFirstFoundedByTextContains() {
        tempItem.click();
        return new ItemPage();
    }

    @Step("Check that systematic names contains search query")
    public SearchPage checkSemanticQueries(String searchQuery) {
        checkEachContainsText(semanticSearchQueries, searchQuery);
        return this;
    }


}
