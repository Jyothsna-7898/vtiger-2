package hardcodedtests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrganizationTypeIndustry {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if (driver.getTitle().contains("vtiger"))
		{
			System.out.println("Application opened");
		}
		else 
		{
			System.out.println("Application not opened");
		}
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
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
		Random random=new Random();
		int randomNumber=random.nextInt(125);
		
		String orgName="Delloite"+randomNumber;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		Select s=new Select(driver.findElement(By.name("industry")));
		s.selectByIndex(3);
		Thread.sleep(2000);
		if(s.isMultiple())
			System.out.println("Industry is Multiple select");
		else
			System.out.println("Industry is single select");
		System.out.println(s.getFirstSelectedOption().getText());
		
		Select s1=new Select(driver.findElement(By.name("accounttype")));
		s1.selectByIndex(2);
		Thread.sleep(2000);
		if(s1.isMultiple())
			System.out.println("Account Type is Multiple select");
		else
			System.out.println("Account Type is single select");
		System.out.println(s1.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//input[normalize-space(@value)=\"Save\"]")).click();
		String header=driver.findElement(By.className("dvHeaderText")).getText();
		
		if(header.contains(orgName))
		{
			System.out.println("Organization created successful with mandatory fields and Industry and Type");
		}
		else
		{
			System.out.println("Organization not created");
		}
		
		Actions a =new Actions(driver) ;
		a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
		if (driver.getTitle().contains("vtiger"))
		{
			System.out.println("Signout successful");
		}
		else 
		{
			System.out.println("signout not successful");
		}
		driver.quit();
		

	}

}
