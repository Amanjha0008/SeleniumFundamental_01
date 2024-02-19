package com.account.test;

import com.account.pages.*;
import org.example.Helper.BrowserFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.example.Helper.BrowserFactory.driver;


public class LumaTestFlow
{
    private static final
    Logger logger = Logger.getLogger(AddToCart.class.getName());

    @BeforeTest
    public void createAccount() {
        // Launch the browser
        driver = BrowserFactory.startBrowser("chrome", "https://magento.softwaretestingboard.com/");
        String page_title = driver.getTitle();

        // Printing the title of the Page
        logger.info("Page Title: " + page_title);

        // Create a new account
        CreateAccount createAccount = PageFactory.initElements(driver, CreateAccount.class);
        createAccount.create_luma("virat", "mishra", "mishraviratone@gmail.com", "Virat@123", "Virat@123");
    }

    @Test(priority = 0)
    public void login_Account_luma(){
        //it will perform the Login operation
        LoginAccount login_Account = PageFactory.initElements(driver, LoginAccount.class);
        login_Account.loginLuma("mishraviratone@gmail.com", "Virat@123");

    }


    @Test(priority = 1)
    public void myAccount(){
        // 2. It will visit the My Account that will our second operation
        MyAccount dropdown_acc = PageFactory.initElements(driver, MyAccount.class);
        dropdown_acc.myAccLuma();
        dropdown_acc.addShippingAddress("AD01", "GT ROAD", "Kalyanpur", "IN", "Kanpur", "7438738437", "209217");

    }
    @Test(priority = 2)
    public void myWishlist(){
        // It will perfrom the wishlist operation
        MyWishlist myWishProduct = PageFactory.initElements(driver, MyWishlist.class);
        myWishProduct.myWishlist_luma();
    }


    @Test(priority = 3)
    public void myCompareList(){
        //It will perform the Compare into the products
        CompareProducts myCompareProducts = PageFactory.initElements(driver, CompareProducts.class);
        myCompareProducts.compareProduct();
        myCompareProducts.myAccLuma();
    }

    @Test(priority = 4)
    public void addTOCartProducts(){
        //This will perform the add to cart of products
        AddToCart cartProducts = PageFactory.initElements(driver, AddToCart.class);
        cartProducts.addToCartProduct();
        cartProducts.setPlaceOrder();

    }

    @AfterTest
    public void tearDown(){
        // I am using driver.close() because here we are currently focused in the single browser window & tab
        driver.close();
    }
}
