package com.qa.stepdef;

import com.qa.screens.*;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HomeSetpDef {
    TestUtils utils = new TestUtils();
    HomeScreen homeScreen = new HomeScreen();
    FilterScreen filterScreen = new FilterScreen();
    PropertiesListScreen propertiesListScreen = new PropertiesListScreen();
    NavigationBar navigationBar = new NavigationBar();
    ProfileScreen profileScreen = new ProfileScreen();
    String globalCity = null;
    String globalType = null;
    @Given("User is on home screen")
    public void userIsOnHomeScreen() {
        assertThat(homeScreen.getTitle(), is("Property That Makes Money"));
    }

    @When("User click on search field")
    public void userClickOnSearchField() {
        homeScreen.tapSearchField();
    }

    @Then("User should navigate to filter screen")
    public void userShouldNavigateToFilterScreen() {
        assertThat(filterScreen.getTitle(),is("Filter"));
    }

    @Given("User is on Filter page")
    public void userIsOnFilterPage() {
        homeScreen.tapSearchField();
        assertThat(filterScreen.getTitle(),is("Filter"));
    }

    @When("User enter {string} in search field")
    public void userEnterInSearchField(String city) throws Exception {
        globalCity = city;
        filterScreen.enterCity(city);
        Thread.sleep(3000);
        filterScreen.pressApplyBtn();
        Thread.sleep(5000);
    }

    @Then("User should get list of property of that city")
    public void userShouldGetListOfPropertyOfThatCity() {
        String locationCheck = propertiesListScreen.getLocation(globalCity);
        Assert.assertEquals("Property not found",globalCity,locationCheck);
    }

    @When("User enter {string} in property ID field")
    public void userEnterInPropertyIDField(String ID) throws InterruptedException {
        filterScreen.enterPrpId(ID);
        Thread.sleep(3000);
        filterScreen.pressApplyBtn();
        Thread.sleep(5000);
    }

    @Then("User should get list of property of that id")
    public void userShouldGetListOfPropertyOfThatId() {
        //TODO need to assert from product detail page
//        String locationCheck = new PropertiesListScreen().getLocation(globalParam);
//        Assert.assertEquals("Property not found",globalParam,locationCheck);
        System.out.println("");
    }

    @When("User select {string} from city dropdown")
    public void userSelectFromCityDropdown(String city) throws Exception {
        globalCity = city;
        filterScreen.scrollCityField(city);
        Thread.sleep(3000);
        filterScreen.pressApplyBtn();
        Thread.sleep(5000);
    }

    @When("User click on profile button")
    public void userClickOnProfileButton() {
        navigationBar.navigateToProfile();
    }

    @Then("User should navigate to profile screen")
    public void userShouldNavigateToProfileScreen() {
        assertThat(profileScreen.getTitle(),is("Profile"));
    }

    @When("User select {string} from tenant type dropdown")
    public void userSelectFromTenantTypeDropdown(String typ) throws Exception {
        globalType = typ;
        filterScreen.scrollTenantTypeField(typ);
        Thread.sleep(3000);
        filterScreen.pressApplyBtn();
        Thread.sleep(5000);
    }

    @Then("User should get list of property of that tenant type")
    public void userShouldGetListOfPropertyOfThatTenantType() {
        //TODO need uncomment after new build receive
//        String typeCheck = propertiesListScreen.getPropertyType(globalType);
//        Assert.assertEquals("Property not found",globalType,typeCheck);
    }


}
