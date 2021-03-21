package com.test.jawahar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TshirtPage {

    WebDriver driver;

    public TshirtPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement TShirtTab;

    @FindBy(how = How.XPATH, using = "//img[@title='Faded Short Sleeve T-shirts']")
    private WebElement SelectTShirt;

    @FindBy(how = How.XPATH, using = "//a[@title='Add to cart']")
    private WebElement AddtoCart;

    @FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout']")
    private WebElement ProceedToCheckout0;


    public void clickTshirtTab() {
        TShirtTab.click();
    }

    public String verifyTshirtpagetitle() {
        return driver.getTitle();
    }

    public void clickAddtoCart() {
        Actions action = new Actions(driver);
        action.moveToElement(SelectTShirt).moveToElement(AddtoCart).click().build().perform();
    }

    public void clickProceedToCheckoutCTA() {
        ProceedToCheckout0.click();
    }

    public String verifyOrderpagetitle() {
        return driver.getTitle();
    }
}
