package com.Page;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;
import com.Utility.TestUtil;


public class RegistrationPage extends TestBase {
	// Page Factory / Object Repository
	
	@FindBy(xpath = "//button[@id='dLabellogin']")
	WebElement login_Source_button;
	
	
	@FindBy(xpath ="//*[@id='jqSignup']")
	WebElement register_Button;
	
	@FindBy(xpath ="//*[@id='txtEmail']")
	WebElement email_Box ;
	
	@FindBy(xpath ="//*[@id='txtUserName']")
	WebElement user_Name ;
	
	@FindBy(xpath ="//*[@id='txtPassword']")
	WebElement password_Box ;
	
	@FindBy(xpath ="//*[@id='txtCnfPassword']")
	WebElement conf_Password;
	
	@FindBy(xpath ="//*[@id='txtFirstName']")
	WebElement first_Name;
	
	@FindBy(xpath ="//*[@id='txtLastName']")
	WebElement last_Name;
	
	@FindBy(name ="custom_field_2")
	WebElement address_Box;
	
	@FindBy(xpath ="//*[@id='btnRegister']")
	WebElement btn_Register;
	
	@CacheLookup
	@FindBy(xpath ="//*[@id='dLabel']/span")
	WebElement current_User_Name;
	

	// Initialization Page Factory
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public  String  pageTitle() {
		loginSourc();
		String title = driver.getTitle();
		System.out.println("The Page Title is : "+title);
		return title;

	}
	public void loginSourc() {
		login_Source_button.click();
		register_Button.click();
		
	}

	public void registerNewUser(String email, String userName, String password, String confirmPassword,
			String firstName, String lastName, String address) {
		
		loginSourc();
		email_Box.sendKeys(email);
		user_Name.sendKeys(userName);
		password_Box.sendKeys(password);
		conf_Password.sendKeys(confirmPassword);
		first_Name.sendKeys(firstName);
		last_Name.sendKeys(lastName);
		address_Box.sendKeys(address);
		btn_Register.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait_Time, TimeUnit.MILLISECONDS);
		

	}

	public void validatCurrentUser() {

		String loggedUser = current_User_Name.getText();
		System.out.println("The Current User is : " + loggedUser);
	}

}
