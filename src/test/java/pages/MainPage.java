package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static driver.EmulatorHelper.androidScrollToAnElementByText;
import static driver.EmulatorHelper.goBack;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class MainPage extends SearchPage {

    private SelenideElement catalogButton = $(MobileBy.id("tab_fat_menu"));
    private SelenideElement cartButton = $(MobileBy.id("tab_cart"));
    private SelenideElement mainMenuIcon = $(MobileBy.id("tab_home"));
    private SelenideElement bannerCloseButton = $(MobileBy.id("banner_iv_close"));

    @Step("Open the 'Catalog' page")
    public CatalogPage openCatalog() {
        catalogButton.should(Condition.visible).click();
        return new CatalogPage();
    }

    @Step("Close pop-up")
    public MainPage closePopUp() {
        bannerCloseButton.should(Condition.visible).click();
        return this;
    }


    @Step("Check the 'Main menu' button is selected")
    public void checkMainMenuButtonIsSelected() {
        mainMenuIcon.should(Condition.selected);
    }

    @Step("Check the 'Main menu' button is not selected")
    public void checkMainMenuButtonIsNotSelected() {
        mainMenuIcon.should(Condition.not(Condition.selected));
    }
}
