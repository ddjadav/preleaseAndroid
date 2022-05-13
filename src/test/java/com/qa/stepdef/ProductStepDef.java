package com.qa.stepdef;

import com.qa.screens.LoginScreen;
import com.qa.screens.ProductDetailsScreen;
import com.qa.screens.ProductsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {

    @Given("^I'm logged in$")
    public void iMLoggedIn() throws InterruptedException {
        new LoginScreen().login("standard_user", "secret_sauce");
    }

    @Then("^the product is listed with title \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
        Boolean titleCheck = new ProductsScreen().getProductTitle(title).equalsIgnoreCase(title);
        Boolean priceCheck = new ProductsScreen().getProductPrice(title, price).equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", priceCheck = " + priceCheck,
                titleCheck & priceCheck);
    }

    @When("^I click product title \"([^\"]*)\"$")
    public void iClickProductTitle(String title) throws Exception {
        new ProductsScreen().pressProductTitle(title);
    }

    @Then("^I should be on product details page with title \"([^\"]*)\", price \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) throws Exception {
        ProductDetailsScreen productDetailsPage = new ProductDetailsScreen();
        boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(title);
        boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(description);
        boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
                titleCheck & descCheck & priceCheck);
    }
}
