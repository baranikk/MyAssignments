package week4.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertLeafGround {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Handling a simple alert
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Alert alert1=driver.switchTo().alert();
		System.out.println("First Alert Text:"+alert1.getText());
		alert1.accept();
		System.out.println("Notification1"+driver.findElement(By.id("simple_result")).getText()+"\n");
		
		//Handling a confirmation alert
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		Alert alert2=driver.switchTo().alert();
		System.out.println("Second Alert Text:"+alert2.getText());
		alert2.dismiss();
		System.out.println("Notification2 :"+driver.findElement(By.id("result")).getText()+"\n");
		
		//Handling a sweet alert
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		System.out.println("Sweet alert text: "+driver.findElement(By.xpath("//div[@id='j_idt88:j_idt96_content']")).getText()+"\n");
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		//Handling a prompt 
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Alert prompt=driver.switchTo().alert();
		System.out.println("Prompt Alert Text:"+prompt.getText());
		prompt.sendKeys("Kantha");
		prompt.accept();
		System.out.println("Notification3 :"+driver.findElement(By.id("confirm_result")).getText()+"\n");
		
		//Sweet alert-confirmation
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		System.out.println("Sweet alert text: "+driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText()+"\n");
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		//alert-maximize and minimise
		driver.findElement(By.id("j_idt88:j_idt111")).click();
		System.out.println("Sweet alert text: "+driver.findElement(By.id("j_idt88:j_idt112_content")).getText()+"\n");
		
		driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-icon ui-dialog-titlebar-maximize')]//span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		
	}

}