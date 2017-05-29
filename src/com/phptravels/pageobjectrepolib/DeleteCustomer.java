package com.phptravels.pageobjectrepolib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phptravels.genericlib.WebDriverCommonLib;

public class DeleteCustomer extends WebDriverCommonLib{

	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement createCust;
	
	
	@FindBy(xpath="//a[@title='DELETE']")
	private WebElement deleteCust;

	public DeleteCustomer()
	{
	      
		
	}
	
	public void deleteCustomer(){
		deleteCust.click();
	}
}


