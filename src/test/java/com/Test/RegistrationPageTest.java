package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Page.HomePage;
import com.Page.LoginPage;
import com.Page.RegistrationPage;
import com.Utility.TestUtil;

public class RegistrationPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtill;
	RegistrationPage registrationPage;
	public static String sheetNames = "Sheet1";

	public RegistrationPageTest() throws IOException {
		super();
	}



	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtill = new TestUtil();
		registrationPage = new RegistrationPage();

	}

	@Test
	public void pageTitleTest() {
		String title = registrationPage.pageTitle();
		AssertJUnit.assertEquals(title, "Register Now", "Doesnt Match......");
		System.out.println("Page title is : " + title);

	}

	@DataProvider
	public Object[][] getDataTest() {
		Object[][] data = TestUtil.getTestData(sheetNames);
		return data;
	}

	@Test(dataProvider = "getDataTest")
  	public void registerNewUserTest(String email, String userName, String password, String confirmPassword,
			String firstName, String lastName, String address) throws InterruptedException, IOException  {
		registrationPage.registerNewUser(email, userName, password, confirmPassword, firstName, lastName, address);
		Thread.sleep(5000);
		testUtill.takeScreenshoot();
		Thread.sleep(5000);
		registrationPage.validatCurrentUser();

	}


	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
