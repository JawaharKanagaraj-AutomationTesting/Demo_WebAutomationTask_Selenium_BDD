package com.test.jawahar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
WebDriver driver;
	
	public LogoutPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='logout']")
	private WebElement Logoutbtn;

	
	public void logoutclick(){
		Logoutbtn.click();
	}

}
