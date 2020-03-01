package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    MainPage mainPage;

    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialisation();
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }


    @Test
    public void loginTest() {
        mainPage.clickLoginBtn();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
