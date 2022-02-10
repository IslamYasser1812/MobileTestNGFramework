package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class HomePage extends Utilities {
	
	public HomePage(AppiumDriver<MobileElement> testdriver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}
	
	@AndroidFindBy(accessibility = "Menu. Contains your orders, your account, shop by department, programs and features, settings, and customer service Tab 4 of 4")
	MobileElement skipSignIn;
	
	@AndroidFindBy(accessibility = "Deals")
	MobileElement dealsIcon;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_search_hint_view")
	MobileElement searchField;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	MobileElement searchFieldInput;
	
	public void click_Burger_Menu() {
		skipSignIn.click();
		testdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void click_Deals() {
		dealsIcon.click();
	}
	
	public void search_Amazon(String searchValue) {
		searchField.click();
		searchFieldInput.sendKeys(searchValue);
		keypad_Go(testdriver);
	}

}
