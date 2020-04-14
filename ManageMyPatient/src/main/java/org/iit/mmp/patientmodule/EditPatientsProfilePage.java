package org.iit.mmp.patientmodule;

import java.util.HashMap;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPatientsProfilePage {
	
	/*
	 * STEP1: GOTO URL "http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/profile.php"
	 * STEP2: CLICK ON "PATIENT LOGIN".
	 * STEP3: CLICK ON "REGISTER" BUTTON
	 * STEP4: ENTER VALID DATA AND CLICK ON "SAVE" BUTTON.
	 * STEP5: CLICK ON "OK" BUTTON ON POP UP WINDOW.
	 * STEP6: VALIDATE DATA IS REFLECTED IN THE PROFILE PAGE OF THE PATIENT.
	 * STEP7:
	 * 
	 */

	WebDriver driver;
	
	public EditPatientsProfilePage(WebDriver driver) 
	{
		this.driver = driver;	
		
	}
        System.out.println("creating a new hashmap");
	HashMap<String, String> hMap = new HashMap<String, String>();


	public boolean ValidatePatientProfile(	HashMap<String, String> hMap ) throws Exception
	{
		
	
		
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Profile");
		boolean result = false;
		
		
		String expectedweight = hMap.get("weight");
		System.out.println("expected weight from hmap"+expectedweight);
		String actualweight = driver.findElement(By.name("weight")).getAttribute("value");
		String actualage = driver.findElement(By.xpath("//input[@name='age']")).getAttribute("value");

		System.out.println("actual weight"+actualweight);
		System.out.println("actual age"+actualage);

		
				if(actualweight.equals(expectedweight))
				{
					result = true;
		
				}
		return result;
	     
	
		
	}

	
	
	public boolean editProfilePage(String fname, String lname, String licn, String ssn,
			String height,String state, String city, String address, 
			String zipcode, String age, String weight,
			HashMap<String, String> hMap ) throws Exception
	{
		
		 hMap.put("firstname",fname);
		 hMap.put("lastname",lname);
		 hMap.put("license",licn);
		 hMap.put("ssn",ssn);
		 hMap.put("height",height);
		 hMap.put("state",state);
		 hMap.put("city",city);
		 hMap.put("address",address);
		 hMap.put("zipcode",zipcode);
		 hMap.put("age",age);
		 hMap.put("weight",weight);

		

		
		 boolean result = false;
		 
		 driver.findElement(By.id("Ebtn")).click();
		
		 String expectedheightfromeditprofile = hMap.get("height");
	     driver.findElement(By.id("height")).clear();
	     driver.findElement(By.id("height")).sendKeys(height);
	     String actualheightafteredit =  driver.findElement(By.id("height")).getAttribute("value");
	     
	     String expectedstatefromeditprofile = hMap.get("state");
	     driver.findElement(By.id("state")).clear();
	     driver.findElement(By.id("state")).sendKeys(state);
	     String actualstateafteredit =  driver.findElement(By.id("state")).getAttribute("value");
	     
	     String expectedcityfromeditprofile = hMap.get("city");
	     driver.findElement(By.id("city")).clear();
	     driver.findElement(By.id("city")).sendKeys(city);
	     String actualcityafteredit =  driver.findElement(By.id("city")).getAttribute("value");
	     
	     String expectedaddressfromeditprofile = hMap.get("address");
	     driver.findElement(By.id("addr")).clear();
	     driver.findElement(By.id("addr")).sendKeys(address);
	     String actualaddressafteredit =  driver.findElement(By.id("addr")).getAttribute("value");
	     
	     String expectedzipfromeditprofile = hMap.get("zipcode");
	     driver.findElement(By.id("zip")).clear();
	     driver.findElement(By.id("zip")).sendKeys(zipcode);
	     String actualzipafteredit =  driver.findElement(By.id("zip")).getAttribute("value");
	     
	     String expectedagefromeditprofile = hMap.get("age");
	     driver.findElement(By.id("age")).clear();
	     driver.findElement(By.id("age")).sendKeys(age);
	     String actualageafteredit =  driver.findElement(By.id("age")).getAttribute("value");
	     
	     String expectedweightfromeditprofile = hMap.get("weight");
	     driver.findElement(By.id("weight")).clear();
	     driver.findElement(By.id("weight")).sendKeys(weight);
	     String actualweightafteredit =  driver.findElement(By.id("weight")).getAttribute("value");
	     
	      String expectedfnamefromeditprofile = hMap.get("firstname");
	     driver.findElement(By.id("fname")).clear();
	     driver.findElement(By.id("fname")).sendKeys(fname);
	     String actualfnamefteredit =  driver.findElement(By.id("fname")).getAttribute("value");
	  
	     String expectedlnamefromeditprofile = hMap.get("lastname");
	     driver.findElement(By.id("lname")).clear();
	     driver.findElement(By.id("lname")).sendKeys(lname);
	     String actuallnamefteredit =  driver.findElement(By.id("lname")).getAttribute("value");
	   
	     String expectedlicnfromeditprofile = hMap.get("license");
	     driver.findElement(By.id("licn")).clear();
	     driver.findElement(By.id("licn")).sendKeys(licn);
	     String actuallicnfteredit =  driver.findElement(By.id("licn")).getAttribute("value");
	     
	     String expectedssnfromeditprofile = hMap.get("ssn");
	     driver.findElement(By.id("ssn")).clear();
	     driver.findElement(By.id("ssn")).sendKeys(ssn);
	     String actualssnfteredit =  driver.findElement(By.id("ssn")).getAttribute("value");
	     
	     driver.findElement(By.id("Sbtn")).click();
	         
	     Alert alrt = driver.switchTo().alert();
         String actual = alrt.getText();
         alrt.accept();
	         
	        if(actualheightafteredit.equals(expectedheightfromeditprofile))
			{
		        	result = true;
	
			}
	        
		  if(actualstateafteredit.equals(expectedstatefromeditprofile))
			{
		        	result = true;
	
			}
		  
		   
		  if(actualcityafteredit.equals(expectedcityfromeditprofile))
			{
		        	result = true;
	
			}
		  
		   
		  if(actualaddressafteredit.equals(expectedaddressfromeditprofile))
			{
		        	result = true;
	
			}
		  
		   
		  if(actualzipafteredit.equals(expectedzipfromeditprofile))
			{
		        	result = true;
	
			}
		  
		   
		  if(actualageafteredit.equals(expectedagefromeditprofile))
			{
		        	result = true;
	
			}
		  
		   
		  if(actualweightafteredit.equals(expectedweightfromeditprofile))
			{
		        	result = true;
	
			}
		  
		   
		 if(actualfnamefteredit.equals(expectedfnamefromeditprofile))
			{
		        	result = true;
	
			}
		  
		  if(actuallnamefteredit.equals(expectedlnamefromeditprofile))
			{
		        	result = true;
	
			}
		  
		  if(actuallicnfteredit.equals(expectedlicnfromeditprofile))
			{
		        	result = true;
	
			}
		  
		  if(actualssnfteredit.equals(expectedssnfromeditprofile))
			{
		        	result = true;
	
			}
		  
		 
		return result;
		
	}

}
	


