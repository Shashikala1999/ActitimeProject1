package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

	@Listeners(com.actitime.generic.ListenerImplementation.class)
	public class CustomerModule extends BaseClass{
	
	

	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException {
		Reporter.log("CreateCustomer",true);

		FileLib f=new FileLib();
		String customerName = f.getExcelData("CreateCustomer", 1, 3);
		String customerDescription = f.getExcelData("CreateCustomer", 1, 4);
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBTn().click();
		t.getNewCustomerOption().click();
		t.getCustomerNameTbx().sendKeys(customerName);
		t.getCustomerDescriptionTbx().sendKeys(customerDescription);
		t.getSelectCustomerDropDown().click();
		t.getBigBangCompany().click();
		t.getCreateCustomerBtn().click();
		String actualText = t.getActualCustomerCreated().getText();
        Assert.assertEquals(actualText, customerName);
	}

	}
