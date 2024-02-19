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
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.logging.Logger;

public class AddToCart
{

    private static final
    Logger logger = Logger.getLogger(AddToCart.class.getName());
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(how = How.CSS, using = ".action.showcart")
    private WebElement addToCartLogo;

    @FindBy(how = How.CSS, using = "span.count")
    private WebElement cart_size_element;

    @FindBy(how = How.CSS, using = ".details-qty.qty")
    private WebElement quantity;

    @FindBy(how = How.CSS, using = "[data-item-qty]")
    private WebElement Incquantity;

    @FindBy(how = How.CSS, using = "div.subtotal span.price")
    private WebElement orderTotalText;

    @FindBy(how = How.ID, using = "top-cart-btn-checkout")
    private WebElement proceedToCheckout;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-buttons-container\"]/div/button/span")
    WebElement next;

    @FindBy(how = How.CSS, using = "new-address-popup")
    private WebElement placeOrder;

    @FindBy(how = How.CSS, using = ".order-number")
    private WebElement order;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    @Test
    public void addToCartProduct()
    {
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOf(addToCartLogo)); // Waiting for the visibility
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCart).click().perform();

        //Printing the size of the cart
        String cartSize = cart_size_element.getText();
        logger.info("Size of the cart: " + cartSize);

        quantity.click();

        AddToCart page = new AddToCart(driver);
        PageFactory.initElements(driver, page);

        // Quantity update - Get the current quantity
        int currentQuantity = Integer.parseInt(page.Incquantity.getAttribute("data-item-qty"));

        // It will Increase the quantity by 1
        int newQuantity = currentQuantity + 1;

        // Update the quantity attribute of the element
        page.Incquantity.getAttribute("data-item-qty");

        // It willm store the cost value
        String orderTotal = orderTotalText.getText();

        // Print the total cost of the cart
        logger.info("Total cost of the cart: " + orderTotal);

        WebElement proceedCheckout = wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
        actions.moveToElement(proceedCheckout).click().perform();

    }

    public void setPlaceOrder()
    {
        Actions actions = new Actions(driver);
        JavascriptExecutor scrollHomePage = (JavascriptExecutor) driver;
        scrollHomePage.executeScript("window.scrollBy(0,100)");

        WebElement nextCheck = wait.until(ExpectedConditions.visibilityOf(next)); // Waiting for the visibility
        actions.moveToElement(nextCheck).click().perform();

        WebElement placeOrderProduct = wait.until(ExpectedConditions.visibilityOf(placeOrder)); // Waiting for the visibility
        actions.moveToElement(placeOrderProduct).click().perform();

        String orderTotal = order.getText();
        logger.info("Your Order number is: " +orderTotal);
    }
}
