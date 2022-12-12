//this code is handling exception for timeouts
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class TimeoutPractices {
	@BeforeTest
	public void Setup() {
		System.out.println("Tests Run Started ");
	}

	@Test
	public void Test1() {
		System.out.println("Running Test1");
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
		capabilities.setCapability("deviceName", "Galaxy S20+ 5G (Payload Enabled)");
		capabilities.setCapability("tagName", "");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("kobiton:visualValidation", true);

		RemoteWebDriver driver = null;

		try {
			System.out.println("Creating Driver Test1");
			int cnt=30;
			boolean IsSessionCreated=false;
		
			while(!IsSessionCreated)
			{
				
				try {
					driver = new RemoteWebDriver(new URL(kobitonServerUrl), capabilities);
					IsSessionCreated=true;
					}catch(SessionNotCreatedException snce) {
						IsSessionCreated=false;
						TimeUnit.SECONDS.sleep(30);
															}
				if (cnt<=0) {
					break;
					}
				cnt--;
												
			}
			
			
			// driver = new AndroidDriver(new URL(kobitonServerUrl), capabilities);

			// driver.rotate(ScreenOrientation.LANDSCAPE);

			String sessionId = driver.getSessionId().toString();
			System.out.println("kobitonSessionId After session creation: " + sessionId);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement two = driver.findElement(By.xpath("//android.widget.EditText[@text='Write a task']"));
			two.click();
			// util.GetLogs(driver);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}

	@Test
	void Test2 (){
		System.out.println("Running Test2");
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
		capabilities.setCapability("deviceName", "Galaxy S9+");
		capabilities.setCapability("tagName", "");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("kobiton:visualValidation", true);

		RemoteWebDriver driver = null;

		try {
			System.out.println("Creating Driver Test2");
			driver = new RemoteWebDriver(new URL(kobitonServerUrl), capabilities);
			// driver = new AndroidDriver(new URL(kobitonServerUrl), capabilities);

			// driver.rotate(ScreenOrientation.LANDSCAPE);

			String sessionId = driver.getSessionId().toString();
			System.out.println("kobitonSessionId After session creation: " + sessionId);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement two = driver.findElement(By.xpath("//android.widget.EditText[@text='Write a task']"));
			two.click();
			// util.GetLogs(driver);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("Tests Run finish ");
	}
}
