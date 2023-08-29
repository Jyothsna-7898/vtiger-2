package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactsPage;
import pomPages.CreateContactInfoPage;
import pomPages.CreateNewContact;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.CreateOrgInfoPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.Leadspage;
import pomPages.LoginPage;
import pomPages.NewEventInfoPage;
import pomPages.NewLeadInfoPage;
import pomPages.OrganizationsPage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contacts;
	protected Leadspage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContact createContact;
	protected CreateNewLeadPage createLead;
	protected CreateNewEventPage createEvent;
	protected CreateOrgInfoPage newOrgInfo;
	protected CreateContactInfoPage newContactInfo;
	protected NewLeadInfoPage newLeadInfo;
	protected NewEventInfoPage newEventInfo;
	protected DuplicatingLeadPage duplicatingLead;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	@BeforeClass
	public void classSetup()
	{
		property= new PropertiesUtility();
		excel= new ExcelUtility();
	    jutil=new JavaUtility();
	    web=new WebDriverUtility();
	    
	    property.propertiesInitialization(IConstantPath.Properties_Path);
	    driver=web.launchBrowser(property.readFromProperties("browser"));
	    web.maximizeBrowser();
	    web.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
	    
	    sdriver=driver;
	    sjutil=jutil;
	 }
	
	@BeforeMethod
	public void MethodSetup()
	{
		excel.excelInitialization(IConstantPath.Excel_Path);
		
		login= new LoginPage(driver);
		home= new HomePage(driver);
		org=new OrganizationsPage(driver);
		contacts=new ContactsPage(driver);
		lead= new Leadspage(driver);
		createOrg= new CreateNewOrganizationPage(driver);
		createContact=new CreateNewContact(driver);
		 createLead=new CreateNewLeadPage(driver);
		 createEvent=new CreateNewEventPage(driver);
		 newOrgInfo=new CreateOrgInfoPage(driver);
		 newContactInfo=new CreateContactInfoPage(driver);
		 newLeadInfo=new NewLeadInfoPage(driver);
		 newEventInfo=new NewEventInfoPage(driver);
		 duplicatingLead=new DuplicatingLeadPage(driver);
		 
		 web.navigateToApp(property.readFromProperties("url"));
		 Assert.assertTrue(driver.getTitle().contains("vtiger"));
		 login.loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));
		 Assert.assertTrue(driver.getTitle().contains("Home"));
		 
     }
	
	@AfterMethod
	public void methodTearDown()
	{
		home.signOutOfVtiger(web);
		excel.excelClose();
	}
	
	@AfterClass
	public void classTearDown()
	{
		web.quitAllWindows();
	}
	

}
