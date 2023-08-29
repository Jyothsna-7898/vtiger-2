package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateContactTest extends BaseClass {
	//Here we are creating contact
	@Test
	public void createContactTest() {
		SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));

		contacts.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");

		Map<String, String> map = excel.readFromExcel("Sheet2", "Create Contact");
		String lastName = map.get("Last Name") + jutil.generateRandomNum(58);
		createContact.setLastName(lastName);
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));

		if (newContactInfo.getPageHeader().contains(lastName)) 
			excel.writeToExcel("Sheet2", "Create Contact", "Pass", IConstantPath.Excel_Path);
		else 
			excel.writeToExcel("Sheet2", "Create Contact", "Fail", IConstantPath.Excel_Path);
		soft.assertAll();
	}
}
