package com.account.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MyAccount
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.CSS, using = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button")
    WebElement dropdown;

    @FindBy(how = How.XPATH, using = "//li[@class='customer-welcome active']//a[contains(text(),'My Account')]")
    WebElement myAccount;

    @FindBy(how = How.ID, using = "street_1")
    WebElement street1;

    @FindBy(how = How.ID, using = "street_2")
    WebElement street2;

    @FindBy(how = How.ID, using = "street_3")
    WebElement street3;

    @FindBy(how = How.ID, using = "country")
    WebElement country;
    @FindBy(css = "[data-ui-id='default-shipping-edit-link']")
    private WebElement defaultShippingEditLink;

    @FindBy(how = How.ID, using = "region_id")
    private WebElement region;

    @FindBy(how = How.ID, using = "city")
    private  WebElement city;

    @FindBy(how = How.ID, using = "telephone")
    private WebElement telephone;
    @FindBy(how = How.ID, using = "zip")
    private WebElement zipcode;

    @FindBy(css = "[data-action='save-address']")
    private WebElement saveAddressBtn;

    public MyAccount(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    public void myAccLuma()
    {
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOf(dropdown)); // Wait for visibility
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownButton).click().perform(); // Click dropdown button
        WebElement dropdownAccount = wait.until(ExpectedConditions.elementToBeClickable(myAccount)); // Wait for account link
        dropdownAccount.click(); // Click account link
    }

    public void addShippingAddress(String str1, String str2, String str3, String country_drop, String cty, String mob, String zip)
    {
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOf(defaultShippingEditLink));
        dropdownButton.click();
        street1.sendKeys(str1);
        street1.clear();
        street1.sendKeys(str1);

        street2.sendKeys(str2);
        street2.clear();
        street2.sendKeys(str2);

        street3.sendKeys(str3);
        street3.clear();
        street3.sendKeys(str3);
        Select country_dropdown = new Select(country);
        country_dropdown.selectByValue(country_drop);
        Select region_dropdown = new Select(region);
        region_dropdown.selectByVisibleText("Uttar Pradesh");

        city.sendKeys(cty);
        city.clear();
        city.sendKeys(cty);

        telephone.sendKeys(mob);
        telephone.clear();
        telephone.sendKeys(mob);

        zipcode.sendKeys(zip);
        zipcode.clear();
        zipcode.sendKeys(zip);

        WebElement saveAddressButton = wait.until(ExpectedConditions.visibilityOf(saveAddressBtn));
        saveAddressButton.click();
    }
}
