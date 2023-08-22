package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AppiumBasics extends BaseTest{

    @Test
    public void WifiSettingName() throws IOException {

        System.out.println("This is AppiumTest");

        //Appium code-> Appium server -> Mobile

        //Android supports : Xpath , id, accessibilityId,className,androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        //set wifiname
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String altertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(altertTitle,"WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("TestWifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}