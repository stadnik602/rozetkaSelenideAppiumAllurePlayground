package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import static driver.EmulatorHelper.androidScrollToAnElementByText;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class CatalogPage extends SearchPage{

    private SelenideElement catalogMenuTab = $(MobileBy.id("tab_fat_menu"));
    private ElementsCollection categories = $$(MobileBy.xpath("//android.widget.TextView[contains(@resource-id,'item_sections_tv_title')]"));


    @Step("Check the 'Catalog' button is selected")
    public void isMainMenuIconSelected() {
        catalogMenuTab.should(Condition.selected);
    }

    @Step("Check naming all categories")
    public CatalogPage checkCategoriesHaveTexts(List<String> texts) {
//        androidScrollToAnElementByText(texts.get(0));
        compareCollectionsOfElements(categories, texts);
        return this;
    }


    @Step("Click on the category with {text}")
    public CatalogPage clickOnCategoryByText(String text) {
        clickByElementWithText(text);
        return this;
    }
    @Step("Click on the element with {text}")
    public ProductsPage clickOnSubCategoryByTextWithScroll(String text) {
        androidScrollToAnElementByText(text);
        return new ProductsPage();
    }

    @Step("Click on the element with {text}")
    public ProductsPage clickOnSubCategoryByText(String text) {
        androidScrollToAnElementByText(text);
        return new ProductsPage();
    }


}
