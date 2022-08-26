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
import pageobject.Dashboard;
import pageobject.Homepage;
import pageobject.LoginPage;
import pageobject.search_page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import testBase.TestBase;

@Listeners({listeners.TestAllureListener.class})
public class Search360Test extends TestBase{
	
	
	SoftAssert sa = new SoftAssert();
	SoftAssert sa2 = new SoftAssert();
	SoftAssert sa3 = new SoftAssert();
	public static int count=0;
	
	//Dashboard dp1 = new Dashboard(TestBase.driver);
	
	Dashboard dp1;
	search_page sp1;

	@BeforeClass//With this code null pointer java.lang.NullPointerException: Cannot invoke "pageobject.Dashboard.Click_inputPage()" because "this.dp1" is null
	public void initTest(){
	   dp1  = PageFactory.initElements(driver, Dashboard.class);
	   sp1 = PageFactory.initElements(driver, search_page.class);
	}
	
	
	@Test(priority=1,description="Verify_Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Title")
	
	public void Verify_360Search_Title() throws InterruptedException 
	{
		Homepage hp= new Homepage(driver);
		hp.Search_360_click();
	}
	
	@Test(priority=2)
	public void Select_AssetType() throws InterruptedException 
	{
		sp1.Asset_type_enter("Laptop");
	}	
	
	@Test(priority=2, dependsOnMethods="Select_AssetType")
	public void Search_BY_AssetType()
	{
		sp1.ClickSearch();
	}	
	
	
	@Test(priority=3)
	public void Select_Asset() throws InterruptedException 
	{
		sp1.Asset_enter("JBL");
	}

	@Test(priority=3, dependsOnMethods="Select_Asset")
	public void Search_BY_Asset()
	{
		sp1.ClickSearch();
	}	

	
	
	@Test(priority=4)
	public void Select_Activities() throws InterruptedException 
	{
		Thread.sleep(2000);
		sp1.Enter_Activity("IPAD");
	}

	@Test(priority=4, dependsOnMethods="Select_Activities")
	public void Search_BY_Activity()
	{
		sp1.ClickSearch();
	}	
	
	@Test(priority=2, enabled=false)
	public void Filter_options() throws InterruptedException 
	{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		dp1.filter1_click();
		dp1.calander1_input("7/7/2022 12:29 AM");
		dp1.calander2_input("8/8/2022 09:00 AM");
		Actions actionObj = new Actions(driver);
		actionObj.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).build().perform();
	    Actions a= new Actions(driver);
	    a.sendKeys(Keys.PAGE_DOWN).build().perform();
		dp1.filter1_Apply();

	    //dp1.filter1_cancel();		
	}	
	
	@Test(priority=3,enabled=false)
	public void Filter_Clear() throws InterruptedException 
	{
		Thread.sleep(4000);
		dp1.filter1_click();
		dp1.filter1_clear();
	    //dp1.filter1_cancel();		
	}	
	
	@Test(priority=4,dependsOnMethods="Verify_360Search_Title",enabled=true)
	public void Verify_Search_List_Headers() 
	{
	try {
		Thread.sleep(4000);
			
			List<String> allHeader= new ArrayList<String>();
			allHeader=sp1.Traverse_pagination();
			System.out.println("okoko "+allHeader.size());
			for (int j=1;j<=7;j++)
			{
				sa.assertEquals(allHeader.get(1), "Name");
				sa.assertAll();
				sa.assertEquals(allHeader.get(2), "Asset Type");
				sa.assertAll();
				sa.assertEquals(allHeader.get(3), "Frequency");
				sa.assertAll();
				sa.assertEquals(allHeader.get(4), "Planning In Days");
				sa.assertAll();
				sa.assertEquals(allHeader.get(5), "Region");
				sa.assertAll();
				sa.assertEquals(allHeader.get(6), "State");
				sa.assertAll();
				sa.assertEquals(allHeader.get(7), "Unit");
				sa.assertAll();

			}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test(priority=5, enabled=false)
	public void Verify_Total_Assets() throws InterruptedException 
	{
		Homepage hp= new Homepage(driver);
		hp.AMSactions_click();
	}
	
	@DataProvider (name = "data-provider")
    public Object[][] dpMethod()
	{
		return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }
}
