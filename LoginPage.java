package pageobject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase{

	WebDriver driver;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Declaration

	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;

	
	@FindBy(xpath="//button[@id='sub']")
	WebElement Login_btn;
		
	@FindBy(xpath="//div[@id='error']")
	WebElement err_msg;
		

    public void EnterUsernam(String usr)
   {
	    username.clear();
		username.sendKeys(usr);
   }
  
	public void EnterPswd(String pswd)
   {
	    password.clear();
		password.sendKeys(pswd);
   }        
  
	public void Login_click()
   {
	   Login_btn.click();
   }        	
	public String read_error()
	   {
		return err_msg.getText();
	   }        	
}