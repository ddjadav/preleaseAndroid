package com.qa.screens;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Dilip
 * @created at 12-05-2022 12:23
 */
public class PropertyDetailsScreen extends BaseScreen{

    private AppiumDriver<?> driver;
    TestUtils utils = new TestUtils();

    public PropertyDetailsScreen(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement firstPropertyCard;

    public void gotToPropertyDetail(){
        click(firstPropertyCard,"Property Card Tapped");
    }
}
