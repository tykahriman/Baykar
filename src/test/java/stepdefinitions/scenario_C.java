package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.Homepage;
import utilities.Driver;
import utilities.ReusableMethods;

public class scenario_C {

    Homepage homepage = new Homepage();

    JavascriptExecutor scroll = (JavascriptExecutor) Driver.getDriver();


    @Given("User clicks on Baykar Career All Open Positions button")
    public void user_clicks_on_baykar_career_all_open_positions_button() {
        scroll.executeScript("window.scrollBy(0,1200)","");
        homepage.allOpenPositionButton.click();
        scroll.executeScript("window.scrollBy(0,300)","");
    }
    @When("User searches for a position with keyword {string}")
    public void user_searches_for_a_position_with_keyword(String string) {
        homepage.searchTextbox.sendKeys(string);
    }
    @Then("Verify that the searched position is displayed")
    public void verify_that_the_searched_position_is_displayed() {
        Assert.assertTrue(homepage.positionList.isDisplayed());
        ReusableMethods.wait(2);
    }
    @When("User searchs for a position with unit")
    public void userSearchsForAPositionWithUnit() {
        homepage.unitCheckbox.click();
    }
    @Then("Verify that the searched position's title contains the keyword")
    public void verify_that_the_searched_position_s_title_contains_the_keyword() {
        Assert.assertTrue(homepage.positionCategory.isDisplayed());
    }
}
