package com.phptravels.pageobjectrepolib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phptravels.genericlib.WebDriverCommonLib;

public class Logout extends WebDriverCommonLib{
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement dropDown;

	@FindBy(xpath="//a[contains(text(), 'Log Out')]")
	private WebElement logoutLnk;

	public void logout() throws InterruptedException{
		clickAndWait(dropDown);
		clickAndWait(logoutLnk);
	}
	}



