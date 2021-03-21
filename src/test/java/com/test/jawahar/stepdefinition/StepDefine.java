package com.test.jawahar.stepdefinition;

import com.test.jawahar.base.Base;
import com.test.jawahar.pages.*;
import com.test.jawahar.utility.TestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import java.util.concurrent.TimeUnit;

public class StepDefine extends Base {
    TestUtil testutil = new TestUtil();
    SignInPage signinpage;
    MyStorePage dashboard;
    TshirtPage tshirtPage;
    ProceedToCheckoutPages proceedToCheckoutPages;
    ConfirmPage confirm;
    MyPersonalInfoPage myPersonalInfoPage;
    LogoutPage logout;

    @Given("user logs into the automationpractice website")
    public void userlogsIntoTheAutomationpracticeWebsite() {
        Base.initialization();
    }

    @When("user inputs the valid email and password")
    public void userInputsTheValidEmailAndPassword() {
        signinpage = new SignInPage(driver);
        signinpage.Signin();
        String frontpagetitle = signinpage.verifylandingpagetitle();
        System.out.println("title of page:" + frontpagetitle);
        signinpage.Login();
        signinpage.password();
        signinpage.submit();
    }

    @Then("user enters the home automationpractice page")
    public void userEntersTheHomeAutomationpracticePage() {
        dashboard = new MyStorePage(driver);
        String dashboardtitle = dashboard.verifydashboardtitle();
        System.out.println("Title of page:" + dashboardtitle);
        Assert.assertEquals("My account - My Store", dashboardtitle);
        System.out.println("Title matched");
    }

    @Given("user lands on my order page")
    public void userClicksOnTShirtTab() {
        tshirtPage = new TshirtPage(driver);
        tshirtPage.clickTshirtTab();
        String tshirtpagetitle = tshirtPage.verifyTshirtpagetitle();
        System.out.println("title of page:" + tshirtpagetitle);
        Assert.assertEquals("T-shirts - My Store", tshirtpagetitle);
        System.out.println("Title matched");
    }

    @When("user selects a T-shirt")
    public void userSelectsATShirt() {
        tshirtPage.clickAddtoCart();
        tshirtPage.clickProceedToCheckoutCTA();
        String orderpagetitle = tshirtPage.verifyOrderpagetitle();
        System.out.println("title of page:" + orderpagetitle);
        Assert.assertEquals("Order - My Store", orderpagetitle);
        System.out.println("Title matched");
    }

    @Then("user proceeds to checkout by passing summary,address,shipping and payment screens")
    public void userProceedsToCheckoutByPassingSummaryAddressShippingAndPaymentScreens() {
        proceedToCheckoutPages = new ProceedToCheckoutPages(driver);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        proceedToCheckoutPages.clickOnSummaryPage();
        proceedToCheckoutPages.clickOnAddressPage();
        proceedToCheckoutPages.clickOnTermServiceCheckbox();
        proceedToCheckoutPages.clickOnShippingPage();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        proceedToCheckoutPages.clickOnPaymentPage();
    }

    @Then("Now User Clicks the Confirm Button")
    public void nowUserClicksTheConfirmButton() {
        confirm = new ConfirmPage(driver);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        confirm.confirmorder();
    }

    @And("order is successfully placed")
    public void orderIsSuccessfullyPlaced() {
        confirm = new ConfirmPage(driver);
        String orderconfirmationtitle = confirm.verifyorderconfirmationTitle();
        System.out.println("title of page:" + orderconfirmationtitle);
        Assert.assertEquals("Order confirmation - My Store", orderconfirmationtitle);
        System.out.println("Order placed successfully");
    }

    @And("user logs out from store")
    public void userLogsOutFromStore() {
        logout = new LogoutPage(driver);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        logout.logoutclick();
        System.out.println("User logs out of the website");
        driver.quit();
        System.out.println("User quits the browser");
    }

    @Given("user lands on personal information page")
    public void userLandsOnPersonalInformationPage() {
        myPersonalInfoPage = new MyPersonalInfoPage(driver);
        myPersonalInfoPage.clickonpersonalinfo();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        String personalinfotitle = myPersonalInfoPage.verifyPersonalinfopagetitle();
        System.out.println("Title of page:" + personalinfotitle);
        Assert.assertEquals("Identity - My Store", personalinfotitle);
        System.out.println("Title matched");

    }

    @And("user updates the last name value")
    public void userUpdatesTheLastNameValue() {
        myPersonalInfoPage = new MyPersonalInfoPage(driver);
        myPersonalInfoPage.lastname();
        myPersonalInfoPage.currentpassword();
    }

    @When("user save the changes")
    public void userSaveTheChanges() {
        myPersonalInfoPage = new MyPersonalInfoPage(driver);
        myPersonalInfoPage.clickonSaveButton();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @Then("value is successfully changed")
    public void valueIsSuccessfullyChanged() {
        myPersonalInfoPage = new MyPersonalInfoPage(driver);
        String successmessage = myPersonalInfoPage.verifySuccessMsg();
        Assert.assertEquals("Your personal information has been successfully updated.", successmessage);
    }
}
