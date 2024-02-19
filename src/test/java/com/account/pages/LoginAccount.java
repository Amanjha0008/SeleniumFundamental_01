package com.account.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginAccount
{
    WebDriver driver;


    public LoginAccount(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    WebElement signInHome;

    @FindBy(how = How.ID, using = "email")
    WebElement emailInput;

    @FindBy(how = How.ID, using =  "pass")
    WebElement passwordInput;

    @FindBy(how = How.ID, using =  "send2")
    WebElement submitBtn;

    public void loginLuma(String email, String password)
    {
        signInHome.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }
}
