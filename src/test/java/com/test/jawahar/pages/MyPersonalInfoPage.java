package com.test.jawahar.pages;

import com.test.jawahar.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInfoPage  extends Base {

    WebDriver driver;
    public static String Password = System.getProperty("Password");

    public MyPersonalInfoPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@title='Information']")
    private WebElement PersonalInfo;

    @FindBy(how = How.XPATH, using = "//input[@id='lastname']")
    private WebElement Lastname;

    @FindBy(how = How.XPATH, using = "//input[@id='old_passwd']")
    private WebElement currentpassword;

    @FindBy(how = How.XPATH, using = "//button[@name='submitIdentity']")
    private WebElement SaveButton;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    private WebElement alertsuccess;

    public void clickonpersonalinfo() {
        PersonalInfo.click();
    }

    public String verifyPersonalinfopagetitle() {
        return driver.getTitle();
    }

    public void lastname() {
        try {
            Lastname.clear();
            Lastname.sendKeys(Prop.getProperty("updatelastname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void currentpassword() {
        try {
            currentpassword.sendKeys(Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickonSaveButton() {
        SaveButton.click();
    }

    public String verifySuccessMsg() {
        return alertsuccess.getText();
    }

}
