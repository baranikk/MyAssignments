package week2.day3;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeadXpath {

	public static void main(String[] args) {
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		// Click on CRM/SFA

		driver.findElement(By.xpath("//div[@class='crmsfa']")).click();

		// Click on Leads Button
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// Click on create Lead Button
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();

		// Enter CompanyName using id Locator
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TCS");

//Enter FirstName using id Locator
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Jenil");

//Enter LastName using id Locator
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Vivek");

//Enter your mail-id
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("jenil@gmail.com");

//phone number
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("9877665544");

//Click on create Lead Button Using name Locator
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

	}

}
