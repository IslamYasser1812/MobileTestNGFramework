package com.console.automation.AppiumTestNGFramework;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BurgerPage;
import pageObjects.ElectronicsPage;
import pageObjects.HomePage;
import pageObjects.TelevisionPage;
import pageObjects.WelcomePage;
import resources.Utilities;

public class Category extends Utilities {
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

	@Test(description = "Verify User choose category Electronics and sub category TV and Video")
	public void Test3() throws InterruptedException {
		BurgerPage bp = new BurgerPage(testdriver);
		bp.click_Department_Category("Electronics");
		bp.click_Electronics_SubCategory();
	}

	@Test(description = "Verify User Filter with smart TV")
	public void Test4() throws InterruptedException {
		ElectronicsPage ep = new ElectronicsPage(testdriver);
		ep.click_Television_Category();
	}

	@Test(description = "Verify User clicks show results")
	public void Test5() throws InterruptedException {
		TelevisionPage tp = new TelevisionPage(testdriver);
		tp.click_Television_Category();

	}

	@Test(description = "Verify Total number of results match the total displayed in filter")
	public void Test6() {
		// To be implemented

	}
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		driverClosure();
	}
}
