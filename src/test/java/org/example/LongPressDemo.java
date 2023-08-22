package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressDemo extends BaseTest{

    @Test
    public void LongPressGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNamesElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));

        //downcasting to RemoteWebElement as the getId() method is only defined in RemoteWebelement which implements the WebElement Interface and the WebElement Interface does not have this getId() method
        String peopleNamesElementId = ((RemoteWebElement) peopleNamesElement).getId();

        //https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        longPressAction( peopleNamesElement);

        WebElement menuElement = driver.findElement(AppiumBy.id("android:id/title"));
        String menuText = menuElement.getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(menuElement.isDisplayed());
    }

}