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
public class DashboardTest extends TestBase{
	
//	public DashboardTest() throws IOException {
//        super();
//    }
	
	SoftAssert sa = new SoftAssert();
	SoftAssert sa2 = new SoftAssert();
	SoftAssert sa3 = new SoftAssert();
	public static int count=0;
	
	Dashboard dp1;

	@BeforeClass //With this code null pointer java.lang.NullPointerException: Cannot invoke "pageobject.Dashboard.Click_inputPage()" because "this.dp1" is null
	public void initTest(){
	   dp1  = PageFactory.initElements(driver, Dashboard.class);
	}
	
	
	@Test(priority=1,description="Verify_Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Title")
	
	
//--------------------------Verify Dashboard Title---------------------------------
	
	public void Verify_Dashboard_Title() throws InterruptedException 
	{
		search_page sp = new search_page(driver);
		Homepage hp= new Homepage(driver);
		hp.Click_dashboard();
		Thread.sleep(2000);
//		sp.Asset_type_enter("Laptop");
//		sp.Asset_type.sendKeys(Keys.DOWN);
//		sp.Asset_type.sendKeys(Keys.DOWN);		
//		Actions actionObj = new Actions(driver);
//		actionObj.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).build().perform();
//		actionObj.keyDown(Keys.ARROW_DOWN).sendKeys(Keys.DOWN).build().perform();
	}
	

//--------------------------Verify Filters Options on Dashboard---------------------------------
	
	@Test(priority=3, enabled=true)
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
	    dp1.filter1_cancel();		
	}	

//-------------------------Verify Clear filters on dashboard ------------------------------------
	
	@Test(priority=4,enabled=true)
	public void Filter_Clear() throws InterruptedException 
	{
		Thread.sleep(4000);
		dp1.filter1_click();
		dp1.filter1_clear();
	    //dp1.filter1_cancel();		
	}	
	

//------------------------Verify Headers List on Dashboard Screen --------------------------------
	
	@Test(priority=2,dependsOnMethods="Verify_Dashboard_Title",enabled=true)
	public void Verify_Dashboard_List_Headers() 
	{
	try {
		Thread.sleep(4000);
			System.out.println("Dashboard "+dp1);

			Actions actions = new Actions(driver);
			// Page Up
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
			
			List<String> allHeader= new ArrayList<String>();
			allHeader=dp1.Traverse_pagination();
			for (int j=1;j<=allHeader.size();j++)
			{
				sa.assertEquals(allHeader.get((j*3)-3), "Time");
				sa.assertAll();
				sa2.assertEquals(allHeader.get((j*3)-2), "Description");
				sa2.assertAll();
				sa3.assertEquals(allHeader.get((j*3)-1), "Performed -By");
				sa3.assertAll();
			}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	

	
//------------------Verify Total Assets count-----------------------------------------
	
	@Test(priority=5, enabled=false)
	public void Verify_Total_Assets() throws InterruptedException 
	{
		Homepage hp= new Homepage(driver);
		hp.AMSactions_click();
	}
	
	@DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
	 return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }
}
