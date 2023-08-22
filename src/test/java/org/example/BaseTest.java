package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        //start appium programmatically
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4724)
                .build();
        service.start();

        //create driver using options and url
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL API 34_emulator");
        options.setApp("/Users/karthikp/Documents/GitHub/Appium2.0.1_Selenium_Project/src/test/java/resources/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    public void longPressAction(WebElement ele) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", "2000"
        ));
    }

    protected void scrollToEndAction() {
        //enable developer settings and enable show tap mode and pointer location
        Boolean canScrollMore;
        //scroll till end using appium javascript executor
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 400, "top", 1200,
                    "width", 400, "height", 400,
                    "direction", "down",
                    "percent", 36.0,
                    "speed", 500
            ));
        } while (canScrollMore);
    }

    protected void scrollToELementUsing_anroidUIAutomator(String scrollTillText) {
        //approch 1 of scrolling using androidUIAutomator
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + scrollTillText + "\"));"));
    }

    protected void swipeAction(WebElement firstImageEle, String left) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstImageEle).getId(),
                "direction", left,
                "percent", 0.75
        ));
    }
}
