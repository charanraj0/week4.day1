package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.snapdeal.com/");												
		driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("Training shoes", Keys.ENTER);
		//driver.findElement(By.id("inputValEnter")).sendKeys("Training shoes", Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='product-desc-rating ']"));
		System.out.println("Number of Shoes :" +elements.size());
		Thread.sleep(5000);
		//driver.findElement(By.className("sort-label")).click();
		//driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.className("sort-selected")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@class='search-li'][2]")).click();
		Thread.sleep(1000);
		WebElement clearFrom = driver.findElement(By.name("fromVal"));
		clearFrom.clear();
		clearFrom.sendKeys("900");
		WebElement clearTo = driver.findElement(By.name("toVal"));
		clearTo.clear();
		clearTo.sendKeys("1500");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//picture[@class='picture-elem']")).click();
	    Set<String> windowHandles = driver.getWindowHandles();
	    System.out.println(windowHandles);
	    List<String> handles = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(handles.get(1));
	    Thread.sleep(10000);
	    String shoeName = driver.findElement(By.xpath("//h1[@class='pdp-e-i-head']")).getText();
		System.out.println("Shoe Name :" +shoeName);
		Thread.sleep(3000);
	    String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price of the Shoe :" +price);
		Thread.sleep(3000);
		String discount = driver.findElement(By.xpath("//span[@class ='pdpDiscount ']")).getText();
		System.out.println("Discount :" +discount);
		Thread.sleep(3000);
		//take screenshots of the current page
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/IMG002.png");
		FileUtils.copyFile(source, dest);
		//Close the current window
		//driver.close();
		//close all the windows
		driver.quit();

		
	}

}
