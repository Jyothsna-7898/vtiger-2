package hardcodedtests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if (driver.getTitle().contains("vtiger"))
			System.out.println("Application opened");
		else 
	     	System.out.println("Application not opened");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		if (driver.getTitle().contains("Home"))
			System.out.println("Home page opened");
		else 
			System.out.println("Home page not opened");
		
		driver.findElement(By.xpath("//a[text()='Contacts' and contains(@href,'module=Contacts&action=index')]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("contacts page opened");
		else
			System.out.println("contacts page not opened");
		
		
//		driver.findElement(By.xpath("//a[normalize-space(text())='Create a Contact']")).click();
//		
//		
//		String Title=driver.findElement(By.xpath("//span(text()='Creating New Contact')")).getText();
//		if(Title.contains("Creating New Contact"))
//			System.out.println("Creating New Contact page opened");
//		else
//			System.out.println("Creating New Contact page not opened");
//		
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String lastName="Priya"+randomNum;
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@value=\"U\"]")).click();
		
		Select s=new Select(driver.findElement(By.name("assigned_user_id")));
		s.selectByIndex(0);
		System.out.println(s.getFirstSelectedOption().getText());
	
		String header=driver.findElement(By.className("dvHeaderText")).getText();
		if(header.contains(lastName))
			System.out.println("contact created successfully");
		else
			System.out.println("contact not created");
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//td/img[@style=\"padding: 0px;padding-left:5px\"]"))).perform();
		
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
