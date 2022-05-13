package com.qa.screens;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


public class PropertiesListScreen extends BaseScreen{
    private AppiumDriver<?> driver;
    TestUtils utils = new TestUtils();

    public PropertiesListScreen(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement locationNameLbl;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement propertyTypeNameLbl;

    @iOSXCUITFindBy(xpath = "//android.widget.ScrollView")
    private MobileElement iOSSCrollView;

    public String checkLocation(String city){
        String loc = null;
        try {
            switch (new GlobalParams().getPlatformName()) {
                case "Android":
                    loc = getText(andScrollToElementUsingUiScrollable("text", city), "Location text is: " + city);
                    break;
                case "iOS":
                    loc = getText(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '" + city + "'"),
                            "Location text is: " + city);
                    break;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            utils.log().info("No property found: " + e.getMessage());
        }
        return loc;
    }

    public String getLocation(String city){
        String loc=null;
        if(checkLocation(city)== null) {
            loc= getText(locationNameLbl, "Location text is:");
        }else {
          loc = checkLocation(city);
        }
        return loc;
    }

    public String getPropertyType(String type){
        String typ=null;
        if(checkLocation(type)== null) {
            typ= getText(propertyTypeNameLbl, "Type text is:");
        }else {
            typ = checkLocation(type);
        }
        return typ;
    }

    public List<String> getLocationList(){
        List<String> locList = new ArrayList<>();

        List<MobileElement> cards = (List<MobileElement>) driver.findElementsByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
        for (int i = 1; i <= cards.size(); i++) {
            MobileElement m = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["+i+"]/android.view.ViewGroup/android.widget.TextView[2]");
            String locName = m.getText();
            locList.add(locName);
        }
        return locList;
    }

}
