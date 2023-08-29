package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateContactWithOrgTest extends BaseClass {
	//Here we are creating contact along with Org. and Test
	@Test
	public void createContactWithOrgTest() {
		SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));

		contacts.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");

		Map<String, String> map = excel.readFromExcel("Sheet2", "Create Contact");
		String lastName = map.get("Last Name") +  jutil.generateRandomNum(58);
		createContact.setLastName(lastName);
		createContact.selectExistingorg(web, map.get("Organization Name"));
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));

		if (newContactInfo.getPageHeader().contains(lastName)) 
			excel.writeToExcel("Sheet2", "Create Contact With Organization", "Pass", IConstantPath.Excel_Path);
		else 
			excel.writeToExcel("Sheet2", "Create Contact With Organization", "Fail", IConstantPath.Excel_Path); 
		
		soft.assertAll();
	}
}

