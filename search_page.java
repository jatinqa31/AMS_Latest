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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class search_page extends TestBase{

	public search_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  
  @FindBy(xpath="//input[@data-test-id='202204250843470340998']")
  public WebElement Asset_type;
  
  @FindBy(xpath="//input[@id='961b730e']")
  public WebElement Asset;

  @FindBy(xpath="//input[@id='82cf2207']")
  public WebElement Activity;
  
  @FindBy(xpath="//tbody[@id='gridTableBody']//tr//th")
  List<WebElement> Table_header;

  @FindBy(xpath="//button[@data-test-id='202206091157570013179']")
  public WebElement Search_btn;
  
  
  public void Asset_type_enter(String str)
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Asset_type));
	  Asset_type.sendKeys(str);
	  selectOptionfromList(str);
  }

  
  public void Asset_enter(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Asset));
	  Asset.sendKeys(str);
	  selectOptionfromList(str);
  }

  public void Enter_Activity(String str) throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Activity));
	  Activity.sendKeys(str);
	  selectOptionfromList(str);
  }
  
  public void ClickSearch()
  {
	  Search_btn.click();
  }  
  
  public void selectOptionfromList(String textToSelect) {
		try {
			Thread.sleep(2000);
			List<WebElement> autoOptions = driver.findElements(By.xpath("//div[@class='cellIn']//span"));

			System.out.println("Size "+autoOptions.size());
			for(WebElement option : autoOptions)
			{
				//System.out.println("Text "+option.getText());
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
