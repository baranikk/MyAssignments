package week3.marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Abhibus {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Bus"));

		// From-->Chennai
		driver.findElement(By.id("source")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();

		// To-->Bangalore
		driver.findElement(By.id("destination")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();

		// Select Tomorrow's date
		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='26']")).click();

		// click on Search
		driver.findElement(By.linkText("Search")).click();

		// Printing the busname for the first result
		System.out.println("First available Busname: "
				+ driver.findElement(By.xpath("//div[@class='search-column1']/h2")).getText());

		// Click on Sleeper
		driver.findElement(By.xpath("//input[@title='SLEEPER']")).click();

		// Finding the number of available seats
		System.out.println("Available Seats: "
				+ driver.findElement(By.xpath("//p[@class='noseats AvailSts ng-binding']")).getText());

		// Click SelectSeat
		driver.findElement(By.xpath("//a[@class='btn-seatselect book1']")).click();

		// Choose any one Available seat
		driver.findElement(By.xpath("//li[contains(@class,'sleeper available')]/a")).click();

		// Print Seats Selected
		System.out.println("Selected Seat Details: "
				+ driver.findElement(By.xpath("//p[contains(text(),'Seats Selected ')]/following::span")).getText());

		// Print Total Fare
		System.out.println("Total Fare:"
				+ driver.findElement(By.xpath("//p[contains(text(),'Total Fare')]/following::span")).getText());

		// select boarding point
		WebElement boardingid = driver.findElement(By.id("boardingpoint_id"));
		Select board = new Select(boardingid);
		board.selectByIndex(1);

		// select drop point
		WebElement droppingid = driver.findElement(By.id("droppingpoint_id"));
		Select drop = new Select(droppingid);
		drop.selectByIndex(1);

		driver.findElement(By.id("btnEnable1")).click();

		// Get the Title of the page(use .getTitle())
		System.out.println("Page Title:" + driver.getTitle());

	}

}