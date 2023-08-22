package org.example;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {


    @Test
    public void ScrollDemoGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //approch 1 using anroidUIAutomator
        scrollToELementUsing_anroidUIAutomator("WebView");

        //approch 2 using appium method
        Boolean canScrollMore;

        scrollToEndAction();

        System.out.println();
    }

}