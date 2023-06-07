package com.actitime.testscript;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;

public class CustomerModule1 extends BaseClass {
	@Test
	public void createCustomer() throws InterruptedException {
	Reporter.log("createCustomer",true);
	Thread.sleep(5000);
	}
}
	


