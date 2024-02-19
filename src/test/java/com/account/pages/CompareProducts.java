package com.account.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CompareProducts
{
    WebDriver driver;
    WebDriverWait wait;

    // Initialize PageFactory
    @FindBy(how = How.CLASS_NAME, using = "logo")
    WebElement logoHome;

    @FindBy(how = How.CSS, using = "ol.product-items.widget-product-grid li.product-item:nth-of-type(1)")
    WebElement firstProductHover;

    @FindBy(how = How.CSS, using = ".block-products-list.grid li:first-child .actions-secondary a.tocompare")
    WebElement compare_1;

    @FindBy(how = How.CSS, using = "ol.product-items.widget-product-grid li.product-item:nth-of-type(2)")
    WebElement secondProductHover;

    @FindBy(how = How.CSS, using = ".block-products-list.grid li:nth-child(2) .actions-secondary a.tocompare")
    WebElement compare_2;

    @FindBy(how = How.CSS, using = ".action.compare")
    WebElement compareList;
    @FindBy(how = How.CSS, using = "#product-comparison tbody:nth-child(3) td:nth-child(2) button")
    WebElement addToCart;

    @FindBy(how = How.ID, using = "option-label-size-143-item-166")
    WebElement size_of_Item;

    @FindBy(how = How.ID, using = "option-label-color-93-item-56")
    WebElement color_of_Item;

    @FindBy(how = How.ID, using = "product-addtocart-button")
    WebElement add_to_cart;

    @FindBy(how = How.CSS, using = "#product-comparison > thead > tr > td:nth-child(2) > a")
    WebElement delete;

    @FindBy(how = How.CSS, using = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button")
    WebElement dropdown;

    @FindBy(how = How.XPATH, using = "//li[@class='customer-welcome active']//a[contains(text(),'My Wish List')]")
    WebElement myAccount;

    @FindBy(how = How.ID, using = "compare-clear-all")
    WebElement clearAll;

    @FindBy(how = How.CSS, using = ".action-primary.action-accept")
    WebElement popup;

    public CompareProducts(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    public void compareProduct()
    {
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOf(logoHome)); // Wait for visibility
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownButton).click().perform(); // Click dropdown button

        JavascriptExecutor scrollHomePage = (JavascriptExecutor) driver;
        scrollHomePage.executeScript("window.scrollBy(0,460)");

        WebElement prod_1 = wait.until(ExpectedConditions.visibilityOf(firstProductHover));
        actions.moveToElement(prod_1).perform();

        WebElement compareFirst = wait.until(ExpectedConditions.visibilityOf(compare_1));
        actions.moveToElement(compareFirst).click().perform();

        WebElement prod_2 = wait.until(ExpectedConditions.visibilityOf(secondProductHover));
        actions.moveToElement(prod_2).perform();

        WebElement compareSecond = wait.until(ExpectedConditions.visibilityOf(compare_2));
        actions.moveToElement(compareSecond).click().perform();

        WebElement myCompareList = wait.until(ExpectedConditions.visibilityOf(compareList));
        actions.moveToElement(myCompareList).click().perform();

        WebElement myAddToCart= wait.until(ExpectedConditions.visibilityOf(addToCart));
        actions.moveToElement(myAddToCart).click().perform();

        WebElement sizeOfItem = wait.until(ExpectedConditions.visibilityOf(size_of_Item));
        actions.moveToElement(sizeOfItem).click().perform();

        WebElement colorOfItem = wait.until(ExpectedConditions.visibilityOf(color_of_Item));
        actions.moveToElement(colorOfItem).click().perform();


        WebElement addToCart = wait.until(ExpectedConditions.visibilityOf(add_to_cart));
        actions.moveToElement(addToCart).click().perform();

        WebElement myCompareList2 = wait.until(ExpectedConditions.visibilityOf(compareList));
        actions.moveToElement(myCompareList2).click().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement deleteOne = wait.until(ExpectedConditions.visibilityOf(delete));
        actions.moveToElement(deleteOne).click();
    }

    public void myAccLuma()
    {
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOf(dropdown)); // Wait for visibility
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownButton).click().perform(); // Click dropdown button

        WebElement dropdownAccount = wait.until(ExpectedConditions.elementToBeClickable(myAccount)); // Wait for account link
        dropdownAccount.click(); // Click account link

        WebElement claerAllProduct = wait.until(ExpectedConditions.visibilityOf(clearAll));
        claerAllProduct.click();

        WebElement popUpButton = wait.until(ExpectedConditions.visibilityOf(popup));
        popUpButton.click();
    }
}
