package property_config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proper {

	WebDriver driver;

	@BeforeClass

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();

	}

	@Test
	public void login() {

		driver.get(ConfigLoader1.getMyValue("URL"));
		driver.findElement(By.cssSelector(".login")).click();
		driver.findElement(By.id("email")).sendKeys(ConfigLoader1.getMyValue("User"));
		driver.findElement(By.id("passwd")).sendKeys(ConfigLoader1.getMyValue("Pass"));
		driver.findElement(By.xpath("//button[@id = 'SubmitLogin']")).click();

	}

	@AfterClass
	public void tearDownClass() {
		driver.close();
	}

}

/*
 * Create a maven project
 * 
 * 
 * Create a properties file to store URL =
 * http://automationpractice.com/index.php User = waya@IOreak.net Password =
 * password
 * 
 * inside your test use the utility class to access URL , USER , PASSWORD
 * 
 * Create a test for login functionlity
 * 
 * //NAVIGATE TO THE PAGE //ENTER USER NAME AND PASSWORD //VERIFY YOU ARE LOGGED
 * IN SUCCESSFULLY
 */
