package com.qa.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @author Dilip
 * @created at 12-05-2022 15:54
 */
public class ProfileScreen extends BaseScreen{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement screenTitle;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement loginBtn;

    public String getTitle(){
        return getText(screenTitle,"Title is: ");
    }
}
