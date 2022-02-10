package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class ElectronicsPage extends Utilities{
//	AppiumDriver<MobileElement> driver;
	public ElectronicsPage(AppiumDriver<MobileElement> testdriver) 
	{
//		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,\"contentGrid\")]//android.view.View/android.view.View[@text=\"Televisions\"]")
	MobileElement televisionCategory;
	
	public void click_Television_Category() throws InterruptedException {
//		scrollUsingTouchActionsByElements(televisionCategory);
		scrollElementClickableAndClick(televisionCategory);
		
//		waitForVisibility(televisionCategory);
//		televisionCategory.click();
	}

}
