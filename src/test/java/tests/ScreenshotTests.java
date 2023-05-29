package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.File;

import io.qameta.allure.Description;
import pages.MainPage;

public class ScreenshotTests extends BaseTest {

    private TestInfo testInfo;

    @BeforeEach
    public void init(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    @Description("Match main catalog screenshot with screenshot in the expectedScreenshots folder")
    @Test
    public void testMainCatalogScreenshot() {
        File mainScreenScreenshot = new MainPage()
                .closePopUp()
                .openCatalog()
                .fullPageScreenshot();
        assertScreenshot(mainScreenScreenshot, testInfo.getDisplayName());
    }

    @Test
    public void testMainCatalogScreenshotFail() {
        File mainScreenScreenshot = new MainPage().closePopUp()
                .fullPageScreenshot();
        assertScreenshot(mainScreenScreenshot, "testMainCatalogScreenshot()");
    }
}
