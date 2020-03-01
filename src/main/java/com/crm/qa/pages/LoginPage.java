package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {


    @FindBy(xpath = "//input[@placeholder='E-mail address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    private WebElement logInButton;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logInButton.click();
        return new HomePage();
    }


}
