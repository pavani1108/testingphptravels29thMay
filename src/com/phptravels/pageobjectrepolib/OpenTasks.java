package com.phptravels.pageobjectrepolib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phptravels.genericlib.WebDriverCommonLib;

public class OpenTasks extends WebDriverCommonLib{

	
	@FindBy(xpath="//span[text()='Accounts']")
	private WebElement LaunchAcnt;
	
	@FindBy(xpath="//a[text()='Admins']")
	private WebElement SelectAdmins;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement AddCust;

	
	public void navigateToAccounts(){
		click(LaunchAcnt);
	}
	public void navigateToAdmins(){
		click(SelectAdmins);
	}
	
	public void addCustomer(){
		click(AddCust);
	}
}
