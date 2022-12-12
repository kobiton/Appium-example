//This code is for getting session id of device iphone XS max
import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.ios.IOSDriver;

public class GetSessionId {

	public static void main(String[] args) {
		
		createSession();

	}

	public static void createSession() {

		
		String kobitonServerUrl = "https://gyanadeeps:15a9ea3f-38fb-450c-9706-08a72ed71950@api.kobiton.com/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("captureScreenshots", true);
		
		capabilities.setCapability("app", "kobiton-store:v414644");
		
		capabilities.setCapability("groupId", 12170); // Group: AutomationDocs
		capabilities.setCapability("deviceGroup", "ORGANIZATION");
		
		capabilities.setCapability("deviceName", "iPhone XS Max");
	
		capabilities.setCapability("tagName", "");
		capabilities.setCapability("platformVersion", "15.6");
		capabilities.setCapability("platformName", "iOS"); 

		RemoteWebDriver driver;
		try {
			
			driver = new RemoteWebDriver(new URL(kobitonServerUrl), capabilities);

			SessionId kobitonSessionId = driver.getSessionId();
			System.out.println("kobitonSessionId: " + kobitonSessionId);

			String kobitonSessionId1 = driver.getCapabilities().getCapability("kobitonSessionId").toString();
			System.out.println("kobitonSessionId: " + kobitonSessionId1);

		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
}
