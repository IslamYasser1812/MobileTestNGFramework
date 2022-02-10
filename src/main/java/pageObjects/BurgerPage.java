package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class BurgerPage extends Utilities {
	AppiumDriver<MobileElement> driver;

	public BurgerPage(AppiumDriver<MobileElement> testdriver) {
		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}

//	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[contains(@text,\"Electronics\")]")
//	MobileElement electronicsDepartment;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"theme-card-press\"]/android.view.ViewGroup/android.widget.TextView")
	List<MobileElement> Departments;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"sbceal\"]")
	MobileElement electronicsSubCategory;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"c_se\"]")
	MobileElement settings_Btn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Country & Language\"]")
	MobileElement country_Language_Settings;

	public void click_Department_Category(String department) throws InterruptedException {
		for (MobileElement mobileElement : Departments) {
			if (mobileElement.getText().contains(department)) {
				scrollUsingTouchActionsByElements(mobileElement);
				waitForVisibility(mobileElement);
				mobileElement.click();
				break;
			} else {
				// Log.info("");
			}
		}

	}

	public void click_Electronics_SubCategory() throws InterruptedException {
		scrollUsingTouchActionsByElements(electronicsSubCategory);
		electronicsSubCategory.click();
//		testdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void click_Settings() throws InterruptedException {
		scrollUsingTouchActionsByElements(settings_Btn);
		settings_Btn.click();
	}

	public void click_CountryLanguageSettings() throws InterruptedException {
		scrollUsingTouchActionsByElements(country_Language_Settings);
		country_Language_Settings.click();
	}

}
