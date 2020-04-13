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
	
	HashMap<String, String> hMap = new HashMap<String, String>();


	public void patientLogin(String username, String password) throws Exception
	{
						
		WebDriverWait wait = new WebDriverWait(driver, 20 );
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		
			try
			{
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert alrt = driver.switchTo().alert();
			String successmsg = alrt.getText();
			System.out.println("suceessmsg"+successmsg);
			
			hMap.put("successmsg", successmsg);
			
			alrt.accept();
			System.out.println("alert accepted");
			Thread.sleep(3000);
			}
			catch(Exception e)
			{
				System.out.println("Alert was not present in patient login");
				System.out.println(e);
				
			}
		
		
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
