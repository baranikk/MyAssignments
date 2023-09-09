package week3.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Button {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://leafground.com/button.xhtml");

		driver.findElement(By.xpath("//span[text()='Click']")).click();
		if (driver.getTitle().equals("Dashboard"))
			System.out.println("Redirected to Dashboard page");

		// Redirecting to Button Page
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Button']/ancestor::a")).click();

		// To check if button is disabled
		if (!driver.findElement(By.id("j_idt88:j_idt92")).isEnabled())
			System.out.println("Button is disabled");

		// To find the position of submit button
		WebElement submit1 = driver.findElement(By.id("j_idt88:j_idt94"));
		System.out.println("Location of Submit button:" + submit1.getLocation());

		// To find the color of the Save button
		WebElement save = driver.findElement(By.id("j_idt88:j_idt96"));
		System.out.println("Color of save button: " + save.getCssValue("background-color"));

		// To find the size of the submit button
		WebElement submit2 = driver.findElement(By.id("j_idt88:j_idt98"));
		System.out.println("Size of submit button:" + submit2.getSize());

		WebElement element = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']/span"));
		String colorBeforeHover = element.getCssValue("background-color");
		System.out.println("Colour Before Hover:" + colorBeforeHover);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		String colorAfterHover = element.getCssValue("background-color");
		System.out.println("Colour Before Hover:" + colorAfterHover);
		if (!colorBeforeHover.equals(colorAfterHover))
			System.out.println("Button colour changed after Hover");

		// clicking the image button and check the loaded image
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		if (driver.findElement(By.id("j_idt88:j_idt102:j_idt104")).isDisplayed())
			System.out.println("Image is displayed");

		// Find the number of rounded buttons
		List<WebElement> Elements = driver
				.findElements(By.xpath("//h5[contains(text(),'rounded buttons')]/following-sibling::button"));
		System.out.println("No. of rounded buttons:" + Elements.size());
		driver.close();

	}

}
