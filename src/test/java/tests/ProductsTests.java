package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import pages.MainPage;
import util.WordingUtil;

public class ProductsTests extends BaseTest{
    MainPage mainPage = new MainPage();

    @Description("The 'Armchairs for gamers' category includes only armchairs")
    @DisplayName("Only armchairs should be displayed on the Products page")
    @Test
    public void onlySeatsDisplayedSeatsForGamersSubCategory() {
        String category = "Товари для геймерів";
        String subCategory = "Крісла для геймерів";
        String expectedPartProductTitle = WordingUtil.toEncodedUtf8String("Крісло");
        mainPage.closePopUp().openCatalog()
                .clickOnCategoryByText(category)
                .clickOnSubCategoryByTextWithScroll(subCategory)
                .checkProductsListContainsText(expectedPartProductTitle);
    }
}
