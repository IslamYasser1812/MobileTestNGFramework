package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class PDPage extends Utilities {
	AppiumDriver<MobileElement> driver;

	public PDPage(AppiumDriver<MobileElement> testdriver) {
		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Image[@resource-id=\"main-image\"]")
	MobileElement mainImage;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"corePriceDisplay_mobile_feature_div\"]/android.view.View")
	MobileElement productPrice;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"availability\"]")
	MobileElement productAvailability;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"add-to-cart-button\"]")
	MobileElement addToCart_Btn;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"attach-default-atc-confirm\"]")
	MobileElement cartConfirmation;
	
	public void swipeImage() {
		swipeRightToLeftOnElement(mainImage.getCenter().y);
	}

	public String productPrice() {
		return productPrice.getText();
	}
	
	public String checkProductAvailability() throws InterruptedException {
		scrollUsingTouchActionsByElements(productAvailability);
		return productAvailability.getText();
	}
	
	public void click_Add_To_Cart() throws InterruptedException {
		scrollUsingTouchActionsByElements(addToCart_Btn);
		addToCart_Btn.click();
	}
	
	public Boolean check_Cart_Added_Confirmation() {
		return verify_element_Present(cartConfirmation);
	}

}
