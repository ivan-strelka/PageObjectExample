package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(xpath = "//span[@class='user-display']")
    private WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    private WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    private WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    private WebElement tasksLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public String verifyHomePage() {
        return driver.getTitle();
    }


    public String getUserName() {
        return userNameLabel.getText();
    }

    public boolean userNameIsDisplayed() {
        return userNameLabel.isDisplayed();
    }

    public ContactPage clickOnContactLink() {
        contactsLink.click();
        return new ContactPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickOnTasksLink() {
        tasksLink.click();
        return new TaskPage();
    }


}
