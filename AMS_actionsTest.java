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
	public void Verify_AMSactions_Title() throws InterruptedException 
	{
		Homepage hp= new Homepage(driver);
		hp.AMSactions_click();
	}

	@Test(priority=2,description="Create Asset Check Validations")
	public void Create_Asset_Check_Validations() throws InterruptedException 
	{
		Ams_actions ac= new Ams_actions(driver);
		ac.Click_Add_Asset_link();
		ac.Click_Asset_submit_btn();
		ac.Submit_frm();
	}
	
	
	@Test(priority=3,description="Create Asset and submit",enabled=false)
	public void Create_Asset_and_submit() throws InterruptedException 
	{
		Ams_actions ac= new Ams_actions(driver);
		ac.Click_Add_Asset_link();
		ac.Click_Asset_submit_btn();
		ac.Select_organization("ACM");
//		ac.Select_Division("Div");
//		ac.Select_Unit("Unit");
		ac.Select_Asset_type("Laptop");
//		ac.Select_Asset("Dell");
//		ac.Select_wheather_in_use("Yes");
	}
}
