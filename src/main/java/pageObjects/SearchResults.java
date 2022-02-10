package pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class SearchResults extends Utilities {
	AppiumDriver<MobileElement> driver;

	public SearchResults(AppiumDriver<MobileElement> testdriver) {
		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@text=\"RESULTS\"]/following-sibling::android.view.View/android.view.View[1]//android.widget.Image")
	List<MobileElement> productsImage;

	
	public void select_First_Product() {
		waitForVisibility(productsImage.get(0));
		productsImage.get(0).click();
		
	}
	
}
