package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateOrganizationTest extends BaseClass
{
  @Test
  public void createOrgTest()
  {
	SoftAssert soft=new SoftAssert();
	home.clickOrganizations();
	soft.assertTrue(driver.getTitle().contains("Organizations"));
	org.clickPlusButton();
	soft.assertTrue(createOrg.getpageHeader().equals("Creating New Organization"));
	Map<String, String> map= excel.readFromExcel("Sheet1", "Create Organization");
	String orgName=map.get("Organization name")+jutil.generateRandomNum(100);
	createOrg.setOrgName(orgName);
	createOrg.clickSaveButton();
	
	soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
	if(newOrgInfo.getPageHeader().contains(orgName))
	{
	  excel.writeToExcel("sheet1", "Create Organization", "pass", IConstantPath.Excel_Path);
	}
	else
	{	
	  excel.writeToExcel("sheet1", "Create Organization", "pass", IConstantPath.Excel_Path);
	}
	soft.assertAll();
  }	
}