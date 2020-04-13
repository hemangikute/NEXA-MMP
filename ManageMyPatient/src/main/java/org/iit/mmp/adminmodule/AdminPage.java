package org.iit.mmp.adminmodule;

import java.util.HashMap;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {

	WebDriver driver;
	
	public AdminPage(WebDriver driver) 
	{
		this.driver = driver;
		
	}

	public String approvePatient(HashMap<String, String> hMap) throws Exception
	{
		
		Select select = new Select(driver.findElement(By.id("search")));
		select.selectByVisibleText("Pending");
		
		
		driver.findElement(By.xpath("//a[contains(text(),'" +hMap.get("firstname")+"')]")).click();
		
		System.out.println("first name is "+hMap.get("firstname"));
		Thread.sleep(5000);
		
		Select approvepatient = new Select(driver.findElement(By.id("sapproval")));
	//	approvepatient.selectByVisibleText("Accepted");
		approvepatient.selectByValue("1");
	
		
		
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();

		String actual = alrt.getText();
		alrt.accept();
        Thread.sleep(3000);
    	HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Logout");
		
		return actual;
		

		
		
	}
	
	
}
