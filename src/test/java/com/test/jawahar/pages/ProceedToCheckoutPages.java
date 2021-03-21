package com.test.jawahar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProceedToCheckoutPages {

    WebDriver driver;

    public ProceedToCheckoutPages(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p[2]/a[1]")
    private WebElement SummaryCheckout;

    @FindBy(how = How.XPATH, using = "//button[@name='processAddress']")
    private WebElement ProcessAddress;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private WebElement AgreeTermService;

    @FindBy(how = How.XPATH, using = "//button[@name='processCarrier']")
    private WebElement ProcessCarrier;

    @FindBy(how = How.XPATH, using = "//a[@class='bankwire']")
    private WebElement Bankwire;

    public void clickOnSummaryPage() {
        SummaryCheckout.click();
    }
    public void clickOnAddressPage() {
        ProcessAddress.click();
    }
    public void clickOnTermServiceCheckbox() {
        AgreeTermService.click();
    }
    public void clickOnShippingPage() {
        ProcessCarrier.click();
    }
    public void clickOnPaymentPage() {
        Bankwire.click();
    }

}
