package com.phptravels.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
	
	public static WebDriver getBrowser(){
		
		if(Constants.browserName.equals("chrome")){
		     System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
	         driver = new ChromeDriver();
		}else if(Constants.browserName.equals("ie")){
		     System.setProperty("webdriver.ie.driver", "C:\\SeleniumJars\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
	         driver = new InternetExplorerDriver();		
		}else if(Constants.browserName.equals("firefox")){
			 driver = new FirefoxDriver();
		}
		return driver;
	}

}
