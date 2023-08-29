package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateLeadTest extends BaseClass {
	
	@Test
	public void createLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating new Lead");
		
		Map<String,String> map= excel.readFromExcel("Sheet3", "Create Lead");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		excel.writeToExcel("Sheet3", 11, 3, lastName, IConstantPath.Excel_Path);
		createLead.setLastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveButton();
		soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		if(newLeadInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("Sheet2", "Create Lead", "Pass", IConstantPath.Excel_Path);
		else 
			excel.writeToExcel("Sheet2", "Create Lead", "Fail", IConstantPath.Excel_Path); 
		
		soft.assertAll();
	}
	}
