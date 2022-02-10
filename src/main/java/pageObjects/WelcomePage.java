package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage extends resources.Utilities{
	AppiumDriver<MobileElement> driver;
	public WelcomePage(AppiumDriver<MobileElement> testdriver) 
	{
		this.driver= testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}
	//android.widget.Button[@text="Skip sign in"]
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	MobileElement skipSignIn;
	
	public void click_Skip_Sign_In() {
		waitForVisibility(skipSignIn);
		skipSignIn.click();
	}

}
