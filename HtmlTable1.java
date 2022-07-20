package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTable1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		
		List<String> list = new ArrayList<String>();
		int rowsize = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr")).size();
		System.out.println("Number of Rows :" +rowsize);
		for (int i = 1; i <=rowsize; i++) {
			String text = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+(i)+"]")).getText();
			list.add(text);	
		}
		System.out.println("Print all the content :" +list);
		
		int columnsize = driver.findElements(By.xpath("//div[@class='render']/table/thead/tr/th")).size();
		System.out.println("Number of Columns :" +columnsize);

	}

}
