package week3.marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class PVRCinemas {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--disable-notifications"); 
		ChromeDriver driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://www.pvrcinemas.com/  ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Movie Library
		driver.findElement(By.xpath("//div[@class='nav-icon']")).click();
		driver.findElement(By.xpath("//a[text()='Movie Library']")).click();
		Thread.sleep(3000);
				
		//Choose city,genre and language
		Select city=new Select(driver.findElement(By.name("city")));
		city.selectByVisibleText("Chennai");
		
		Select genre=new Select(driver.findElement(By.name("genre")));
		genre.selectByVisibleText("ANIMATION");
		
		Select language=new Select(driver.findElement(By.name("lang")));
		language.selectByVisibleText("ENGLISH");
		
		driver.findElement(By.xpath("//button[@class='btn btn-submit btn-primary']")).click();
		Thread.sleep(7000);
		
		//Click on first resulting animation movie 
		driver.findElement(By.xpath("//div[@class='movie-wrapper ng-star-inserted']/img")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();		
		Thread.sleep(3000);
		
	//Enter all the fields
		driver.findElement(By.xpath("//select[@name='cinemaName']")).click();
		Select cinema=new Select(driver.findElement(By.xpath("//select[@name='cinemaName']")));
		cinema.selectByIndex(2);
		
		driver.findElement(By.xpath("//div[@class='datepicker-container datepicker-default']")).click();
		driver.findElement(By.xpath("//span[@class='day-unit ng-star-inserted']")).click();
		
		driver.findElement(By.xpath("//select[@name='timings']")).click();
		Select timings=new Select(driver.findElement(By.xpath("//select[@name='timings']")));
		timings.selectByIndex(1);
		
		driver.findElement(By.name("noOfTickets")).sendKeys("3");
		driver.findElement(By.name("name")).sendKeys("Barani");
		driver.findElement(By.name("email")).sendKeys("baranikk@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("9876598765");
		
		driver.findElement(By.xpath("//select[@name='food']")).click();
		Select food=new Select(driver.findElement(By.xpath("//select[@name='food']")));
		food.selectByVisibleText("No");
		//Click on copy to self
		driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("Not required");
		
		driver.findElement(By.xpath("//div[@class='form-group col-sm-6']")).click();
		
	//Click on send request
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		
	
//click on close dialog
		driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
			Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(text(),'CANCEL')])[2]")).click();
		
		System.out.println("Page Title:"+driver.getTitle());
		
	
	}

}