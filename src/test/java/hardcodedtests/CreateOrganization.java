package hardcodedtests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganization {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String orgInfo=driver.findElement(By.className("dvHeaderText")).getText();
		if(orgInfo.contains(orgName))
		{
			System.out.println("Created Organization Successfully");
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
			System.out.println("Application opened");
		}
		else 
		{
			System.out.println("Application not opened");
		}
		driver.quit();
	}

}
