package org.iit.mmp.patienttest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.iit.mmp.HelperMethods.LaunchBrowser;
import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.AdminPage;
import org.iit.mmp.patientmodule.EditPatientsProfilePage;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.RegistrationPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

             /*
              * 1. REGISTER THE PATIENT
              * 2. LOGIN TO ADMIN PORTAL
              * 3. APPROVE THE PATIENT BASED ON USERNAME
              * 4. LOGIN TO PATIENT PORTAL
              * 5. 	LOGIN USING USERNAME AND PASSWORD
              */
            		

public class PatientTests 
{
	
	WebDriver driver;
	Random rnd = new Random();
	HashMap<String, String> hMap = new HashMap<String, String>();
	
	String usernameValue = "hemaManiKut" + rnd.nextInt(90);
	String passwordValue = "hemaManiKut" + rnd.nextInt(90);

  		
	@BeforeClass()
	public void LaunchBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/registration.php");

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	
				/*  REGISTER A PATIENT  */
	
	@Test(enabled=true, priority = 1)
	public void registerPatient() throws Exception
	{
		
		
		RegistrationPage regpage = new RegistrationPage(driver);
		hMap = regpage.registerPatient(usernameValue, passwordValue);
		
		String actualmsg = hMap.get("successmsg").trim();
		String expectedmsg = "Thank you for registering with MMP.";
		Assert.assertEquals(actualmsg, expectedmsg);
		
	}	
		
			/* APPROVE PATIENT */
	@Test(enabled=true, priority = 10)
	public void approvePatient() throws Exception
	{
		
	
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/admin/login.php");
		AdminLogin admin = new AdminLogin(driver);
		admin.logintoAdmin("Thomas_444", "Edison_444");
		
		
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Users");
		
		
	    AdminPage adminpage = new AdminPage(driver);
		String actual = adminpage.approvePatient(hMap).trim();
		String expected = "USER has been updated.";
		Assert.assertEquals(actual, expected);
	}
	
					
					 /* VALIDATING PATIENT  */
				
	
	@Test(enabled = true, priority = 15)
	public void patientLogin() throws Exception
	{
		
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/login.php");
		PatientLogin patientlogin = new PatientLogin(driver);
		
		patientlogin.patientLogin(usernameValue, passwordValue);

		String actualvalue = patientlogin.fetchUname().trim();
		String expectedvalue = usernameValue;
		
		Assert.assertEquals(actualvalue, expectedvalue);
		
		

		
	}
                   
                   /* VALIDATE PATIENT PROFILE    */
                   
	
	@Test(enabled = true, priority = 20)
	
	public void ValidatePatientProfile() throws Exception
	{
		EditPatientsProfilePage validatePatientProfile = new EditPatientsProfilePage(driver);
		
		boolean result = validatePatientProfile.ValidatePatientProfile(hMap);
		
		Assert.assertTrue(result, "Patient validated");
	
		
	}
	
			
			/*  EDIT PATIENT PROFILE   */
			
	
	@Test(enabled = true, priority = 25)
	
	public void editPatientProfile() throws Exception
	{
		String fname = 		hMap.get("firstname");
		String lname =	 	hMap.get("lastname");
		String license =	hMap.get("license");
		String ssn = 		hMap.get("ssn");
		String height = 	hMap.get("height");
		String state =  	hMap.get("state");
		String city =   	hMap.get("city");
		String address =    hMap.get("address");
		String zipcode = 	hMap.get("zipcode");
		String age = 		hMap.get("age");
	    String weight = 	hMap.get("weight");
		
		
				
		
		EditPatientsProfilePage validatePatientProfile = new EditPatientsProfilePage(driver);
		
		boolean result = validatePatientProfile.editProfilePage(fname, lname, license, ssn, height, "DC", "NJ", address, "17512", age, weight, hMap);
		
		Assert.assertTrue(result, "Patient's data edited successfully");

		
	
		
	}
	
	
	
}
	

