package hardcodedtests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactWithExistingOrganization {

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
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String lastName="Priya"+randomNum;
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[@title=\"Select\"and contains(@onclick,\"return window.open\")]")).click();
		driver.findElement(By.xpath("//a[text()='Delloite88']")).click();
		
	}

}
