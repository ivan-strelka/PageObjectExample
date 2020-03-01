package com.crm.qa.base;

import com.crm.qa.utils.TestUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream("src/main/resources/config.properties");
            properties.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void initialisation() {
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/java/com/crm/qa/drivers/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "src/main/java/com/crm/qa/drivers/geckodriver-v0.26.0-linux64/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));


    }

}
