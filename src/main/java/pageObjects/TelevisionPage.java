package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class TelevisionPage extends Utilities{
	AppiumDriver<MobileElement> driver;
	public TelevisionPage(AppiumDriver<MobileElement> testdriver) 
	{
		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}
	
	@AndroidFindBy(xpath  = "//android.view.View[@content-desc=\"See all results\"]")
	MobileElement seeAllResults;
	
	public void click_Television_Category() throws InterruptedException {
		scrollUsingTouchActionsByElements(seeAllResults);
		waitForVisibility(seeAllResults);
		seeAllResults.click();
	}

}
