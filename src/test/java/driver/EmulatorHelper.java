package driver;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import util.WordingUtil;

public class EmulatorHelper extends EmulatorDriver{
    public static void goBack() {
        driver.navigate().back();
    }

    public static void swipeBack() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


    public static void closeKeyBoard() {
        driver.hideKeyboard();
    }

    public static void sendKeysAndFind(SelenideElement element, String text) {
        element.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void sendKeys(SelenideElement element, String text) {
        element.sendKeys(text);
    }

    public static void androidScrollToAnElementByText(String text) {
        String command = "new UiScrollable(new UiSelector()" +
                ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
                ".textContains(\"" + WordingUtil.toEncodedUtf8String(text) + "\").instance(0))";
        driver.findElementByAndroidUIAutomator(command)
                .click();
    }
}
