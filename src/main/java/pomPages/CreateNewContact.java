package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class CreateNewContact {

	//Declaration
	@FindBy(xpath="//span[text()='Creating New Contact']")
	private WebElement pageHeader;
	@FindBy(name="lastname")
	private WebElement lastNameTF;
	@FindBy(xpath="//img[contains(@onclick,'Accounts&action')]")
	private WebElement orgPlusButton;
	@FindBy(xpath="//div[@id='ListViewContents']/descendant::table[@cellspacing='1']/descendant::a[contains(@onclick,'popuptype=specific_contact_account_address&order_by=accountname&sorder=ASC')]")
	private List<WebElement> orgList;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	
	//Initialization
	
	public CreateNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setLastName(String lastName) {
		lastNameTF.sendKeys(lastName);
	}
	public void selectExistingorg(WebDriverUtility web,String requiredOrgName)
	{
		String parentID=web.getParentWindowID();
		for(int i=1;i< orgList.size();i++)
		{
			if(orgList.get(i).getText().equals(requiredOrgName))
			{
				System.out.println(orgList.get(i).getText());
				orgList.get(i).click();
				break;
			}
		}
		web.switchToWindow(parentID);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
} 
	

