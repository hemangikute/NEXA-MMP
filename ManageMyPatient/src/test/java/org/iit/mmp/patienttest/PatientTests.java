package org.iit.mmp.patienttest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.AdminPage;
import org.iit.mmp.patientmodule.EditPatientsProfilePage;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.RegistrationPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
            		

public class PatientTests {
	
	WebDriver driver;
	Random rnd = new Random();
	HashMap<String, String> hMap = new HashMap<String, String>();
//	RegistrationPage regpage = new RegistrationPage(driver);
//	HelperMethod submenu = new HelperMethod(driver);
//	AdminLogin admin = new AdminLogin(driver);
//	PatientLogin patientlogin = new PatientLogin(driver);
//
//	
	String usernameValue = "hemaManiKut" + rnd.nextInt(90);
	String passwordValue = "hemaManiKut" + rnd.nextInt(90);


			/*
			 * LAUNCH BROWSER
			 */
	@Test(enabled=true, priority = 1)
	public void LaunchBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	//	WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/registration.php");
	//	driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/login.php");

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
				/*
				 * REGISTER PATIENT
				 */
	@Test(enabled=true, priority = 5)
	public void registerPatient() throws Exception
	{
		
		RegistrationPage regpage = new RegistrationPage(driver);
	//	String usernameValue = "testUName" + rnd.nextInt(90);
		//String passwordValue = "testPword" + rnd.nextInt(90);
		hMap = regpage.registerPatient(usernameValue, passwordValue);
		
		String actualmsg = hMap.get("successmsg").trim();
		String expectedmsg = "Thank you for registering with MMP.";
		Assert.assertEquals(actualmsg, expectedmsg);
		
		System.out.println("username is "+usernameValue);
		System.out.println("password is "+passwordValue);
	}	
		
			/*  
			 *   ADMIN LOGIN
			 *   
			 */
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
		AssertJUnit.assertEquals(actual, expected);
	}
	
					/* 
					 * PATIENT LOGIN 
					*/
	
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
                  /* 
                   * VALIDATE PATIENT PROFILE
                   */
	
	@Test(enabled = true, priority = 20)
	
	public void ValidatePatientProfile() throws Exception
	{
		EditPatientsProfilePage validatePatientProfile = new EditPatientsProfilePage(driver);
		
		boolean result = validatePatientProfile.ValidatePatientProfile(hMap);
		
		System.out.println("actual weight which is returned from a function"+result);
		
	
		
	}
	
			/*
			 * EDIT PATIENT PROFILE
			 */
	
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
		
		boolean result = validatePatientProfile.editProfilePage(fname, lname, license, ssn, height, state, "LA", address, "90701", age, weight, hMap);
		
		System.out.println("actual height which is returned from a edit profile function"+result);
		
	
		
	}
	
	
	
}
	

