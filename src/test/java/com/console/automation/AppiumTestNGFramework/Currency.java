package com.console.automation.AppiumTestNGFramework;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BurgerPage;
import pageObjects.HomePage;
import pageObjects.WelcomePage;
import resources.Utilities;

public class Currency extends Utilities {

	@BeforeClass
	public void initialize() throws InterruptedException, IOException {
		driverInit();
	}
	
	@Test(description = "Verify User goto home page")
	public void Test1() throws IOException, InterruptedException {
		WelcomePage wp = new WelcomePage(testdriver);
		wp.click_Skip_Sign_In();
	}
	
	@Test(description = "Verify User selects shop by department from burger menu")
	public void Test2() {
		HomePage hp = new HomePage(testdriver);
		hp.click_Burger_Menu();
	}
	
	@Test(description = "Verify User click on Settings")
	public void Test3() throws InterruptedException {
		BurgerPage bp = new BurgerPage(testdriver);
		bp.click_Settings();
	}

	@Test(description = "Verify ser select Country and Language")
	public void Test4() throws InterruptedException {
		BurgerPage bp = new BurgerPage(testdriver);
		bp.click_CountryLanguageSettings();
	}

	@Test(description = "Verify User changes currency from USD to AED")
	public void Test5() {
		// to be implemented
	}

	@Test(description = "Selected currency displayed for Deals and Promotions products")
	public void Test6() {
		// to be implemented

	}
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		driverClosure();
	}

}
