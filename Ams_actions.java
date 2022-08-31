package pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

	String randstr;
	static boolean asset_found=false;
	static int index_ele=0;// is the index of asset to be edited & deleted
	
	public Ams_actions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public Ams_actions(String get_srch_input) {
		randstr=get_srch_input;
	}	
  
  @FindBy(xpath="//a[text()='+ Asset']")
  public WebElement add_asset_link;

  @FindBy(xpath="//a[text()='+ Asset Type']")
  public WebElement add_assetType_link;  
  
  @FindBy(xpath="//button[text()='Submit']")
  public WebElement Add_asset_Submit_btn;
  
  @FindBy(xpath="//tbody[@id='gridTableBody']//tr//th")
  List<WebElement> Table_header;
  
//--------Asset_type_textbox --------------------------------  
  @FindBy(xpath="//input[@name='$PAssetTypePage$pAssetType']")
  WebElement Asset_type_txt;  
  
//--------Asset_type_Submit_btn --------------------------------  
  @FindBy(xpath="//button[@id='ModalButtonSubmit']")
  WebElement Asset_type_submit;  
    
//--------Asset_type_Cancel_btn --------------------------------  
  @FindBy(xpath="//button[contains(text(),'  Cancel ')]")
  WebElement Asset_type_cancel;  
  
//--------Asset_type_Validation_msg --------------------------------  
  @FindBy(xpath="//span[text()='Asset Type exists in the system Enter a valid Asset Type']")
  WebElement Add_Asset_type_Val_msg;  
    
//--------Organization selectbox --------------------------------  
  @FindBy(xpath="//select[@id='cc108b5b']")
  WebElement org_select;  
  
//--------Organization validation msg --------------------------------  
  @FindBy(xpath="//div[@id='$PAssetPage$pRegionNameError']//span[text()='Value cannot be blank']")
  WebElement org_validation;    
  
//--------Division selectbox --------------------------------  
  @FindBy(xpath="//select[@id='1399ce02']")
  WebElement Division_select;  

//--------Division validation msg --------------------------------  
  @FindBy(xpath="//div[@id='$PAssetPage$pStateNameError']//span[text()='Value cannot be blank']")
  WebElement division_validation;   
  
//--------Unit selectbox --------------------------------  
  @FindBy(xpath="//select[@data-test-id='202205261231470602871']")
  WebElement Unit_select;

//--------Unit validation msg --------------------------------  
  @FindBy(xpath="//div[@id='$PAssetPage$pUnitNameError']//span[text()='Value cannot be blank']")
  WebElement Unit_validation;   
  
//--------Asset Type selectbox --------------------------------  
  @FindBy(xpath="//input[@id='2cdc6628']")
  WebElement AssetType_select;  
  
//--------Asset Type validation msg --------------------------------  
  @FindBy(xpath="//div[@id='$PAssetPage$pAssetTypeError']//span[text()='Value cannot be blank']")
  WebElement Asset_type_validation;   
  
//--------Asset Selectbox --------------------------------  
  @FindBy(xpath="//input[@id='5e59a106']")
  WebElement Asset_select;  

//--------Asset validation msg --------------------------------  
  @FindBy(xpath="//div[@id='$PAssetPage$pNameError']//span[text()='Value cannot be blank']")
  WebElement Asset_validation;   
    
  
//--------Specification Textbox --------------------------------  
  @FindBy(xpath="//input[@id='fdf489fb']")
  WebElement specification_txt;  
  
//--------Wheather In Use selectbox --------------------------------  
  @FindBy(xpath="//select[@id='ed6e44b8']")
  WebElement Select_wheather_in_use;  
    
//--------Wheather in use validation msg --------------------------------  
  @FindBy(xpath="//div[@id='$PAssetPage$pWhetherInUseError']//span[text()='Value cannot be blank']")
  WebElement wheather_validation;    
    
//--------Service start date Textbox --------------------------------  
  @FindBy(xpath="//input[@id='63270bca']")
  WebElement Service_start_date_txt;  
     
//--------Asset Address Textbox --------------------------------  
  @FindBy(xpath="//input[@id='24df6388']")
  WebElement Aset_address_txt;    
  
//--------Asset Address Textbox --------------------------------  
  @FindBy(xpath="//button[contains(text(),'Submit')]")
  WebElement Submit_btn;    

//--------Assets page count --------------------------------  
  @FindBy(xpath="//div[@class=' flex content layout-content-inline_grid_double  content-inline_grid_double ']/child::div[2]//label[@data-test-id='20141007100658002115508']")
  WebElement Assets_pg_count;    

//--------Last page count --------------------------------  
  @FindBy(xpath="//button[@title='Last Page']")
  WebElement Last_page;    
  
//--------List assets table --------------------------------    
  @FindBy(xpath = "//div[@class=' flex content layout-content-inline_grid_double  content-inline_grid_double ']/child::div[2]//table[@id='bodyTbl_right']//tbody//tr")
  List<WebElement> List_assets;
  
//--------List assetsType table --------------------------------    
  @FindBy(xpath = "//div[@class=' flex content layout-content-inline_grid_double  content-inline_grid_double ']/child::div[1]//table[@id='bodyTbl_right']//tbody//tr")
  List<WebElement> List_asset_type;
  
//--------List activities table --------------------------------    
  @FindBy(xpath = "//div[@class=' flex content layout-content-inline_grid_double  content-inline_grid_double ']/child::div[3]//table[@id='bodyTbl_right']//tbody//tr")
  List<WebElement> List_activities;  
  
//-29-evening------------------Filter Options----------------------------
//-------------
  @FindBy(xpath="//a[@id='pui_filter']")
  WebElement filter_button1;
 
//-------------------Filter Options----------------------------
  @FindBy(xpath="//input[@data-test-id='201411181100280377101613']")
  WebElement filter_search_txt;
 
//-------------------Apply Filter Button----------------------------
  @FindBy(xpath="//button[text()='Apply']")
  WebElement Apply_filter_btn;
//button[@onclick='pega.u.d.getPopOver(0).close('OK')']
//-------------------Cancel Filter Button----------------------------
  @FindBy(xpath="//button[@onclick='pega.u.d.getPopOver(0).close('cancel')']")
  WebElement Cancel_filter_btn;
 
  //-------------------AssetType_Filter_Result----------------------------
  @FindBy(xpath="//table[@id='bodyTbl_right']//tbody//tr")
  WebElement AssetType_Srch_filter_result;
  

  //-------------------AssetType_Filter_Result----------------------------
  @FindBy(xpath="//div[@class=' flex content layout-content-inline_grid_double  content-inline_grid_double ']/child::div[2]//button[@title='Next Page']")
  WebElement Asset_Nxt_btn;
  
  //-------------------Delete Asset submit button----------------------------
  @FindBy(xpath="//button[text()='  Submit ']")
  WebElement Del_Asset_submit_btn;
  
  public String get_AssetType_valmsg()
  {
	 WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(Add_Asset_type_Val_msg));
	 return Add_Asset_type_Val_msg.getText();
  }
  
  public void Click_Filter1()
  {
	 WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(filter_button1));
	 filter_button1.click();
  }
 
  public void Enter_Filter_Searchtxt(String str)
  {
 WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
 wait.until(ExpectedConditions.elementToBeClickable(filter_search_txt));
 filter_search_txt.sendKeys(str);
  }    
 
  public void Apply_filter_click()
  {
	  WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Apply_filter_btn));
      Apply_filter_btn.click();
  }
 
  public void cancel_filter_click()
  {
	  WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Cancel_filter_btn));
      Cancel_filter_btn.click();
  }    
  
  public String Search_AssetType_result()
  {
	  WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(AssetType_Srch_filter_result));
	  return AssetType_Srch_filter_result.getText();
  }   
  
  public void Click_Add_Asset_link()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(add_asset_link));
	  add_asset_link.click();
  }

  public void Click_Add_AssetType_link()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(add_assetType_link));
	  //add_assetType_link.click();
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", add_assetType_link);
  }
  
  public void Enter_assetType(String str)
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Asset_type_txt));
	  Asset_type_txt.sendKeys(str);
  }

  public void Click_assetType_submit_btn()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Asset_type_submit));
	  Asset_type_submit.click();
  }
  
  public void Click_Asset_submit_btn()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Add_asset_Submit_btn));
//	  Add_asset_Submit_btn.click();
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Add_asset_Submit_btn);  
  }
  
  public void Click_Asset_cancel_btn()
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Asset_type_cancel));
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Asset_type_cancel);  
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
	  Thread.sleep(4000);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(AssetType_select));
	  //AssetType_select.sendKeys(Keys.DOWN);
	  AssetType_select.sendKeys(str);
	  selectOptionfromList(str);
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

  public void click_Asset_del_button() throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(Del_Asset_submit_btn));
	  Del_Asset_submit_btn.click();
  }  
  
  public void Submit_frm()
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,450)", "");  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	  wait.until(ExpectedConditions.elementToBeClickable(Submit_btn));
      //System.out.println("Is enabled "+Submit_btn.isEnabled());
	  
      Submit_btn.click();
  } 
  
 public void Assets_count()
 {
	 Last_page.click();
	 
 }
  
 public int Count_List_AssetType()
 {
	 return List_asset_type.size();
	 
 }
  
 public int Count_List_Asset()
 {
	 return List_assets.size();
	 
 } 

 public void Edit_asset(int index_ele) 
 {
		List_assets.get(index_ele).findElements(By.xpath("//i[@data-test-id='202203300135520890283']")).get(index_ele-1).click();
 }
 
 public void delete_asset(int index_ele) 
 {
	List_assets.get(index_ele).findElements(By.xpath("//i[@data-test-id='202203300135520890667']")).get(index_ele-1).click();
 }
 
  public void selectOptionfromList(String textToSelect) 
  {
		try {
			Thread.sleep(3000);
			List<WebElement> autoOptions = driver.findElements(By.xpath("//div[@class='cellIn']//span//span"));

			//System.out.println("Size "+autoOptions.size());
			for(WebElement option : autoOptions)
			{
				//System.out.println("valuss "+option.getText());
		        if(option.getText().equals(textToSelect))
		        {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
			}
		  }
		catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
  
  
  
	public int Search_asset(String asset_name) throws InterruptedException {
		int j=1;
		int recordcount = Integer.parseInt(Assets_pg_count.getText());
//		System.out.println("Reccc "+ recordcount);
		List<String> allHeaderNames = new ArrayList<String>();
		
		for (int k=2; k<=recordcount; k++) {
			Thread.sleep(4000);
			//List<WebElement> list_assets =List_assets;// driver.findElements(By.xpath("//div[@class=' flex content layout-content-inline_grid_double  content-inline_grid_double ']/child::div[2]//table[@id='bodyTbl_right']//tbody//tr")); 
			
			System.out.println("List_count "+ List_assets.size());
			//j is used to iterate in inner list starting from index one-1
			for(j=1;j<=List_assets.size()-1;j++)
			
			//for (WebElement header : list_assets) 
			{
				String Asset_Name = List_assets.get(j).findElements(By.xpath("//a[@data-test-id='202203290949270601791']")).get(j-1).getText();
				//System.out.println("Asset Name "+Asset_Name);
				
				if (Asset_Name.equalsIgnoreCase(asset_name))
				{	
					asset_found=true;
					index_ele=j-1;
					//System.out.println("Asset-Found = "+asset_found);
					break;
				}
				
			}
			if(asset_found==true) {
				break;
			}
			Asset_Nxt_btn.click();
		}
		return j;
	}	

	public String Return_Rand_string()
	{
	    // create a string of all characters
	    String alphabet = "ABCDEFG";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 5;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    return randomString;
	    //System.out.println("Random String is: " + randomString);

	}
	
}
