package org.iit.mmp.patientmodule;

import java.util.Date;
import java.util.List;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAnAppointment {
	
WebDriver driver;
	
	public ScheduleAnAppointment(WebDriver driver) 
	{
		this.driver = driver;

	}

	
	
	public void scheduleAnAppointment(String DrName)
	{
		String AppointmentDate = "March/15/2022";
		String Day, Month , Year;
		
		String []date = AppointmentDate.split("/");   //delimeter
		
		Day = date[1];
		Month = date[0];
		Year = date[2];
		
		String CalYear, CalMonth, CalDate;
		
			
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Schedule Appointment");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
   	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel panel-cascade']//div//a//input"))).click();
   	 
		driver.findElement(By.xpath("//h4[text()="+"'"+ DrName +"'"+ "]/ancestor::td/descendant::button[text()='Book Appointment']")).click();

		
		int size = driver.findElements(By.xpath("//iframe[@id='myframe']")).size();
		System.out.println("no of frames available"+size);
		driver.switchTo().frame(0);
		System.out.println("i am in new frame");
		
		WebElement dateelement = driver.findElement(By.xpath("//input[@id='datepicker']"));
			
		if (dateelement.isEnabled())
		{
			dateelement.click();
		}
		
		CalYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        while(!CalYear.equals(Year))
        {
     	   driver.findElement(By.xpath("//a[@title='Next']/span[text()='Next']")).click();
     	   CalYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        }
        
			      
        CalMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        
        while(!CalMonth.equals(Month))
		{
			driver.findElement(By.xpath("//a[@title='Next']/span[text()='Next']")).click();
			CalMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
  
		
        List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for(int i=0; i<Dates.size(); i++)
        {
     	   WebElement e = Dates.get(i);
     	   if(e.getText().equals(Day))
					{
						System.out.println("printing e after if" +e.getText());
						e.click();
						break;
					}
     	   
        }
        
        
        Select time = new Select(driver.findElement(By.id("time")));
        time.selectByVisibleText("11Am");
        
        driver.findElement(By.id("ChangeHeatName")).click();
        
        driver.findElement(By.id("sym")).sendKeys("cough cold");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        
					
	}
	
	
	
	
}
