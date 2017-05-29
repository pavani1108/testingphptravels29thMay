package com.phptravels.pageobjectrepolib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phptravels.genericlib.WebDriverCommonLib;

public class EditCustomer extends WebDriverCommonLib{

	@FindBy(xpath="//a[@title='Edit']")
	private WebElement editCust;
	
	@FindBy(xpath="//div[@class='icheckbox_square-grey checked']/input[@value='addTours']")
	private WebElement addToursSelected;
	
	@FindBy(xpath="//div[@class='icheckbox_square-grey checked']/descendant::input[@value='editTours']")
	private WebElement editToursSelected;
	
	@FindBy(xpath="//div[@class='icheckbox_square-grey checked']//input[@value='deleteTours']")
	private WebElement deleteToursSelected;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement createCust;
	
	public EditCustomer()
	{
	      
		
	}
	
	public void editCustomer(){
		
		click(editCust);
		if(isSelected(addToursSelected)){
			System.out.println("addTours is selected");
		}
		else{
			System.out.println("addTours is not selected");
		}
		if(isSelected(deleteToursSelected)){
			System.out.println("deleteTours is selected");
		}
		else{
			System.out.println("deleteTours is not selected");
		}
		if(isSelected(editToursSelected)){
			System.out.println("editTours is selected");
		}
		else{
			System.out.println("editTours is not selected");
		}
		click(createCust);
	}
		

}
