package com.Page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Base.TestBase;
import com.Utility.TestUtil;

public class HomePage extends TestBase {

	// PAGE FACTORY OBJECT REPOSITORY

	@FindBy(partialLinkText = "About Us")
	WebElement About_Us_Link;

	@FindBy(id = "item_details")
	WebElement item_Texts;

	@FindBy(partialLinkText = "Contact Us")
	WebElement Contact_Us_Link;

	@FindBy(className = "topsearch_fld")
	WebElement currencyList;

	// PAGE FACTORY INITIALIZATION
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void pageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page title is : " + title);
	}

	public void clikOnAboutUs() {
		System.out.println("Current page Title is : " + driver.getTitle());
		About_Us_Link.click();
		String aboutUsData = item_Texts.getText();
		System.out.println("Available Text : " + aboutUsData);
		driver.navigate().back();
	}

	public void clicOnContactUs() {
		Contact_Us_Link.click();
		System.out.println("Current page Title is : " + driver.getTitle());
		driver.navigate().back();
	}

	public void getCurrencyList() {
		Select select = new Select(currencyList);
		int siz = driver.findElements(By.tagName("option")).size();
		//Total size of this list
		System.out.println("Size is List is : " + siz);
		
		System.out.println("Actuall Items in this List ... ");
		
		for (int i = 0; i < siz; i++) {
			String allCurency = select.getOptions().get(i).getText();
			//All items 
			System.out.println("Inxex " + i + " is " + allCurency);
		}
		// Selecting the option as 'AUSTRALIAN DOLLAR'-- selectByVisibleText
		System.out.println("\nSelected Visible Text is 'Australian dollar:'");
		select.selectByVisibleText("Australian dollar");
		if (select.getFirstSelectedOption().getText().contains("AUSTRALIAN DOLLAR")) {
			System.out.println(select.getFirstSelectedOption().getText() + " Is Here Available.");
		} else {
			System.out.println(" AUSTRALIAN DOLLAR Is Not Available!!");

		}

	}

}
