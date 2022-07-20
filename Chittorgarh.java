package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("(//a[text() ='NSE Bulk Deals'])[1]")).click();
		
		List<String> securityName = new ArrayList<String>();
		int rowsize = driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr")).size();
		System.out.println("Number of rows :" +rowsize);
		for (int i = 1; i < rowsize; i++) {
			String text = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr["+(i+1)+"]/td[3]")).getText();
			securityName.add(text);
		}
		System.out.println(securityName);
		
		List<String> clientName= new ArrayList<String>();
		int size = driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr")).size();
		System.out.println("Number of rows :" +size);
		for (int i = 1; i < size; i++) {
			String text1 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr["+(i+1)+"]/td[4]")).getText();
			clientName.add(text1);
			
		}
		System.out.println(clientName);
	}

}
