package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	public static void main(String[] args) {
		// 1.To Launch Web browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/logout");

		// 2.To Maximize the window
		driver.manage().window().maximize();

		// 3. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 4.Click on Login Button using Class Locator and Verify the title
		driver.findElement(By.className("decorativeSubmit")).click();

		String title = driver.getTitle();
		System.out.println(title);

		// 5. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// 6.Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();

		// 7.Click on create Lead Button
		driver.findElement(By.linkText("Create Lead")).click();

		// 8.Enter CompanyName using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CMC");

		// 9. Enter FirstName using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Barani");

		// 10. Enter LastName using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Vivek");

		// 11. Enter your mail-id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("barani.vivek@gmail.com");

		// 12.Enter Phone number
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876543210");

		// 13.Select Employee in source dropdown using index
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dpdwn = new Select(source);
		dpdwn.selectByIndex(4);

		// 14.Select Automobile in MarketCampaign using visibleText
		WebElement marketing = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select mdpdwn = new Select(marketing);
		mdpdwn.selectByVisibleText("Automobile");

		// 15.Select Corporation in Ownership using value
		WebElement own = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select odpdwn = new Select(own);
		odpdwn.selectByValue("OWN_CCORP");

		// 16. Click on create Lead Button Using name Locator
		driver.findElement(By.name("submitButton")).click();

	}

}
