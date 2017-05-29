package com.phptravels.usertest;

import org.openqa.selenium.WebDriver;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.phptravels.genericlib.Browser;
import com.phptravels.genericlib.ReadFileData;
import com.phptravels.pageobjectrepolib.CreateNewCustomer;
import com.phptravels.pageobjectrepolib.EditCustomer;
import com.phptravels.pageobjectrepolib.Login;
import com.phptravels.pageobjectrepolib.Logout;
import com.phptravels.pageobjectrepolib.OpenTasks;
import com.phptravels.pageobjectrepolib.SuccessMsg;

/**
 * 
 * @author pavani
 *
 */
public class USerTest {
  /* step 1 : declaration of page objects*/
	 WebDriver driver;
	 Login loginPage;
	 Logout logout;
	 OpenTasks launchAdminPage; 
	 CreateNewCustomer createCust;
	 Properties props;
	 SuccessMsg actCust;
	 EditCustomer editCust;
	 
	
	@BeforeTest
	public void configBeforeMtd() throws Throwable{
		/*step 2: launch browser & object/variable initialization */
		  Reporter.log("launching browser");
	      driver = Browser.getBrowser();
	      loginPage = PageFactory.initElements(driver, Login.class);
		  logout = PageFactory.initElements(driver, Logout.class);
		  launchAdminPage = PageFactory.initElements(driver, OpenTasks.class);
		  createCust = PageFactory.initElements(driver, CreateNewCustomer.class);
		  actCust=PageFactory.initElements(driver, SuccessMsg.class);
	}
	@BeforeClass
	     public void configBeforeClass() throws Throwable{
		/*step 3 : login to APP */
		 Reporter.log("login to APP");
	     loginPage.loginToAPP();
	     /*step 4 : navigate to "Accounts tab" */
	     Reporter.log("navigating to Accounts");
	     launchAdminPage.navigateToAccounts();
	     /*step 5 : navigate to "Admins" */
	     Reporter.log("navigating to Admin Page");
	     launchAdminPage.navigateToAdmins();
	     /*step 6 : adding a customer*/
	     Reporter.log("Adding a customer");
	     launchAdminPage.addCustomer();
	     ReadFileData file= new ReadFileData(); 
	     file.getFile(null);
	     String customerName1 = file.getData("Name1");
	     String customerName2 = file.getData("Name2");
	     String email = file.getData("email");
	     String pwd = file.getData("pwd");
	     String countr=file.getData("country");
	     String mbl=file.getData("mobile");
	     String addr1=file.getData("Address1");
	     String addr2=file.getData("Address2");
	     /*step 7 : enter customer details and create*/
	     Reporter.log("creating new customer");
	     createCust.createCustomer(customerName1, customerName2, email, pwd, countr, mbl, addr1, addr2);
	     Reporter.log("verify");
	   
	}

	
	@Test
	public void verifyCustomerTest() throws Throwable{
		  /*step 8: verify whether customer creation is successful*/
		 Reporter.log("Verifying creation of customer result");
		 ReadFileData file= new ReadFileData(); 
		 file.getFile(null);
		 String expMsg=file.getData("expMsg");
	     String actMsg = actCust.getSuccesMsgTxt();
	     Assert.assertEquals(expMsg, actMsg);
	     
	  	}
	
	@Test
	   public void verifyToursSelected() throws Throwable{
		/*step 9 : edit and verify whether the "Tours" section is selected in the created customer*/
		Reporter.log("Edit and verify");
		editCust = PageFactory.initElements(driver, EditCustomer.class);
		editCust.editCustomer();
		
	}
	
	@AfterTest
	public void configAfterMtd() throws InterruptedException{
		/*step 10  :logout*/
		Reporter.log("logout");
	     logout.logout();
	}
	     
	@AfterClass
	public void configAfterCls(){
		/*step 11  :close browser*/
		Reporter.log("close browser");
		driver.quit();
	}
	
}
