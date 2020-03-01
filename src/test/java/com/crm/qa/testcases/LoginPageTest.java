package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialisation();
        loginPage = new LoginPage();
    }


    @Test
    public void loginTest() {
        driver.get(properties.getProperty("login_url"));
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
