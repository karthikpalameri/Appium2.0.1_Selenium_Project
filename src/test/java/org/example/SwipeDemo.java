package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest {


    @Test
    public void SwipeDemoGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstImageEle = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        String focusable = firstImageEle.getAttribute("focusable");

        Assert.assertEquals(focusable, "true");

        //swipe left

        swipeAction(firstImageEle, "left");

        focusable = firstImageEle.getAttribute("focusable");

        Assert.assertEquals(focusable, "false");

        System.out.println();
    }

}