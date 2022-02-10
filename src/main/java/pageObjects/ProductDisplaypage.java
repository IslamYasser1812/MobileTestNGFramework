package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class ProductDisplaypage extends Utilities {
	AppiumDriver<MobileElement> driver;

	public ProductDisplaypage(AppiumDriver<MobileElement> testdriver) {
		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}

	@AndroidFindBy(accessibility = "Shop by category")
	MobileElement categoryFilter;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"grid_presets_sheet_content\"]//android.view.View/android.widget.Button")
	List<MobileElement> categoryIcons;

	public void click_Category_Filter() {
		waitForVisibility(categoryFilter);
		categoryFilter.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void select_Category_Icon(String category) {
		waitForVisibility(categoryIcons.get(0));
		for (MobileElement mobileElement : categoryIcons) {
			if(mobileElement.getText().contains(category)) {
				mobileElement.click();
				break;
			}
		}
	}
}
