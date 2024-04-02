package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Homepage {

    public Homepage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='fix-btn']")
    public WebElement languageText;

    @FindBy(xpath = "//*[@class='btn circle  border btn-md']")
    public WebElement allOpenPositionButton;

    @FindBy(xpath = "//*[@class='main-input']")
    public WebElement searchTextbox;

    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    public WebElement unitCheckbox;

    @FindBy(xpath = "(//*[@class='position-head'])[1]")
    public WebElement positionList;

    @FindBy(xpath = "(//*[@class='position-category'])[1]")
    public WebElement positionCategory;

    @FindBy(xpath = "//*[@class='siteCustomLi']")
    public WebElement languageButton;


    private WebDriver driver;
    private static final String DROPDOWN_XPATH = "//*[@class='dropdown dropdown-right active']";

    public boolean hasDropdownMenu(WebElement navbarLink) {
        return !navbarLink.findElements(By.xpath(DROPDOWN_XPATH)).isEmpty();
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li")
    private List<WebElement> navbarLinks;

    // Navbar links method
    public List<WebElement> getNavbarLinks() {
        return navbarLinks;
    }

    // Dropdown menu elements method
    public List<WebElement> getDropdownItems(WebElement link) {
        return link.findElements(By.xpath("//*[@class='dropdown dropdown-right active']"));
    }

}
