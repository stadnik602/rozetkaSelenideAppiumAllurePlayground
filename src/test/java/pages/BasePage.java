package pages;


import io.appium.java_client.MobileBy;

import java.io.File;
import java.util.List;

import util.WordingUtil;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

public class BasePage {

    public File fullPageScreenshot() {
        return $(MobileBy.id("android:id/content")).screenshot();
    }

    protected void compareCollectionsOfElements(ElementsCollection elements, List<String> texts) {
        elements.should(CollectionCondition.size(texts.size()));
        elements.should(CollectionCondition.textsInAnyOrder(texts));
    }

    protected void checkEachContainsText(ElementsCollection elements, String text) {
        elements.should(CollectionCondition.allMatch("should contain "+text, element -> element.getText().contains(text)));
    }

    protected void clickByElementWithText(String text) {
        String textInUtf8 = WordingUtil.toEncodedUtf8String(text);
        $(MobileBy.xpath("//android.widget.TextView[@text ='" + textInUtf8 + "']")).click();
    }
}
