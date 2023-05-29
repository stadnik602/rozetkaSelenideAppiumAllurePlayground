package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;


import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class ProductsPage extends BasePage {

    private ElementsCollection products = $$(MobileBy.xpath("//android.widget.TextView[contains(@resource-id, 'offer_tv')]"));

    @Step("Check each product on the page matchs products of selected category")
    public ProductsPage checkProductsListContainsText(String text) {
        checkEachContainsText(products, text);
        return this;
    }

    @Step("Click on the product with {text}")
    public ProductPage clickOnProductByText(String text) {
        clickByElementWithText(text);
        return new ProductPage();
    }
}
