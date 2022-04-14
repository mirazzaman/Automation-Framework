package com.Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

import sun.lwawt.macosx.CImage;

public class LoginPage extends TestBase {
	
	//Page Factory / Object Repository
	@FindBy(xpath = "//button[@id='dLabellogin']")
	WebElement login_Source_button;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement user_name;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement pass_word;
	
	@FindBy(xpath = "//button[@id='jqLogin']")
	WebElement login_button;
	

	@FindBy(xpath = "//*[@id='dLabel']/span")
	WebElement current_user_name;
	
	//Initialized Page-Fctory	
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page title is : " + title);
		return title;
	}
	
	public HomePage validateLogin(String userName, String pas) throws IOException {
		
		login_Source_button.click();
		user_name.sendKeys(userName);
		pass_word.sendKeys(pas);
		login_button.click();
		return new HomePage();	
	}
	
	public String validateCurrentUserName() {
		String visible_User_name = current_user_name.getText();
		System.out.println("Current User Name is : "+visible_User_name);
		return visible_User_name;
	}
	
	
	
	}
	


