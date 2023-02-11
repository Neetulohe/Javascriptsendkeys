package practiceproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class openingbrowserwithJS {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
 WebDriver driver = new ChromeDriver();
 
 driver.get("https://amazon.com");
 driver.manage().window().maximize();
 
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 Properties prop = new Properties();
 FileInputStream input = new FileInputStream("C:\\Users\\nitub\\eclipse-workspace\\practiceproject\\testdata.properties");
 prop.load(input);
 String selesearch = prop.getProperty("search1");
 WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
 
 JavascriptExecutor js = (JavascriptExecutor)driver;
 
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 wait.until(ExpectedConditions.elementToBeClickable(search));
 
 js.executeScript("arguments[0].value =(' "+selesearch+" ')", search); 
 
 driver.quit();
	}

}

