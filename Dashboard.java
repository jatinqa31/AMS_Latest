package pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import testBase.TestBase;

public class Dashboard extends TestBase {

	mapp map1 = new mapp();
	
	public Dashboard(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Maintenance Cases']")
	WebElement Maintenance_cases;

	@FindBy(xpath = "//input[@id='pyGridActivePage']")
	WebElement input_page;

	@FindBy(xpath = "//button[@title='Next Page']")
	WebElement Next_pages;

	@FindBy(xpath = "//label[@data-test-id='20141007100658002115508']")
	WebElement Record_count;

	@FindBy(xpath = "//table[@id='bodyTbl_right']//tr")
	List<WebElement> Table_records;

	@FindBy(xpath = "//table[@id='bodyTbl_right']//tbody//tr//th")
	List<WebElement> Table_header;
	
	@FindBy(xpath = "//a[text()='Next']")
	WebElement Next_page_link;

	@FindBy(xpath = "//a[@id='pui_filter']")
	WebElement filter1;

	@FindBy(xpath = "//img[@data-test-id='20141118104047081580062-DatePicker']")
	WebElement Calander1;

	@FindBy(xpath = "//input[@id='fb982b32']")
	WebElement Calander1_input;

	@FindBy(xpath = "//img[@data-test-id='201411181040470816801140-DatePicker']")
	WebElement Calander2;

	@FindBy(xpath = "//input[@id='7e5883f0']")
	WebElement Calander2_input;

	@FindBy(xpath ="//li[@id='pob0']//div//button[1]")
	WebElement filter_apply_btn;
	
	@FindBy(xpath ="//li[@id='pob0']//div//button[2]")
	WebElement filter_cancel_btn;

	@FindBy(xpath ="//a[@id='clearFilter']")
	WebElement filter_clear;
	
	@FindBy(xpath ="//div[text()='Total Assets']")
	WebElement Total_assets_link;

	@FindBy(xpath ="//div[text()='Breakdown Report']")
	WebElement Breakdown_report_link;
	//	
	@FindBy(xpath ="//div[text()='Broken Assets']")
	WebElement Broken_assets_link;
	
	@FindBy(xpath ="//div[text()='Working Assets']")
	WebElement Working_assets_link;
	
	public WebElement Click_inputPage() {
		return input_page;
	}

	public void Click_Maintenance() {
//	  Actions actions = new Actions(driver);
//		// Page Up
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//		wait.until(ExpectedConditions.elementToBeClickable(Maintenance_cases));
//		System.out.println("Selected "+Maintenance_cases.isDisplayed());
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", Maintenance_cases);
	}
	

	public List<String> Traverse_pagination() throws InterruptedException {

		int recordcount = Integer.parseInt(Record_count.getText());
		recordcount=5;
		
		List<String> allHeaderNames = new ArrayList<String>();
		System.out.println("Record count "+ recordcount);
		
		for (int k=2; k<=recordcount; k++) {
			Thread.sleep(4000);
			List<WebElement> allHeadersEle = Table_header; 
			
			for (WebElement header : allHeadersEle) 
			{
				String headerName = header.getText();
				//System.out.println("Headerr"+headerName);
				allHeaderNames.add(headerName);
			}
			Next_pages.click();
		}
		return allHeaderNames;
	}

	public void Read_dashboard() throws InterruptedException {
		Thread.sleep(4000);
//		// Each row will be a key value pair. So we will use LinkedHashMap so that order can be retained.
//		// All map will be added to a list.
//		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
//
//		// Get total rows count
//		// String rowLoc = "//table[@id='dtBasicExample']//tbody/tr";
//		List<WebElement> allRowsEle = Table_records;// driver.findElements(By.xpath(rowLoc));
//		System.out.println("Header row element " + allRowsEle.size());
//		
//		for (int i=2;i<=allRowsEle.size()-1;i++) {
//			//Thread.sleep(2000);
//			// Getting specific row with each iteration
//			// row_count.get(i).findElement(By.tagName("td"));
//			String specificRowLoc = "//table[@id='bodyTbl_right']//tr[" + i + "]";//table[@data-test-id='202207150640420811395-layout']//tr[" + i + "]";
//			// Locating only cells of specific row.
//			System.out.println(specificRowLoc);
////			List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc)).findElements(By.tagName("td"));// this code is written to avoid stale element reference inside a loop
//			 List<WebElement> allColumnsEle=Table_records.get(i).findElements(By.tagName("td"));
//			// Creating a map to store key-value pair data. It will be created for each
//			// iteration of row
//			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
//
//			System.out.println("Size  "+eachRowData.size());
//			// Iterating each cell
//			for (int j=0; j<=2;j++) {
//				// Getting cell value
//				String cellValue = allColumnsEle.get(j).getText();
//				// We will put in to map with header name and value with iteration
//				// Get jth index value from allHeaderNames and jth cell value of row
//				eachRowData.put(allHeaderNames.get(j), cellValue);
//			}
//			// After iterating row completely, add in to list.
//			allTableData.add(eachRowData);
//		}
//		System.out.println("All table data " + allTableData);
//		
//
	}

	public void filter1_click() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(filter1));
		filter1.click();
	}

	public void filter1_Apply() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(filter_apply_btn));
		filter_apply_btn.click();
	}
	
	public void filter1_cancel() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(filter_cancel_btn));
		filter_cancel_btn.click();
	}

	public void filter1_clear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(filter_clear));
		filter_clear.click();
	}
	
	public void calander1_input(String str) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(Calander1_input));
		Calander1_input.sendKeys(str);
	}

	public void calander2_input(String str) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(Calander2_input));
		Calander2_input.sendKeys(str);
	}
	
	public void Total_Assets_click() {
		Total_assets_link.click();
	}

	public void Breakdown_report_click() {
		Breakdown_report_link.click();
	}

	public void Broken_assets_click() {
		Broken_assets_link.click();
	}	
	
	public void Working_assets_click() {
		Working_assets_link.click();
	}		

}
