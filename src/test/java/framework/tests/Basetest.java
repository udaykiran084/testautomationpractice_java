package framework.tests;

import java.awt.AWTException;
import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.Pages.GUI_elements_page;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Basetest {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com");
		GUI_elements_page p=new GUI_elements_page(driver);
		p.fillform("Automator", "Testing@gmail.com", "1234567891", "A Hybrid Testing Framework with POM (Page Object Model) improves maintainability and reusability by separating test "
				+ "logic from UI interactions. Below is a stepwise implementation.");
		
		
		p.selectradiobutton("Male");
		p.selectcheckbox("Monday");
		p.selectcountry("japan");
		p.selectcolors("white");
		
		p.datepicker1("03/26/2024");
		
		
		p.datepicker2("0", "2023", "5");
		
		p.datepicker3("02-02-2022","03-03-2025");
		
		
		
		
		p.upload_multiplefiles();
		
		p.printwebtable();
		
		p.dynamictable();
		
		p.paginationtable();
		
		p.dynamic_button();
		

	}

}
