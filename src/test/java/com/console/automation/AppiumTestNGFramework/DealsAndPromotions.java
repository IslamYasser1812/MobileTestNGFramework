package com.console.automation.AppiumTestNGFramework;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplaypage;
import pageObjects.WelcomePage;
import resources.Utilities;

public class DealsAndPromotions extends Utilities {
	
	@BeforeClass
	public void initialize() throws InterruptedException, IOException {
		driverInit();
	}

	@Test(description = "Verify User goto home page")
	public void Test1() throws IOException, InterruptedException {
		WelcomePage wp = new WelcomePage(testdriver);
		wp.click_Skip_Sign_In();
	}
	
	@Test(description = "Verify User Select Deals from Home Page")
	public void Test2() {
		HomePage hp = new HomePage(testdriver);
		hp.click_Deals();
	}

	@Test(description = "Verify User choose category Computers and sub category Software Department")
	public void Test3() throws InterruptedException {
		ProductDisplaypage pDP = new ProductDisplaypage(testdriver);
		pDP.click_Category_Filter();
		pDP.select_Category_Icon("Computers");

		// to be implemented Software section
	}

	@Test(description = "Verify Selected department is displayed")
	public void Test4() {

		// to be implemented to assert on page title

	}
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		driverClosure();
	}

}
