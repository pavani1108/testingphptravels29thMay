package com.phptravels.pageobjectrepolib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.phptravels.genericlib.WebDriverCommonLib;

public class CreateNewCustomer extends WebDriverCommonLib{

	
	@FindBy(xpath="//input[@name='fname']")
	private WebElement customerFirstName;
	
	@FindBy(xpath="//input[@name='lname']")
	private WebElement customerLastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pWord;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@name='address1']")
	private WebElement addressFirstLine;
	
	@FindBy(xpath="//input[@name='address2']")
	private WebElement addressSecondLine;
	
	@FindBy(xpath="//select[@name='status']")
	private WebElement custStatus;
	
	@FindBy(xpath="//select[@name='country']")
	private WebElement custCountry;
	
	@FindBy(xpath="//input[@name='newssub']")
	private WebElement newsSubscription;
	
	@FindBy(xpath = "//input[@value='addTours']//following-sibling::ins[@class='iCheck-helper']")
	private WebElement addTours;
	
	@FindBy(xpath="//input[@value='editTours']//following-sibling::ins[@class='iCheck-helper']")
	private WebElement editTours;
	
	@FindBy(xpath="//input[@value='deleteTours']//following-sibling::ins[@class='iCheck-helper']")
	private WebElement removeTours;

	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement createCust;
	
	
	
	public CreateNewCustomer()
	{
	      
		
	}
		
	public void createCustomer(String customerName1, String customerName2, String emailID, String password, String country, String mobile, String addr1, String addr2){
		typeText(customerFirstName, customerName1);
		typeText(customerLastName, customerName2);
		typeText(email, emailID);
		typeText(pWord, password);
		select(custCountry, country);
		typeText(mobileNumber, mobile);
		typeText(addressFirstLine, addr1);
		typeText(addressSecondLine, addr2);
		scroll(editTours);
		editTours.click();
		scroll(addTours);
		addTours.click();
		scroll(removeTours);
		removeTours.click();
		click(createCust);
	}
	
	
	
}
