package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class BaseClass {

	AppiumDriver driver;

	@BeforeTest
	public void setup() {

		try {

			DesiredCapabilities cap = new DesiredCapabilities();
			
			String platform = "Android";
			
			if (platform.equalsIgnoreCase("Android")) {

			cap.setCapability("appium:deviceName", "OPPO F11");
			cap.setCapability("appium:udid", "HISO5PUS8PJBLJAU");
			cap.setCapability("appium:platformName", "Android");
			cap.setCapability("appium:platformVersion", "11");

			cap.setCapability("noReset", true);

			cap.setCapability("appium:app",
					"C:\\Users\\ioraif\\eclipse-workspace\\GoChatTesting\\src\\test\\resources\\Builds\\gochat_staging_channels_phase2_292.apk");

		}
			else if (platform.equalsIgnoreCase("iOS")) {
				
				
				
			}
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver(url, cap);

		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}

	@Test
	public void openGoChat() {
		
		WebElement invokedone= (WebElement) 
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Assert.assertEquals(invokedone.getText(), "Get Started", "Failed to start GoChat");
		
		System.out.println("GoChat Started....");
	}

	@AfterSuite
	public void teardown() {
		
	}

}
