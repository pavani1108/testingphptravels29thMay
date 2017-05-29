package com.phptravels.genericlib;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author pavani
 *  
 */
public class WebDriverCommonLib {
	boolean flag = false;
	
	/**
	 * waitForPageToLoad()
	 * it polls the entire HTML document while loading the Page , it releases the control whenever page is completely loaded in UI
	 * 
	 */
	public void waitForPageToLoad(){		
		Browser.driver.manage().timeouts().implicitlyWait(Constants.timeOut, TimeUnit.SECONDS);
	}
	
	public void waitForElementPresent(WebElement expectedElement){
		WebDriverWait wait = new WebDriverWait(Browser.driver, Constants.timeOut);
		wait.until(ExpectedConditions.visibilityOf(expectedElement));
	}
	
	public void type(WebElement textElement , String data){
		waitForElementPresent(textElement);
		textElement.clear();
		textElement.sendKeys(data);
	}
	
	public void scroll(WebElement el) {
		 ((JavascriptExecutor)Browser.driver)
         .executeScript("javascript:window.scrollBy(250,350)");
		 Actions actions = new Actions(Browser.driver);
		 actions.moveToElement(el).perform();
		 	}
	
	public void scroll() {
		 ((JavascriptExecutor)Browser.driver)
        .executeScript("javascript:window.scrollBy(350,450)");
		 
	}
	
	
	public void typeText(WebElement textElement1, String data1){
		waitForElementPresent(textElement1);
		textElement1.clear();
		textElement1.sendKeys(data1);
	}
	
	public void submit(WebElement textEle){
		waitForElementPresent(textEle);
		textEle.submit();
	}
	
	
	public void click(WebElement clickElement){
	    waitForElementPresent(clickElement);
		clickElement.click();	
	}

	public void clickOnHiddenElement(WebElement clickHidden){
		((JavascriptExecutor)Browser.driver).executeScript("arguments[0].style.height=’auto’; arguments[0].style.visibility=’visible’;", clickHidden);
        clickHidden.click();
		}
	
	public void select(WebElement selElement , String data){
		waitForElementPresent(selElement);
		Select sel = new Select(selElement);
		sel.selectByVisibleText(data);
	}
	
	public void select(WebElement selElement , int index){
		waitForElementPresent(selElement);
		Select sel = new Select(selElement);
		sel.selectByIndex(index);
	}
	
	public boolean dynamicSelect(WebElement selElement, String data){
		flag = false;
		Select sel = new Select(selElement);
		List<WebElement> lst = sel.getOptions();
		for(int i=0; i>lst.size(); i++){
			if(data.equals(lst.get(i).getText())){
				sel.selectByVisibleText(data);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public boolean isSelected(WebElement ele){

		if(ele!=null && ele.isSelected()){
		return true;
		}
		return false;
		
	}
	
	
	public void okAlert(){
		Alert alt = Browser.driver.switchTo().alert();
		alt.accept();
	}
	

	public void cancelAlert(){
		Alert alt = Browser.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void clickAndWait(WebElement element) throws InterruptedException  {
		int count =0;
		while(count<=40){
			try{
				element.click();
				break;
			}catch (Throwable e) {
				Thread.sleep(500);
				count++;
			}
		}
	}
	
}












