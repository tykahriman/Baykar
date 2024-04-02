package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;

public class scenario_A {

    private WebDriverWait wait;
    private Homepage navbar;


    @Given("Access to baykartech Home Page")
    public void access_to_baykartech_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Then("Click on all navbar elements and verify the pages open without any problems")
    public void click_on_all_navbar_elements_and_verify_the_pages_open_without_any_problems() {
        ReusableMethods.wait(2);
        List<WebElement> navbarLinks = navbar.getNavbarLinks();
        for (WebElement link : navbarLinks) {
            link.click();
            wait.until(ExpectedConditions.urlContains((ConfigReader.getProperty("url"))));

            if (navbar.hasDropdownMenu(link)) {
                List<WebElement> dropdownMenus = navbar.getDropdownItems(link);
                for (WebElement dropdownItem : dropdownMenus) {
                    dropdownItem.click();
                    wait.until(ExpectedConditions.urlContains((ConfigReader.getProperty("url"))));
                }
            } else {
                wait.until(ExpectedConditions.urlContains((ConfigReader.getProperty("url"))));
            }
        }
    }
    @And("Close the page")
    public void closeThePage() {
        ReusableMethods.wait(1);
        Driver.quitDriver();
    }
}
