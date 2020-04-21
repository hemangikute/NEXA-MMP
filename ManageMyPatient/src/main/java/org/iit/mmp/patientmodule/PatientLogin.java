package org.iit.mmp.patientmodule;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientLogin {
	
WebDriver driver;
	
	public PatientLogin(WebDriver driver) 
	{
		this.driver = driver;

	}
	

    

	public void patientLogin(String username, String password) throws Exception
	{
						
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.name("submit")).click();
	
			
		
		
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.name("submit")).click();
		
		
	}
	
	public String fetchUname()
	{
		String unameValue = driver.findElement(By.tagName("h3")).getText();
		return unameValue;
	}
	
}
