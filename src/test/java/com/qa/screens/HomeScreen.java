package com.qa.screens;

import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeScreen extends BaseScreen{

    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement screenTitleLbl;

    @AndroidFindBy(accessibility = "Search")
    @iOSXCUITFindBy(id = "Search")
    private MobileElement searchTxtFld;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement firstTrendingCity;

    public String getTitle(){
        return getText(screenTitleLbl,"Title is: ");
    }

    public FilterScreen tapSearchField() {
        click(searchTxtFld, "press login button");
        return new FilterScreen();
    }

    public void tapToFirstTrendingProp(){
        click(firstTrendingCity,"First trending property clicked");
    }
}
