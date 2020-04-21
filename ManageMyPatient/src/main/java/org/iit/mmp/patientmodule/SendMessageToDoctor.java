package org.iit.mmp.patientmodule;

import java.util.HashMap;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendMessageToDoctor
{

	
	
	WebDriver driver;
	
	HashMap<String, String> hashMap = new HashMap<String, String>();
	
	public SendMessageToDoctor(WebDriver driver) 
	{
		this.driver = driver;

	}

	
	public HashMap<String,String> sendMessageToDoctor(String messagesubject, String message) throws InterruptedException
	{
	
	
	HelperMethod submenu = new HelperMethod(driver);
	submenu.navigateToSubMenu("Messages");
	
	WebElement subject = driver.findElement(By.id("subject"));
	subject.sendKeys(messagesubject);
	String subjectofMessage = subject.getAttribute("value");
	hashMap.put("subject", subjectofMessage);

	
	WebElement messagedesc = driver.findElement(By.id("message"));
	messagedesc.sendKeys(message);
	String messagedescdetail = messagedesc.getAttribute("value");
	hashMap.put("messagedesc", messagedescdetail);



	driver.findElement(By.xpath("//input[@value='Send']")).click();
	
	Thread.sleep(2000);
	
	Alert alrt = driver.switchTo().alert();

	String successpopup = alrt.getText();
	hashMap.put("successPopup", successpopup);
	alrt.accept();
    Thread.sleep(3000);
    
     
    return hashMap;
	
	}
	
}
