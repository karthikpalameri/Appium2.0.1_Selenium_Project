package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseTest {


    @Test
    public void DragGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement src = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement dst = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
        Rectangle rect = dst.getRect();

        int x = rect.getPoint().getX();
        int y = rect.getPoint().getY();

        x = x + (rect.getWidth() / 2);
        y = y + (rect.getHeight() / 2);


        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) src).getId(),
                "endX", x,
                "endY", y
        ));

        String resultText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();

        Assert.assertEquals(resultText, "Dropped!");
    }

}