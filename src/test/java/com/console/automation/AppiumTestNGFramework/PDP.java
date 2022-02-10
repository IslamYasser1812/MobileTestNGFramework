package com.console.automation.AppiumTestNGFramework;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PDPage;
import pageObjects.SearchResults;
import pageObjects.WelcomePage;
import resources.Utilities;

public class PDP extends Utilities {
	@BeforeClass
	public void initialize() throws InterruptedException, IOException {
		driverInit();
	}
	
	@Test(description = "Verify User goto home page")
	public void Test1() throws IOException, InterruptedException {
		WelcomePage wp = new WelcomePage(testdriver);
		wp.click_Skip_Sign_In();
	}

	@Test(description = "Verify User Search for {string} and select first product", dataProvider = "getData")
	public void Test2(String searchValue) {
		HomePage hp = new HomePage(testdriver);
		hp.search_Amazon(searchValue);
		SearchResults sr = new SearchResults(testdriver);
		sr.select_First_Product();
	}

	@Test(description = "Verify User swipe the product images")
	public void Test3() {
		PDPage pDP = new PDPage(testdriver);
		pDP.swipeImage();
	}

	@Test(description = "Verify Price of product displayed")
	public void Test4() {
		PDPage pDP = new PDPage(testdriver);
		assertTrue(pDP.productPrice().contains("AED"));
	}

	@Test(description = "Verify Payment Options are displayed")
	public void Test5() {
		// to be implemented
	}

	@Test(description = "Verify Product availability information is displayed")
	public void Test6() throws InterruptedException {
		PDPage pDP = new PDPage(testdriver);
		String availabilityString = pDP.checkProductAvailability();
		assertTrue(availabilityString.contains("user"));
	}

	@Test(description = "Verify Add to cart functionality works fine")
	public void Test7() throws InterruptedException {
		PDPage pDP = new PDPage(testdriver);
		pDP.click_Add_To_Cart();
		assertTrue(pDP.check_Cart_Added_Confirmation());
		

	}
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		driverClosure();
	}
	
	@DataProvider(name = "getData")
	public Object[] getData() {
		
		Object[] objData = new Object[1];
		objData[0] = "Apple";

		return objData;
	}

}
