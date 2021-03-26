package com.test.jawahar.pages;

import com.test.jawahar.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Base {

    WebDriver driver;
    public static String EmailAddress = System.getProperty("EmailAddress");
    public static String Password = System.getProperty("Password");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    private WebElement Signin;

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement Email;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
    private WebElement SignInbtn;


    public void Signin() {
        Signin.click();
    }

    public String verifylandingpagetitle() {
        return driver.getTitle();
    }

    public void Login() {
        try {
            Email.sendKeys(EmailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void password() {
        try {
            password.sendKeys(Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submit() {
        SignInbtn.click();
    }
}
