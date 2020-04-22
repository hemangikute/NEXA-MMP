package org.iit.mmp.patienttest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.iit.mmp.patientmodule.EditPatientsProfilePage;
import org.iit.mmp.patientmodule.Information;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.RegistrationPage;
import org.iit.mmp.patientmodule.ScheduleAnAppointment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.iit.mmp.adminmodule.*;
import org.iit.mmp.patientmodule.*;

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
	HashMap<String, String> hashMap = new HashMap<String, String>();

	
//	String usernameValue = "HemaKute" + rnd.nextInt(90);
//	String passwordValue = "HemaKute" + rnd.nextInt(90);
	


  		
	@BeforeClass()
	public void LaunchBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	
				/*  REGISTER A PATIENT  */
	
	@Test(enabled=false, priority = 1)
	public void registerPatient() throws Exception
	{
		
		
		RegistrationPage regpage = new RegistrationPage(driver);
	//    hMap = regpage.registerPatient(usernameValue, passwordValue);
		
		String actualmsg = hMap.get("successmsg").trim();
		String expectedmsg = "Thank you for registering with MMP.";
		Assert.assertEquals(actualmsg, expectedmsg);
		
	}	
		
			/* APPROVE PATIENT */
	@Test(enabled=false, priority = 10)
	public void approvePatient() throws Exception
	{
		
	
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admin = new AdminLogin(driver);
		admin.logintoAdmin("Thomas_444", "Edison_444");
		
		
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Users");
		
		
	    AdminPage adminpage = new AdminPage(driver);
		String actual = adminpage.approvePatient(hMap).trim();
		String expected = "USER has been updated.";
		Assert.assertEquals(actual, expected);
		System.out.println("assert succeed");

//		System.out.println("username"+usernameValue);
//			System.out.println("password"+passwordValue);
	}
	
					
					 /* VALIDATING PATIENT  */
				
	
	@Test(enabled = true, priority = 15)
	public void patientLogin() throws Exception
	{
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientLogin patientlogin = new PatientLogin(driver);
		
	//    patientlogin.patientLogin(usernameValue, passwordValue);
	   
	    patientlogin.patientLogin("HemaMKute79", "HemaMKute33");


//	System.out.println("username"+usernameValue);
//		System.out.println("password"+passwordValue);
//		
//		String actualvalue = patientlogin.fetchUname().trim();
//		String expectedvalue = usernameValue;

	//	Assert.assertEquals(actualvalue, expectedvalue, "this is user");
		
		

		
	}
                   
                   /* VALIDATE PATIENT PROFILE    */
                   
	
	@Test(enabled = false, priority = 20)
	
	public void ValidatePatientProfile() throws Exception
	{
		
		
		EditPatientsProfilePage validatePatientProfile = new EditPatientsProfilePage(driver);
		
		boolean result = validatePatientProfile.ValidatePatientProfile(hMap);
		
		Assert.assertTrue(result, "Patient validated");
	
		
	}
	
			
			/*  EDIT PATIENT PROFILE   */
			
	
	@Test(enabled = false, priority = 25)
	
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
		
		boolean result = validatePatientProfile.editProfilePage(fname, lname, license, ssn, height, "nebraska", "colorado", address, "52002", age, weight, hMap);
		
		Assert.assertTrue(result, "Patient's data edited successfully");
		
		
		EditPatientsProfilePage validatePatientProfileagain = new EditPatientsProfilePage(driver);
		
		boolean newresult = validatePatientProfileagain.ValidatePatientProfile(hMap);
		
		Assert.assertTrue(newresult, "Patient validated after editing ");

	}
	
	@Test(enabled=false, priority = 30)
	public void scheduleAnAppointment()
	{
		ScheduleAnAppointment appointment = new ScheduleAnAppointment(driver);
		appointment.scheduleAnAppointment("Dr.Charlie");
	}
	
	@Test(enabled = false, priority = 35)
	public void viewInformation() throws IOException
	{
		Information info = new Information(driver);
		boolean actualdata = info.readInformation();
		System.out.println("printing file"+actualdata);
		Assert.assertTrue(actualdata);
	}
	
	
	@Test (enabled = false, priority = 35)
	public void CreatePatientFees() throws Exception
	{

		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admin = new AdminLogin(driver);
		admin.logintoAdmin("Thomas_444", "Edison_444");
		
		CreatePatientData patientdata = new CreatePatientData(driver);
		String FeesResultMessage = patientdata.createPatientFees();
		
	//	patientdata.createPatientReport();
		
		String PrescriptionResultMessage = patientdata.createPatientPrescription();
			
	}
	

	@Test (enabled = true, priority = 40)
	public void SendMessageToDoctor() throws Exception
	{
						
		SendMessageToDoctor message = new SendMessageToDoctor(driver);
		hashMap = message.sendMessageToDoctor("blood report", "informing doctor that i got blood report");
	}
	

	@Test (enabled = true, priority = 45)
	public void CheckPatientMessages() throws Exception
	{
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admin = new AdminLogin(driver);
		admin.logintoAdmin("Thomas_444", "Edison_444");
		
		CheckPatientMessages message = new CheckPatientMessages(driver);
		message.checkpatientmessage(hashMap);
		
	}
	
}
	

