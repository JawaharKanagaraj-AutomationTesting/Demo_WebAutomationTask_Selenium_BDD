package com.test.jawahar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.test.jawahar.utility.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public static WebDriver driver;
    public static Properties Prop;
    public static String browser = System.getProperty("browser");

    public Base() {
        try {
            Prop = new Properties();
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            Prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("FF")) {
            System.out.println("Driver not found");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(Prop.getProperty("url"));
    }
}
