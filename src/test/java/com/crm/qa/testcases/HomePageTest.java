package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    MainPage mainPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.clickLoginBtn();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }


    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String title = homePage.verifyHomePage();
        Assert.assertEquals(title, "Cogmento CRM");
    }


    @Test(priority = 2)
    public void verifyUserName() {
        String name = homePage.getUserName();
        Assert.assertEquals(name, "John Alexeevich");
    }


    @Test(priority = 3)
    public void userNameIsDisplayed() {
        Assert.assertTrue(homePage.userNameIsDisplayed());
    }
    //50:48  https://www.youtube.com/watch?v=ea0P7MBQmiM&list=PLFGoYjJG_fqq6cHeqfsDes3pdVh3kpl74&index=3


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
