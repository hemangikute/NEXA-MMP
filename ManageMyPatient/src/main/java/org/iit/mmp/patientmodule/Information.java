package org.iit.mmp.patientmodule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.iit.mmp.HelperMethods.HelperMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Information {
	
	WebDriver driver;
	
	public Information(WebDriver driver) 
	{
		this.driver = driver;

	}

	
	public boolean readInformation() throws IOException
	{
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Information");
		
		String actualdata = driver.findElement(By.xpath("//div[@class='panel-title']")).getText();
		String expecteddata = " Manage My Patient (MMP) is a medical practice management solution that "
				+ "boosts productivity by automating the day-to-day tasks that can slow an office manager down."
				+ " Central delivers much more than medical billing software. Sure, it has the tools to help generate "
				+ "cleaner claims and reduce denials, but our easy-to-use practice management software also streamlines"
				+ " your workflow to deliver seamless handoffs across departments.\r\n" + 
				"    Manage My Patient (MMP) becomes your practice’s command center, delivering robust, real-time"
				+ " analytics through customizable reports and dashboards to ensure you know how your business is "
				+ "performing on the metrics that matter most.";
		
		/* READ DATA INTO THE FILE  */
		/* Creating a File*/
		  
		File firstFile = new File("C:\\Users\\heman\\OneDrive\\Desktop\\Selenium Project\\MMP\\Modules\\PatientModule\\ActualInformationFile.txt");  
		File secondFile = new File("C:\\Users\\heman\\OneDrive\\Desktop\\Selenium Project\\MMP\\Modules\\PatientModule\\ExpectedInformationFile.txt");  

		
		if (firstFile.createNewFile())
	       {  
	           System.out.println("New File is created!");  
	       } 
	       else 
	       {  
	           System.out.println("File already exists.");  
	       }  

	       /* Writing to File*/
	       FileWriter writer = new FileWriter(firstFile);
	       writer.write(actualdata);
	       writer.close();

	       
	       if (secondFile.createNewFile())
	       {  
	           System.out.println("New File is created!");  
	       } 
	       else 
	       {  
	           System.out.println("File already exists.");  
	       }  

	       /* Writing to File*/
	       FileWriter writer1 = new FileWriter(secondFile);
	       writer1.write(expecteddata);
	       writer1.close();
	       
	      boolean equal = false;
	      equal = FileUtils.contentEquals(firstFile, secondFile);
	       
		
		return equal;
		
	}
	
	

}
