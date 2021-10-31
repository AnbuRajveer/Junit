package org.junit;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertJUnit {

	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		
	}

	@Before
	public void before() {
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	public void test1() {
		String url = driver.getCurrentUrl();
		boolean contains = url.contains("book");
		Assert.assertTrue(contains);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("123144");
		Assert.assertEquals("verify", "123144", email);
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("asda4534");
	}
	@Test
	public void login() {
		WebElement clkLogin = driver.findElement(By.id("login"));
		clkLogin.click();
	}

	@After
	public void date() {
		Date date = new Date();
		System.out.println(date);
	}

	@AfterClass
	public static void quit() {
		
	}

}
