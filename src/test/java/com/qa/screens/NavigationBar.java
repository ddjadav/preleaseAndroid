package com.qa.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @author Dilip
 * @created at 12-05-2022 15:58
 */
public class NavigationBar extends BaseScreen{

    @AndroidFindBy(accessibility = "Home")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement homeBtn;

    @AndroidFindBy(accessibility = "Profile")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement profileBtn;

    public void navigateToHome(){
        click(homeBtn,"I am on Home screen");
    }

    public void navigateToProfile(){
        click(profileBtn, "I am on Profile screen");
    }
}
