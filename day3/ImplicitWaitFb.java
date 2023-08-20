package week2.day3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ImplicitWaitFb {

	public static void main(String[] args) {
		// Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// MaximiZe the window
		driver.manage().window().maximize();

		// add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Create New Account button
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		// Enter first name,last name,mobile number,password
		driver.findElement(By.name("firstname")).sendKeys("Barani");
		driver.findElement(By.name("lastname")).sendKeys("Devi");
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		driver.findElement(By.name("reg_passwd__")).sendKeys("fb@123");

		// Handle all the 3 drop downs date,month,year

		WebElement date = driver.findElement(By.name("birthday_day"));
		Select dpdwn = new Select(date);
		dpdwn.selectByIndex(4);

		// Select month
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select mdpdwn = new Select(month);
		mdpdwn.selectByVisibleText("Jul");

		// Select year
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select ydpdwn = new Select(year);
		ydpdwn.selectByValue("1990");

		// Select the radio button "Female"
		driver.findElement(By.className("_58mt")).click();

	}

}
