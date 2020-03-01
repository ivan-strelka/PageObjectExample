package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {
    MainPage mainPage;


    public MainPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        mainPage = new MainPage();
    }

    @Test(priority = 1)
    public void mainPageLogoExist() {
        boolean flag = mainPage.validateLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void validateTitle() {
        String title = mainPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
