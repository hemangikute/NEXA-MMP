package org.iit.mmp.adminmodule;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.iit.mmp.patientmodule.EditPatientsProfilePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePatientData
{

WebDriver driver;
HashMap<String, String> hMap = new HashMap<String, String>();

	
	public CreatePatientData(WebDriver driver) throws Exception 
	{
		this.driver = driver;
		
		
	}
	
	public String createPatientFees() throws Exception
	{
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Patients");
		
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("749420625");
	//	WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement search = driver.findElement(By.xpath("//input[@value='search']"));
		//search = wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'hemaFNO')]")).click();
		
		driver.findElement(By.xpath("//p[3]//a[1]//input[1]")).click();
        Select vaccination = new Select(driver.findElement(By.id("service")));		
        vaccination.selectByVisibleText("vaccination");
        
        driver.findElement(By.xpath("//input[@value='submit']")).click();
        Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();

		String actual = alrt.getText();
		alrt.accept();
        Thread.sleep(3000);
        
        return actual;

        //		System.out.println("click search button");
//		Thread.sleep(3000);
//		List<WebElement> FNList = driver.findElements(By.xpath("//div[@id='show']//tbody/tr/td[1]"));
//        
//		FNList = wait.until(ExpectedConditions.visibilityOfAllElements(FNList));
//	
//		for(int i=0;i<FNList.size();i++)
//		{
//		   WebElement e = FNList.get(i);
//			if(e.getText().equalsIgnoreCase(fname))
//		   {
//			   if(e.isEnabled())
//			   {
//				e.click();
//			   System.out.println("printing e after if" +e.getText());
//			   break;
//			   }
//		   }
//		
//		}
//		
//			
		}
	
	public void createPatientReport() throws AWTException, Exception
	{
		driver.findElement(By.xpath("//p[4]//a[1]//input[1]")).click();
		driver.findElement(By.id("exampleInputcardnumber1")).sendKeys("ECG");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='file']"))));

		driver.findElement(By.xpath("//input[@id='file']")).click();;
		

		
				
	}
	
	private static void setClipboardData(String string) {
	    // StringSelection is a class that can be used for copy and paste
	    // operations.
	    StringSelection stringSelection = new StringSelection(string);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/*
	 *  Function to upload the file using robot class
	 */
	public void upload(String fileLocation) throws Exception {

	    // Setting clipboard with file location
	    setClipboardData("c:\\selenium.doc");

	    // native key strokes for CTRL, V and ENTER keys
	    Robot robot = new Robot();

	    Thread.sleep(2000);
	    robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public String createPatientPrescription() throws Exception
	{
	
		driver.findElement(By.xpath("//input[@value='Add Precription']")).click();
		
		driver.findElement(By.id("exampleInputcardnumber1")).sendKeys("prescriptio ");
		
		driver.findElement(By.name("p_desc")).sendKeys("take this table once in a day");
		
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		
			Thread.sleep(2000);
			
			Alert alrt = driver.switchTo().alert();

			String actual = alrt.getText();
			alrt.accept();
	        Thread.sleep(3000);
	        
	        return actual;
		
	}
	
}
	

