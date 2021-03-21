package com.test.jawahar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
	
WebDriver driver;
	
	public ConfirmPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//button[@class='button btn btn-default button-medium']")
	private WebElement confirmbtn;

	public void confirmorder(){
		confirmbtn.click();
	}
	
	public String verifyorderconfirmationTitle(){
		return driver.getTitle();
		
	}
}
