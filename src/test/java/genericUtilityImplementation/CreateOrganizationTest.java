package genericUtilityImplementation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericlibraries.ExcelUtility;
import genericlibraries.IConstantPath;
import genericlibraries.JavaUtility;
import genericlibraries.PropertiesUtility;
import genericlibraries.WebDriverUtility;

public class CreateOrganizationTest
{
   public static void main(String[] args)
   {
	   PropertiesUtility property=new PropertiesUtility();
	   ExcelUtility excel=new ExcelUtility();
	   JavaUtility java =new JavaUtility();
	   WebDriverUtility webUtil=new WebDriverUtility();
	   
	   property.propertiesInitialization(IConstantPath.Properties_Path);
	   excel.excelInitialization(IConstantPath.Excel_Path);
	   
//	            WebDriver driver=new ChromeDriver();
//				driver.manage().window().maximize();
//				driver.get("http://localhost:8888/");
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebDriver driver=webUtil.launchBrowser(property.readFromProperties("browser"));
		webUtil.maximizeBrowser();
		webUtil.navigateToApp(property.readFromProperties("url"));
		webUtil.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		
		       if (driver.getTitle().contains("vtiger"))
				
					System.out.println("Application opened");
			
				else 
				{
					System.out.println("Application not opened");
				}
				
				driver.findElement(By.name("user_name")).sendKeys(property.readFromProperties("username"));
				driver.findElement(By.name("user_password")).sendKeys(property.readFromProperties("password"));
				driver.findElement(By.id("submitButton")).click();
				
				if (driver.getTitle().contains("Home"))
				{
					System.out.println("Home page opened");
				}
				else 
				{
					System.out.println("Home page not opened");
				}
				
				driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
				
				if (driver.getTitle().contains("Organizations"))
				{
					System.out.println("Organizations page opened");
				}
				else 
				{
					System.out.println("Organizations page not opened");
				}
				
				driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
				
				WebElement createOrgPage=driver.findElement(By.xpath("//span[text()='Creating New Organization']"));
				
				if(createOrgPage.isDisplayed())
				{
					System.out.println("create Organization page is displayed");
				}
				else 
				{
					System.out.println("create Organization page is not displayed");
				}
//				Random random=new Random();
//				int randomNumber=random.nextInt(125);
				
				Map<String,String> map= excel.readFromExcel("OrganizationTestData", "Create Organization");
				String orgName=map.get("Organization Name")+java.generateRandomNum(100);
				
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
				
				String orgInfo=driver.findElement(By.className("dvHeaderText")).getText();
				if(orgInfo.contains(orgName))
				{
					//System.out.println("Created Organization Successfully");
					excel.writeToExcel("OrganizationTestData", "Create Organization", "Pass", IConstantPath.Excel_Path);
				}
				else
				{
					//System.out.println("Organization not created");
					excel.writeToExcel("OrganizationTestData", "Create Organization", "Fail", IConstantPath.Excel_Path);
				}
				
				WebElement adminIcon=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//				Actions a =new Actions(driver) ;
//				a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
				webUtil.mouseHover(adminIcon);
				
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
					
//				if (driver.getTitle().contains("vtiger"))
//				{
//					System.out.println("Application opened");
//				}
//				else 
//				{
//					System.out.println("Application not opened");
//				}
				//driver.quit();
				
				webUtil.quitAllWindows();
				excel.excelClose();
			}

		

}


