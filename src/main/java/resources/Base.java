package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public static AppiumDriverLocalService service;

	// To start Appium server using code
	public AppiumDriverLocalService startServer() throws IOException, InterruptedException {
		Thread.sleep(5000);
		Boolean flag = checkIfServiceIsRunning(4723);
		if (!flag) {
//			String[] cmd = {"source ~/.bash_profile"};
////			Runtime.getRuntime().exec(cmd);
////			Runtime.getRuntime().exec("cd");
//			Process pr = new ProcessBuilder("/bin/bash", "-c", ". env.sh; " + cmd).start();
////			Runtime.getRuntime().exec("source ~/.bash_profile");
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
							.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
							.withIPAddress("127.0.0.1").usingPort(4723));
			service.start();
		}
		return service;
	}

	public static Boolean checkIfServiceIsRunning(int port) {
		Boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	// To Start Emulator
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/java/resources/startEmulator.sh");
		Thread.sleep(20000);
	}

	public static AppiumDriver<MobileElement> DesiredCapabilities() throws IOException, InterruptedException {
		// Desired Capabilities4723
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/global.properties");
		Properties properties = new Properties();
		properties.load(fis);

		AppiumDriver<MobileElement> driver;

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("platformVersion"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("deviceName"));
		
		// for starting Emulator
//		if (properties.getProperty("deviceName").contains("EM")) {
//			startEmulator();
//		}

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, properties.getProperty("commandTimeOut"));
		cap.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + properties.getProperty("application"));

		driver = new AndroidDriver<>(new URL(properties.getProperty("appiumURL")), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	

}
