package week3.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InputComponents {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://leafground.com/input.xhtml");

		// Type your name
		driver.findElement(By.xpath("//input[contains(@id,'name')]")).sendKeys("Jenil");

		// Append country to city
		driver.findElement(By.xpath("//input[contains(@class,'city')]")).sendKeys(" India");

		// Verify if textbox is disabled
		if (!driver.findElement(By.id("j_idt88:j_idt93")).isEnabled())
			System.out.println("The textbox is disabled");
		else
			System.out.println("The textbox is enabled");

		// Clear the typed text
		driver.findElement(By.xpath("//h5[contains(text(),'Clear')]/following::input[1]")).clear();

		// Retrieve the typed text
		System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'Retrieve')]/following::input[1]"))
				.getAttribute("Value"));

		// Type email and tab ,check if control is moved to the next element
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("Jenil@gmail.com", Keys.TAB);
		WebElement textarea = driver.findElement(By.id("j_idt88:j_idt101"));
		Assert.assertTrue(textarea.equals(driver.switchTo().activeElement()));
		System.out.println("Control is in Textarea");

		// Type in text area
		textarea.sendKeys("I am currently doing test automation course with TestLeaf");

		// Just Press Enter and confirm error message
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		String errormessage = driver.findElement(By.xpath("//span[@class='ui-message-error-detail']")).getText();
		if (errormessage.equals("Age is mandatory"))
			System.out.println("Error message is displayed properly");

		// Click and confirm label position changes
		WebElement label = driver.findElement(By.xpath("//label[text()='Username']"));
		System.out.println("Location before click: " + label.getLocation());
		driver.findElement(By.id("j_idt106:float-input")).click();
		System.out.println("Location After click: " + label.getLocation());

		// Type your name and choose the third option
		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("Jenil");
		Thread.sleep(100);
		driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']//li[3]")).click();

		// Type your dob and confirm date chosen

		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("07/26/1989");
		WebElement datepicker = driver
				.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group ui-widget-content')]"));
		if (!datepicker.isDisplayed())
			driver.findElement(By.xpath("//button[contains(@class,'ui-datepicker-trigger')]")).click();
		Thread.sleep(100);

		String selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		System.out.println("Selectedyear:" + selectedYear);
		String selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		System.out.println("Selectedmonth:" + selectedMonth);
		String selectedDate = driver.findElement(By.xpath("//a[@class=' ui-state-default ui-state-active']")).getText();
		System.out.println("Selectedate:" + selectedDate);
		String dob = "23 August 1985";
		String selectedDOB = selectedDate + " " + selectedMonth + " " + selectedYear;
		if (selectedDOB.equalsIgnoreCase(dob))
			System.out.println("Date is selected properly");

		// checking spin
		WebElement spinText = driver.findElement(By.id("j_idt106:j_idt118_input"));
		spinText.sendKeys("25");

		// Spinup and check if the value is increased by 1
		WebElement spinUp = driver.findElement(By.xpath("//a[contains(@class,'ui-spinner-up')]"));
		spinUp.click();
		if (spinText.getAttribute("value").equals("26"))
			System.out.println("Spinup button is working fine");

		// Spindown and check if the value is decreased by 1
		WebElement spinDown = driver.findElement(By.xpath("//a[contains(@class,'ui-spinner-down')]"));
		spinDown.click();
		if (spinText.getAttribute("value").equals("25"))
			System.out.println("SpinDown button is working fine");

		// checking slider
		driver.findElement(By.id("j_idt106:slider")).sendKeys("50");
		Thread.sleep(500);
		WebElement slider = driver.findElement(By.xpath("//div[contains(@class,'ui-slider-range')]"));
		String sliderPercentage = slider.getAttribute("style");
		if (sliderPercentage.contains("50"))
			System.out.println("Slider is showing 50%");

		// click and confirm if keypad appears
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		WebElement keyPad = driver.findElement(By.xpath("//div[@class='keypad-row']"));
		if (keyPad.isDisplayed())
			System.out.println("Keypad is displayed on click");

		driver.close();
	}

}