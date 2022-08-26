package pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class Ams_actions extends TestBase{

	public Ams_actions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  
  @FindBy(xpath="//a[text()='+ Asset']")
  public WebElement add_asset_link;

  @FindBy(xpath="//button[text()='Submit']")
  public WebElement Add_asset_Submit_btn;
  
  @FindBy(xpath="//tbody[@id='gridTableBody']//tr//th")
  List<WebElement> Table_header;
  
//--------Organization selectbox --------------------------------  
  @FindBy(xpath="//select[@id='cc108b5b']")
  WebElement org_select;  
  
//--------Division selectbox --------------------------------  
  @FindBy(xpath="//select[@id='1399ce02']")
  WebElement Division_select;  

//--------Unit selectbox --------------------------------  
  @FindBy(xpath="//select[@data-test-id='202205261231470602871']")
  WebElement Unit_select;
  
//--------Asset Type selectbox --------------------------------  
  @FindBy(xpath="//input[@id='2cdc6628']")
  WebElement AssetType_select;  
  
//--------Asset Selectbox --------------------------------  
  @FindBy(xpath="//input[@id='5e59a106']")
  WebElement Asset_select;  
  
//--------Specification Textbox --------------------------------  
  @FindBy(xpath="//input[@id='fdf489fb']")
  WebElement specification_txt;  
  
//--------Wheather In Use selectbox --------------------------------  
  @FindBy(xpath="//select[@id='ed6e44b8']")
  WebElement Select_wheather_in_use;  
    
//--------Service start date Textbox --------------------------------  
  @FindBy(xpath="//input[@id='63270bca']")
  WebElement Service_start_date_txt;  
     
//--------Asset Address Textbox --------------------------------  
  @FindBy(xpath="//input[@id='24df6388']")
  WebElement Aset_address_txt;    
  
//--------Asset Address Textbox --------------------------------  
  @FindBy(xpath="//button[text()='Submit']")
  WebElement Submit_btn;    
  
  public void Click_Add_Asset_link()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(add_asset_link));
	  add_asset_link.click();
  }

  public void Click_Asset_submit_btn()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Add_asset_Submit_btn));
	  Add_asset_Submit_btn.click();
  }
  
  
  public void Select_organization(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(org_select));
	  Select sl = new Select(org_select);
	  sl.selectByVisibleText(str);	  
  }
  
  public void Select_Division(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Division_select));
	  Select sl = new Select(Division_select);
	  sl.selectByValue(str);  
  }
  
  public void Select_Unit(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Unit_select));
	  Select sl = new Select(Unit_select);
	  sl.selectByVisibleText(str);  
  }
  
  public void Select_Asset_type(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(AssetType_select));
	  AssetType_select.sendKeys(Keys.DOWN);
	  AssetType_select.sendKeys("Laptop");
	  
	  Thread.sleep(2000);
	  //selectOptionfromList(str);
  }

  
  public void Select_Asset(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Asset_select));
	  Asset_select.sendKeys(str);
	  selectOptionfromList(str);
  }
  
  public void Enter_Specification(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(specification_txt));
	  specification_txt.sendKeys(str);
  }  
  
  public void Select_wheather_in_use(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Select_wheather_in_use));
	  Select sl = new Select(Select_wheather_in_use);
	  sl.selectByVisibleText(str);  
  }
  
  public void enter_Service_start_date(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Service_start_date_txt));
	  Service_start_date_txt.sendKeys("8/25/2022 12:25 AM");
  }  
  
  public void Submit_frm()
  {
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("window.scrollBy(0,450)", "");
//	  System.out.println("print the button "+Submit_btn.getText());     
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	  wait.until(ExpectedConditions.elementToBeClickable(Submit_btn));
      Submit_btn.click();
  } 
  
  public void selectOptionfromList(String textToSelect) {
		try {
			Thread.sleep(3000);
			List<WebElement> autoOptions = driver.findElements(By.xpath("//div[@class='cellIn']//span//span"));

			System.out.println("Size "+autoOptions.size());
			for(WebElement option : autoOptions)
			{
				System.out.println("valuss "+option.getText());
		        if(option.getText().equals(textToSelect))
		        {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
			}
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public List<String> Traverse_pagination() throws InterruptedException {

//		int recordcount = Integer.parseInt(Record_count.getText());
//		recordcount=5;
		
		List<String> allHeaderNames = new ArrayList<String>();
		
//		for (int k=2; k<=recordcount; k++) {
//			Thread.sleep(4000);
			List<WebElement> allHeadersEle = Table_header; 
			int i=0;
			for (WebElement header : allHeadersEle) 
			{
				
				if(i==8) {
					break;
				}
				String headerName = header.getText();
				//System.out.println("Headerr"+headerName);
				allHeaderNames.add(headerName);
				i=i+1;
			}
//			Next_pages.click();
//		}
		return allHeaderNames;
	}	

}
