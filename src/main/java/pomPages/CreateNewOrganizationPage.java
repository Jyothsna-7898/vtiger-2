package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class CreateNewOrganizationPage {

	//Declaration
	@FindBy(xpath="//span[text()='Creating New Organization']")
	private WebElement pageHeader;
	@FindBy(name="accountname")
	private WebElement orgNameTF;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(name="accounttype")
	private WebElement accType;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getpageHeader() 
	{ 
		return pageHeader.getText();
	}
	public void setOrgName(String orgName)
	{
		orgNameTF.sendKeys(orgName);
	}
	public void selectIndustry(WebDriverUtility web, String value)
	{
		web.selectFromDropdown(industryDropDown, value);
	}
	public void selectType(WebDriverUtility web, String value) 
	{
		web.selectFromDropdown(accType,value );
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
}
