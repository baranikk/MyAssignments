package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edit {

	public static void main(String[] args) {
// 1. Launch URL "http://leaftaps.com/opentaps/control/login"

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/logout");

		driver.manage().window().maximize();
//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//3.Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//5.Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();

//6.Click on create Lead Button
		driver.findElement(By.linkText("Create Lead")).click();
//7.Enter CompanyName using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CMC");
//8. Enter FirstName using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Barani");
//9. Enter LastName using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Vivek");
//10.Click on create Lead Button Using name Locator
		driver.findElement(By.name("submitButton")).click();
//11.Click Edit
		driver.findElement(By.linkText("Edit")).click();
//12.Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
//13. Click Update
		driver.findElement(By.name("submitButton")).click();

	}

}
