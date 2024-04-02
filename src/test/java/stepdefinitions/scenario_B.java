package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import utilities.Driver;

import java.time.Duration;

public class scenario_B {

    Homepage homepage = new Homepage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    private String getElementText() {
        return homepage.languageText.getText();
    }

    public void switchToLanguage(String languageCode) {
        // Click on the language selection and wait for the page to load
        homepage.languageButton.click();
        wait.until(ExpectedConditions.urlContains("/" + languageCode + "/"));
    }

    @When("User switches language to {string}")
    public void user_switches_language_to(String languageCode) {
        switchToLanguage(languageCode);
    }
    @Then("Page is displayed in English")
    public void page_is_displayed_in_english() {
        wait.until(ExpectedConditions.urlContains("/en/"));
        String elementText = getElementText();
        String expectedText = "OPEN POSITIONS";
        Assert.assertEquals(expectedText, elementText);
    }
    @Then("Page is displayed in Turkish")
    public void page_is_displayed_in_turkish() {
        wait.until(ExpectedConditions.urlContains("/tr/"));
        String elementText = getElementText();
        String expectedText = "AÇIK POZİSYONLAR";
        Assert.assertEquals(expectedText, elementText);
    }

}
