
//This code is to get logs
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Logs {

	public static AppiumDriver apDriver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getLogs();

	}

	public static void getLogs() {

		String kobitonServerUrl = "https://gyanadeeps:15a9ea3f-38fb-450c-9706-08a72ed71950@api.kobiton.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("captureScreenshots", true);

		capabilities.setCapability("app", "kobiton-store:v385600");

		capabilities.setCapability("groupId", 12170); // Group: AutomationDocs
		capabilities.setCapability("deviceGroup", "ORGANIZATION");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "Galaxy S20+ 5G (Payload Enabled)");
		// The tag is used for finding devices and the user can input only one tag.
		// For example, the data value will be inputted: tagName="TagName1"
		capabilities.setCapability("tagName", "");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("platformName", "Android");

		// setup(capabilities,2);
		Utilities util = new Utilities();
		RemoteWebDriver driver = null;

		try {
			driver = new RemoteWebDriver(new URL(kobitonServerUrl), capabilities);

			String sessionId = driver.getSessionId().toString();
			System.out.println("kobitonSessionId After session creation: " + sessionId);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("//android.widget.EditText[@text='Write a task']"));
			element.click();

			util.GetLogs(driver);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();

	}

}
