package Smoke;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.TestAllureListener;
import pageobject.Ams_actions;
import pageobject.Dashboard;
import pageobject.Homepage;
import pageobject.LoginPage;
import pageobject.search_page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import testBase.TestBase;

@Listeners({listeners.TestAllureListener.class})
public class AMS_actionsTest extends TestBase{
	
	//Dashboard dp1 = new Dashboard(TestBase.driver);
	public static String randstr;
	Dashboard dp1;
	search_page sp1;
	SoftAssert sa = new SoftAssert();
		
	@BeforeClass//With this code null pointer java.lang.NullPointerException: Cannot invoke "pageobject.Dashboard.Click_inputPage()" because "this.dp1" is null
	public void initTest(){
	   dp1  = PageFactory.initElements(driver, Dashboard.class);
	   sp1 = PageFactory.initElements(driver, search_page.class);
	}
	
	
	@Test(priority=1,description="Verify_Title")
	public void Verify_AMSactions_Title() throws InterruptedException 
	{
		Homepage hp= new Homepage(driver);
		hp.AMSactions_click();
	}

	@Test(priority=2,description="Add Asset Type", enabled=true)
	public void ADD_AssetType() throws InterruptedException 
	{
		Ams_actions ac= new Ams_actions(driver);
		ac.Click_Add_AssetType_link();
		randstr="Assettype -"+ac.Return_Rand_string();
		System.out.println("Random = "+randstr);
		ac.Enter_assetType(randstr);
		ac.Click_assetType_submit_btn();
		//ac.Click_Asset_cancel_btn();
	}

	@Test(priority=3,description="Validate Asset Type Already Exist",dependsOnMethods="ADD_AssetType",enabled=true)
	public void Validate_AssetType_already_exist() throws InterruptedException 
	{
		
		Ams_actions ac= new Ams_actions(driver);
		ac.Click_Add_AssetType_link();
		ac.Enter_assetType("");
		ac.Enter_assetType(randstr);
		
		ac.Click_assetType_submit_btn();
		
//		String Alert_txt="ddd";//driver.switchTo().alert().getText();
//		sa.assertEquals(Alert_txt, "Asset Type exists in the system Enter a valid Asset Type");
//		sa.assertAll();
		
//		ac.Click_Asset_cancel_btn();
	}
	
	@Test(priority=4,description="Filter Asset Type",enabled=true)
	public void Filter_Asset_Type() throws InterruptedException
	{
		Ams_actions ac= new Ams_actions(driver);
		Thread.sleep(2000);
		ac.Click_Filter1();
		ac.Enter_Filter_Searchtxt(randstr);
		ac.Apply_filter_click();
		//String Str=ac.Search_AssetType_result();
		int rcount=ac.Count_List_AssetType();
		if(rcount>1) {
			System.out.println("passss");
		}
//		sa.assertEquals(Str, randstr);
//		sa.assertAll();
	}
	
	@Test(priority=5,description="Add Asset Check Validations",enabled=true)
	public void Add_Asset_Validations_Check() 
	{
		try 
		{
			Ams_actions ac= new Ams_actions(driver);
			ac.Click_Add_Asset_link();
			ac.Click_Asset_submit_btn();
			Thread.sleep(4000);
			ac.Submit_frm();
			String Alert_txt=driver.switchTo().alert().getText();
			sa.assertEquals(Alert_txt, "Please correct flagged fields before submitting the form!");
			sa.assertAll();
			driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			System.out.println(e.getCause());
		}
	}
	
	
	@Test(priority=6,description="Add Asset and submit",enabled=true)
	public void Add_Assets() throws InterruptedException
	{
		Ams_actions ac= new Ams_actions(driver);
//		ac.Click_Add_Asset_link();
//		ac.Click_Asset_submit_btn();
		ac.Select_organization("ACM");
//		ac.Select_Division("Div");
//		ac.Select_Unit("Unit");
		ac.Select_Asset_type("Laptop");
		ac.Select_Asset("Dell");
		ac.Select_wheather_in_use("Yes");
		ac.Submit_frm();
	}	
}