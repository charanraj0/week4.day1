package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.redbus.in/");
		Thread.sleep(5000);
		driver.findElement(By.id("src")).sendKeys("Madiwala");
		driver.findElement(By.className("selected")).click();
//		Actions a = new Actions(driver);
//		a.moveToElement(autoFill).perform();
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys("Koyambedu");
		driver.findElement(By.className("selected")).click();
		Thread.sleep(2000);
		//to select date from the date picker
		driver.findElement(By.id("onward_cal")).click();
		String selectedMonth = driver.findElement(By.className("monthTitle")).getText();
		String month = selectedMonth.split(" ")[0].trim();
		String year = selectedMonth.split(" ")[1].trim();
		while (!(month.equals("Aug") && year.equals("2022"))) {
			driver.findElement(By.className("next")).click();
			selectedMonth = driver.findElement(By.className("monthTitle")).getText();
			System.out.println(selectedMonth);
			month = selectedMonth.split(" ")[0].trim();
			year = selectedMonth.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//td[text()='7']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[@for='dtAfter 6 pm'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Primo Bus']")).click();
		Thread.sleep(2000);
		String bus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of Buses :" +bus);
		driver.findElement(By.xpath("//a[text()='Fare']")).click();
		Thread.sleep(2000);
		driver.close();
		

	}

}