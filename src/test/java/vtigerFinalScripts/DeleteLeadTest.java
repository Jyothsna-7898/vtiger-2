package vtigerFinalScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class DeleteLeadTest extends BaseClass
{
	@Test
	public void deleteLeadTest()
	{
		SoftAssert soft=new SoftAssert(); 
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.traverseToRequiredLead(web, "Lead4");
		lead.clickDelete();
		
		web.handleAlert("ok");
		List<WebElement> leadNameList=lead.getLeadNames();
		boolean status=false;
		for (WebElement leads: leadNameList) {
			if(!(leads.getText().equals("Lead2"))) {
				status=true;
			}
		}
			soft.assertTrue(status);
			if(status)
				excel.writeToExcel("Sheet3", "Delete Lead", "Pass", IConstantPath.Excel_Path);
			else 
				excel.writeToExcel("Sheet3", "Delete Lead", "Fail", IConstantPath.Excel_Path);
			soft.assertAll();
	}
}
