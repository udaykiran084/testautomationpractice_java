package framework.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GUI_elements_page {
	
	
	WebDriver driver;

	public GUI_elements_page(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	// GUI  form components
	
	@FindBy(xpath="//input[@id='name']") WebElement name;
	
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='phone']") WebElement phone;
	@FindBy(xpath="//textarea[@id='textarea']") WebElement textarea;
	
	//radio button
	@FindBy(xpath="//input[@name='gender']//following-sibling::label") List<WebElement> gender;
	
	//check box 
	@FindBy(xpath="//input[@type='checkbox']//following-sibling::label") List<WebElement> chckbx_days;
	
	//dropdown_countries
	
	@FindBy(xpath="//select[@id='country']") WebElement countries_drpdwn;
	
	// drop down colors
	
	@FindBy(xpath="//select[@id='colors']") WebElement colors_drpdwn;
	
	
	// date picker
	
	@FindBy(xpath="//input[@id='datepicker']") WebElement datepicker1_input;
	
	@FindBy(xpath="//input[@id='txtDate']") WebElement datepicker2_input;
	
	@FindBy(xpath="//select[@data-handler='selectMonth']") WebElement dp2_month;
	@FindBy(xpath="//select[@data-handler='selectYear']") WebElement dp2_year;
	@FindBy(xpath="//table[@class ='ui-datepicker-calendar']//tr//td") List<WebElement> dp2_days;
	
	
	//date picker 3
	
	@FindBy(xpath="//input[@id ='start-date']") WebElement dp3_startdate;
	
	@FindBy(xpath="//input[@id ='end-date']") WebElement dp3_enddate;
	
	@FindBy(xpath="//div[@id ='result']") WebElement dp3_result;
	
	@FindBy(xpath="//input[@id='end-date']//following-sibling:: button[text() ='Submit']") WebElement dp3_submit;
	
	
	//upload single
	@FindBy(xpath="//input[@id='singleFileInput']") public WebElement   upload1;
	
	@FindBy(xpath="//button[text()='Upload Single File']") public WebElement   upload1_button;
	
	
	//multiple upload
	
	@FindBy(xpath="//input[@id='multipleFilesInput']") public WebElement   upload2_multi;
	
	@FindBy(xpath="//button[text()='Upload Multiple Files']") public WebElement   upload2_button;
	
	// web table 
	@FindBy(xpath="//table[@name='BookTable']//tr") List<WebElement> webtable_rows;
	@FindBy(xpath="//table[@name='BookTable']//tr/th") List<WebElement> webtable_cols;
	
	//dynamic web table 
	
	
	@FindBy(xpath="//h2[text()='Dynamic Web Table']") public WebElement   dytbl;
	
	@FindBy(xpath="//table[@id='taskTable']//tr[1]//th")  List<WebElement>    dytbl_headers;
	@FindBy(xpath="//table[@id='taskTable']//tr//td[1]")  List<WebElement>    dytbl_firstcolnames;
	
	@FindBy(xpath="//table[@id='taskTable']//tr") List<WebElement>   dytbl_rows;
	@FindBy(xpath="//table[@id='taskTable']//tr//td") List<WebElement>   dytbl_cols;
	
	
	@FindBy(xpath="//ul[@id='pagination']//a") List<WebElement>   pages;
	
	
	
	@FindBy(xpath="//h2[text()='Pagination Web Table']") public WebElement   Pagination_table;
	
	@FindBy(xpath="//table[@id='productTable']//tr") List<WebElement> s;
	
	@FindBy(xpath="//h2[text()='Dynamic Button']")  WebElement   dymicbutton;
	
	public void dynamic_button() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", dymicbutton);
		
	}
	
	
	
	public void paginationtable() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", Pagination_table);
		
		 boolean b=true;
		int i=0;
		while(pages.size()>=i  && b) {
			 i++;
				
				if (i<=pages.size()) {
					driver.findElement(By.xpath("//ul[@id='pagination']//li["+i+"]//a")).click();
				}
			
			for (int j=1;j<s.size();j++) 
				{
				
				if(driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[2]")).getText().equalsIgnoreCase("Action Camera")) {
					
					
					driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[4]//input")).click();
					
					b=false;
				}
					}
		 
		
			
		}	
		
		}
			
			
	
			
			
		

	
	
	
	
	
	public void datepicker3(String sdate,String edate) {
		dp3_startdate.sendKeys(sdate);
		dp3_enddate.sendKeys(edate);
		dp3_submit.click();
		System.out.println(dp3_result.getText());
	}
	
	
	public void datepicker2(String mnth,String year,String date) {
		
		datepicker2_input.click();
		
		 Select m =new Select(dp2_month);
		 m.selectByValue(mnth);
		 
		 Select y =new Select(dp2_year);
		y.selectByValue(year);
		
		dp2_days.stream().filter(s->s.getText().equalsIgnoreCase(date)).findFirst().ifPresent(s->s.click());
		
		
		
	}
	
	
	
	public void  fillform(String n,String e,String p,String text) {
		
		name.sendKeys(n);
		email.sendKeys(e);
		phone.sendKeys(p);
		textarea.sendKeys(text);
		
		
	}
	
 public void selectradiobutton(String gen) {
	 
	 gender.stream().filter(s->s.getText().equalsIgnoreCase(gen)).findFirst().ifPresent(s->s.click());;
	 
 }
 
	
 
 public void selectcheckbox(String chkbx) {
	 
	 chckbx_days.stream().filter(s->s.getText().equalsIgnoreCase(chkbx)).findFirst().ifPresent(s->s.click());;
	 
 }
	
 public void selectcountry(String cnt) {
	 
	 Select s= new Select(countries_drpdwn);
	 
	 s.selectByValue(cnt);
	 
 }
 
 public void selectcolors(String cnt) {
	 
	 Select s= new Select(colors_drpdwn);
	 
	 s.selectByValue(cnt);
	 
 }
 
 public void datepicker1(String date) {
	 
	 datepicker1_input.sendKeys(date);
	 datepicker1_input.sendKeys(Keys.ENTER);
 }
 
 
 

 
 
 public void uploadfile() throws AWTException, InterruptedException {
	 String pth="D:\\QA_interview_prep\\guide.pdf";
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView();", upload1);
	 js.executeScript("arguments[0].click();", upload1);
	 Thread.sleep(3000);
	 Robot robot= new Robot();
	 
	 
	 StringSelection stringSelection = new StringSelection(pth);
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
     
     // Paste the file path using Robot
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_CONTROL);
     
     // Press Enter to confirm the selection
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     
     Thread.sleep(3000);
	 
	 upload1_button.click();
	 
}
 
 public void upload_multiplefiles() throws AWTException, InterruptedException {
	 String [] pths={"\"D:\\QA_interview_prep\\guide.pdf\"","\"D:\\QA_interview_prep\\‼️SQL Queries‼️.pdf\""};
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView();", upload2_multi);
	 js.executeScript("arguments[0].click();", upload2_multi);
	 Thread.sleep(3000);
	 Robot robot= new Robot();
	 
	 
	 StringSelection stringSelection = new StringSelection(String.join(" ", pths));
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
     
     // Paste the file path using Robot
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_CONTROL);
     
     // Press Enter to confirm the selection
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     
     Thread.sleep(3000);
	 
	 upload2_button.click();
	 
}
 
 
 public void printwebtable() {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h2[text()='Static Web Table']")));
	 
	 
	 for (int i=1; i<=webtable_rows.size();i++) {
		 
		 for (int j=1; j<=webtable_cols.size();j++) {
			 
			 
			 if (i==1) {
				 System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/th["+j+"]")).getText());
				 System.out.print(" || ");
			 }else {
				 System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td["+j+"]")).getText());
				 System.out.print(" ||");
			 } 
			 	 
		 }
		 
		 System.out.println("  ");
		 
		 
	 }
	 
	}
 
 
 public void dynamictable() {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView();", dytbl);
	 
	 // chrome and cpu
	 
	 for(int i=1 ; i<dytbl_rows.size();i++) {
		 
		// String h=dytbl_headers.get(i).getText();
		 String c=dytbl_firstcolnames.get(i-1).getText();
		 int k=i-1;
		 if (c.equalsIgnoreCase("Chrome")) {
			 
		      for (int j=1;j<dytbl_headers.size();j++ ) {
		    	  int m=j+1;
		    	  if (dytbl_headers.get(j).getText().equalsIgnoreCase("CPU (%)")) {
		    		  
		    		  System.out.println("CPU load of Chrome process: "+driver.findElement(By.xpath("//table[@id='taskTable']//tr["+i+"]//td["+m+"]")).getText());
		    	  }
		    	  }
			 }
		 
		 
		 if (c.equalsIgnoreCase("Firefox")) {
			 
		      for (int j=1;j<dytbl_headers.size();j++ ) {
		    	  int m=j+1;
		    	  if (dytbl_headers.get(j).getText().equalsIgnoreCase("Memory (MB)")) {
		    		  
		    		  System.out.println("Memory Size of Firefox process:: "+driver.findElement(By.xpath("//table[@id='taskTable']//tr["+i+"]//td["+m+"]")).getText());
		    	  }
		    	  }
			 }
		 
		 
		 }
		
		 
 }
		
			 
			 	 
	 }
	 
	
 
 
 
 
 
 
	

