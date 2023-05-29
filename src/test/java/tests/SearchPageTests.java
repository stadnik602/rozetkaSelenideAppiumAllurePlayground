package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import pages.MainPage;

public class SearchPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

    @Description("Check each semantic result contains search value")
    @DisplayName("Check semantic results contain search value")
    @Test
    public void semanticResultsIncludeSearchValue() {
        String searchQuery = "hea";
        mainPage.closePopUp()
                .typeValueToSearchField(searchQuery)
                .checkSemanticQueries(searchQuery);
    }
}
