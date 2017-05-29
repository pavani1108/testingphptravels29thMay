package com.phptravels.pageobjectrepolib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessMsg {
		
		@FindBy(xpath="//div[@class='ui-pnotify-sticker']")
		private WebElement pauseMsg;
		
		@FindBy(xpath="//div[@class='ui-pnotify-closer']")
		private WebElement closeMsg;
		
		@FindBy(tagName="h4")
		private WebElement successMsgTxt;
		
		
		public String getSuccesMsgTxt() throws InterruptedException {
			
		return successMsgTxt.getText();
			
		}

	}

