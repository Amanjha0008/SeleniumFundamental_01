package com.account.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyWishlist
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.ID, using = "ui-id-5")
    WebElement men_products;

    @FindBy(how = How.CSS, using = "div.sidebar.sidebar-main ul.items:nth-of-type(1) li.item:nth-of-type(1)")
    WebElement men_jackets;

    @FindBy(how = How.XPATH, using = "//div[@id=\"authenticationPopup\"]//following-sibling::div[2]//li[1]")
    WebElement product_hover_1;

    @FindBy(how = How.XPATH, using = "//div[@id=\"authenticationPopup\"]//following-sibling::div[2]//li[2]")
    WebElement product_hover_2;

    @FindBy(how = How.XPATH, using = "//div[@id=\"authenticationPopup\"]//following-sibling::div[2]//li[3]")
    WebElement product_hover_3;

    @FindBy(how = How.XPATH, using = "//div[@id='authenticationPopup']//following-sibling::div[2]//child::li[1]//child::div[2]//a[1]")
    WebElement wishlist_1;

    @FindBy(how = How.XPATH, using = "//div[@id='authenticationPopup']//following-sibling::div[2]//child::li[2]//child::div[2]//a[1]")
    WebElement wishlist_2;

    @FindBy(how = How.XPATH, using = "//div[@id='authenticationPopup']//following-sibling::div[2]//child::li[3]//child::div[2]//a[1]")
    WebElement wishlist_3;

    @FindBy(how = How.CSS, using = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button")
    WebElement dropdown_wish;

    @FindBy(how = How.XPATH, using = "//li[@class='customer-welcome active']//a[contains(text(),'My Wish List')]")
    WebElement myWishlist;

    @FindBy(how = How.CSS, using = "#wishlist-sidebar li.product-item:nth-of-type(3) div.product-item-info div.product-item-details div.product-item-actions div.actions-secondary a.btn-remove.action.delete")
    WebElement first_item_rem;

    @FindBy(how = How.CSS, using = "#wishlist-sidebar li.product-item:nth-of-type(1) div.product-item-info div.product-item-details div.product-item-actions div.actions-primary")
    WebElement last_item_add;

    @FindBy(how = How.ID, using = "option-label-size-143-item-166")
    WebElement size_of_Item;
    @FindBy(how = How.XPATH, using = "//div[@class=\"swatch-attribute color\"]//child::div[2]")
    WebElement color_of_Item;

    @FindBy(how = How.ID, using = "product-addtocart-button")
    WebElement add_to_cart;





    public MyWishlist(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    public void myWishlist_luma()
    {
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOf(men_products)); // Wait for visibility
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownButton).click().perform(); // Click dropdown button
        WebElement dropdownAccount1= wait.until(ExpectedConditions.elementToBeClickable(men_jackets)); // Wait for account link
        actions.moveToElement(dropdownAccount1).click().perform();

        WebElement prod_1 = wait.until(ExpectedConditions.visibilityOf(product_hover_1));
        actions.moveToElement(prod_1).perform();

        WebElement wish_1 = wait.until(ExpectedConditions.visibilityOf(wishlist_1));
        actions.moveToElement(wish_1).click().perform();
        driver.navigate().back();

        WebElement prod_2 = wait.until(ExpectedConditions.visibilityOf(product_hover_2));
        actions.moveToElement(prod_2).perform();

        WebElement wish_2 = wait.until(ExpectedConditions.visibilityOf(wishlist_2));
        actions.moveToElement(wish_2).click().perform();
        driver.navigate().back();

        WebElement prod_3 = wait.until(ExpectedConditions.visibilityOf(product_hover_3));
        actions.moveToElement(prod_3).perform();

        WebElement wish_3 = wait.until(ExpectedConditions.visibilityOf(wishlist_3));
        actions.moveToElement(wish_3).click().perform();
        driver.navigate().back();

        WebElement dropdownButton_wish = wait.until(ExpectedConditions.visibilityOf(dropdown_wish)); // Wait for visibility
        actions.moveToElement(dropdownButton_wish).click().perform(); // Click dropdown button
        WebElement dropdownWishlist = wait.until(ExpectedConditions.elementToBeClickable(myWishlist)); // Wait for account link
        dropdownWishlist.click();

        WebElement remove_item = wait.until(ExpectedConditions.visibilityOf(first_item_rem));
        actions.moveToElement(remove_item).click().perform();


        WebElement lastItem = wait.until(ExpectedConditions.visibilityOf(last_item_add));
        actions.moveToElement(lastItem).click().perform();

        WebElement sizeOfItem = wait.until(ExpectedConditions.visibilityOf(size_of_Item));
        actions.moveToElement(sizeOfItem).click().perform();

        WebElement colorOfItem = wait.until(ExpectedConditions.visibilityOf(color_of_Item));
        actions.moveToElement(colorOfItem).click().perform();


        WebElement addToCart = wait.until(ExpectedConditions.visibilityOf(add_to_cart));
        actions.moveToElement(addToCart).click().perform();
    }
}
