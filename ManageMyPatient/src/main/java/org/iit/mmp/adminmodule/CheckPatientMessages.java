package org.iit.mmp.adminmodule;

import java.util.HashMap;
import java.util.List;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPatientMessages
{
	
	
	WebDriver driver;
	HashMap<String, String> hashMap = new HashMap<String, String>();

		
		public CheckPatientMessages(WebDriver driver) throws Exception 
		{
			this.driver = driver;
			
			
		}
		
		
	public void checkpatientmessage(HashMap<String, String>  hashMap)
	{
	
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Messages");
		
		WebElement mytable = driver.findElement(By.xpath("//table[@class='table']/tbody"));
		
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		
		String expectedsubject = hashMap.get("subject");
		String expectedmessage = hashMap.get("messagedesc");
	
		
		for(int row=0;row<rows_table.size();row++)
			{
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));				  
						
			for (int column=0; column<Columns_row.size(); column++)
			   {
					
			//	System.out.println("printing columns data"+Columns_row.get(column).getText());
				WebElement e =   Columns_row.get(column);
						if(e.getText().equals(expectedsubject))
						{
							String subject = e.getText();
							System.out.println("printing subject"+subject);
						}	
						
						if(e.getText().equals(expectedmessage))
						{
							String subjectmessage = e.getText();
							System.out.println("printing subject message"+subjectmessage);
							break;
						}
						
						
				}
			}
	}
	
				
}
