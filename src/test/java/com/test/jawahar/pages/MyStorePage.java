package com.test.jawahar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage {

WebDriver driver;
	
	public MyStorePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public String verifydashboardtitle(){
		return driver.getTitle();
		
	}

}
