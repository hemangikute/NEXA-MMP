package org.iit.mmp.HelperMethods;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperMethod {
	
	
	WebDriver driver;
	HashMap<String, String> hMap1 = new HashMap<String, String>();
	
	public HelperMethod(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	

	public void navigateToSubMenu(String subMenuTxt)
	{
		
		driver.findElement(By.xpath("//ul/li/a/span[contains(text(),'"+subMenuTxt+"')]")).click();
	    System.out.println("submenu users clicked");
	}
	

	
}
