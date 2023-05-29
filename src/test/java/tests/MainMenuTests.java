package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import io.qameta.allure.Description;
import pages.MainPage;

public class MainMenuTests extends BaseTest {

    private static MainPage mainPage;

    @BeforeAll
    public static void init() {
        mainPage = new MainPage();
    }

    @Description("The 'Main menu' button is not highligted in red after clicking on the 'Catalog' button")
    @DisplayName("Check that main menu icon is highligted when Main page is opened")
    @Test
    public void testGoToAnotherMenuIconNotSelected() {
        mainPage.closePopUp();
        mainPage.checkMainMenuButtonIsSelected();
        mainPage.openCatalog().isMainMenuIconSelected();
        mainPage.checkMainMenuButtonIsNotSelected();
    }
}
