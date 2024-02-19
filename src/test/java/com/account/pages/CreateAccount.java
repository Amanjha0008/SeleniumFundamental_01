package com.account.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccount
{
    WebDriver driver;
    public CreateAccount(WebDriver driver){
        this.driver = driver;
    }

    // Locator for the Create Account by using @FindBy
    @FindBy(how = How.CSS, using = "div.panel.header ul.header.links li a[href*='/customer/account/create/']")
    WebElement createAcnt;
    @FindBy(how = How.ID, using = "firstname") WebElement firstName;
    @FindBy(how = How.ID, using = "lastname") WebElement lastName;

    @FindBy(how = How.ID, using = "email_address") WebElement emailAddress;

    @FindBy(how = How.ID, using = "password") WebElement password;

    @FindBy(how = How.ID, using = "password-confirmation") WebElement passwordConfirmation;

    @FindBy(how = How.CSS, using = ".action.submit.primary")
    WebElement createBtn;

    public void create_luma(String fname, String lname, String eaddress, String pass_word, String conf_pass )
    {
        createAcnt.click();
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        emailAddress.sendKeys(eaddress);
        password.sendKeys(pass_word);
        passwordConfirmation.sendKeys(conf_pass);
        createBtn.click();
    }


}
