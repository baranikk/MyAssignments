package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IrctcWindow {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> winList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList.get(1));
		System.out.println(driver.getTitle());
		//Closing the parent window
		driver.switchTo().window(winList.get(0));
		driver.close();
		driver.switchTo().window(winList.get(1));
		System.out.println(driver.getTitle());
	}
}