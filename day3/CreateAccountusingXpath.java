package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountusingXpath {
	public static void main(String[] args) {
		// Launch URL "http://leaftaps.com/opentaps/control/login"

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link

		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		// Click on Accounts Button

		driver.findElement(By.linkText("Accounts")).click();

		// Click on Accounts Button

		driver.findElement(By.linkText("Create Account")).click();

		// Enter AccountName Field Using Xpath Locator value as Debit Limited Account
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debt Limit Account");

		// Enter DEscriptiion as "Selenium Automation Tester"
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		// Enter LocalName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Salary Account");

		// Enter SiteName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Testleaf Marketing");

		// Enter value for AnnualRevenue Field using Xpath Locator but class as
		// Attribute
		driver.findElement(By.xpath("//input[@class='inputBox' and @name='annualRevenue']")).sendKeys("20000");

		// Select Industry as ComputerSoftware
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select indusdrpDwn = new Select(industry);
		indusdrpDwn.selectByValue("IND_SOFTWARE");

		// Select OwnerShip as S-Corporation using SelectByVisibletext
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select owndrpdwn = new Select(ownership);
		owndrpdwn.selectByVisibleText("S-Corporation");

		// Select Source as Employee using SelectByValue
		WebElement source = driver.findElement(By.id("dataSourceId"));
		Select srcdrpdwn = new Select(source);
		srcdrpdwn.selectByValue("LEAD_EMPLOYEE");

		// Select Marketing Campaign as eCommerce Site Internal Campaign using
		// SelectbyIndex
		WebElement marketingcamp = driver.findElement(By.id("marketingCampaignId"));
		Select marketdrpdwn = new Select(marketingcamp);
		marketdrpdwn.selectByIndex(5);

		// Select State/Province as Texas using SelectByValue
		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stpdrpdwn = new Select(state);
		stpdrpdwn.selectByValue("TX");

		// Click on Create Account using Xpath Locator
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

	}
}
