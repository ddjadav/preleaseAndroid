package com.qa.stepdef;

import com.qa.screens.LoginScreen;
import com.qa.screens.ProductsScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @When("^I enter username as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginScreen().enterUserName(username);
    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) {
        new LoginScreen().enterPassword(password);
    }

    @When("^I login$")
    public void iLogin() {
        new LoginScreen().pressLoginBtn();
    }

    @Then("^login should fail with an error \"([^\"]*)\"$")
    public void loginShouldFailWithAnError(String err) {
        Assert.assertEquals(new LoginScreen().getErrTxt(), err);
    }

    @Then("^I should see Products page with title \"([^\"]*)\"$")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsScreen().getTitle(), title);
    }
}
