package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='rd-navbar-panel']//a[@class='brand-name']")
    private WebElement crmLogo;

    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    private WebElement logInButton;


    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateLogo() {
        return crmLogo.isDisplayed();
    }

    public LoginPage clickLoginBtn() {
        logInButton.click();
        return new LoginPage();
    }


    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage();
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }


}
