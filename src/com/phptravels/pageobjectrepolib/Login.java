package com.phptravels.pageobjectrepolib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.phptravels.genericlib.Browser;
import com.phptravels.genericlib.Constants;
import com.phptravels.genericlib.WebDriverCommonLib;

public class Login extends WebDriverCommonLib{
     @FindBy(name="email")
     private WebElement usernameEdt;
     
     @FindBy(name="password")
     private WebElement passwordEdt;
     
     @FindBy(xpath="//span[text()='Login']")
     private WebElement loginBtn;
     
     public void loginToAPP(){
    	 waitForPageToLoad();
    	 Browser.driver.get(Constants.url);
    	 Browser.driver.manage().window().maximize();
    	 type(usernameEdt, Constants.username);
    	 type(passwordEdt, Constants.password);
    	 click(loginBtn);
     }
     
     public void loginToAPP(String url , String username, String password){
    	 waitForPageToLoad();
    	 Browser.driver.get(Constants.url);
    	 Browser.driver.manage().window().maximize();
    	 type(usernameEdt, username);
    	 type(passwordEdt, password);
    	 click(loginBtn);
     }
     
}
