package com.qa.screens;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FilterScreen extends BaseScreen{
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement screenTitleLbl;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Search\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement searchTxtFld;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement propIdTxtFld;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement cityDrpDwnFld;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement tenantTypeDrpDwnFld;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement applyBtn;

    public String getTitle(){
        return getText(screenTitleLbl,"Title is: ");
    }

    public FilterScreen enterCity(String city) throws InterruptedException {
        clear(searchTxtFld);
        sendKeys(searchTxtFld, city, "find city " + city);
        return this;
    }

    public FilterScreen enterPrpId(String id) throws InterruptedException {
        clear(propIdTxtFld);
        sendKeys(propIdTxtFld, id, "find id " + id);
        return this;
    }

    public PropertiesListScreen pressApplyBtn() throws InterruptedException {
        click(applyBtn, "press apply button");
        Thread.sleep(5000);
        return new PropertiesListScreen();
    }

    public FilterScreen scrollCityField(String city) throws Exception {
        click(cityDrpDwnFld,"Click city");
        scrollAndClickCityDropDown(city);
        return this;

    }

    public FilterScreen scrollTenantTypeField(String type) throws Exception {
        click(tenantTypeDrpDwnFld,"Click tenant");
        scrollAndClickCityDropDown(type);
        return this;
    }

}
