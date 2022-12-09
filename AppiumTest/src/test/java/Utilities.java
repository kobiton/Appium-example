import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.android.AndroidDriver;

public class Utilities {
	public void GetSessionId(AndroidDriver driver) {
		try {

			SessionId kobitonSessionId = driver.getSessionId();// getSessionDetails().get("kobitonSessionId").toString();
			System.out.println("kobitonSessionId: " + kobitonSessionId);

			String kobitonSessionId1 = driver.getCapabilities().getCapability("kobitonSessionId").toString();
			System.out.println("kobitonSessionId: " + kobitonSessionId1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void GetLogs(RemoteWebDriver driver) {

		try {

			Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();

			System.out.println(logTypes);

			
			for(String x:logTypes)
			{
				LogEntries logEntries = driver.manage().logs().get(x);
				List<LogEntry> l1 = logEntries.getAll();
				for (int i = 0; i < l1.size(); i++) {
					System.out.println("Log: " + l1.get(i));
				}
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void SetLanguage(DesiredCapabilities desiredCapabilities,String Language)
	{
		desiredCapabilities.setCapability("locale", Language);		
	}
	
	public void SetLocation(AndroidDriver driver, double d, double e, float Alt) {
		driver.setLocation(new Location(d, e, Alt));
	}

//	public  RemoteWebDriver CreateSession(String kobitonServerUrl)
//	{
//		//String kobitonServerUrl = "https://gyanadeeps:15a9ea3f-38fb-450c-9706-08a72ed71950@api.kobiton.com/wd/hub";
//
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("sessionName", "Automation test session");
//		capabilities.setCapability("sessionDescription", "");
//		capabilities.setCapability("deviceOrientation", "portrait");
//		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("fullReset", false);
//		capabilities.setCapability("captureScreenshots", true);
//		capabilities.setCapability("app", "kobiton-store:v385600");
//		//capabilities.setCapability("app", "kobiton-store:v512397");
//		capabilities.setCapability("groupId", 12170); // Group: AutomationDocs
//		capabilities.setCapability("deviceGroup", "ORGANIZATION");
//		capabilities.setCapability("deviceName", "Galaxy S20+ 5G (Payload Enabled)");
//		capabilities.setCapability("tagName", "");
//		capabilities.setCapability("platformVersion", "12");
//		capabilities.setCapability("platformName", "Android");
//
//		RemoteWebDriver driver = null;
//
//		try {
//			driver = new RemoteWebDriver(new URL(kobitonServerUrl), capabilities);
//			//driver = new AndroidDriver(new URL(kobitonServerUrl), capabilities);
//			String sessionId = driver.getSessionId().toString();
//			System.out.println("kobitonSessionId After session creation: " + sessionId);
//
//			capabilities.setCapability("kobiton:flexCorrect", true);
//			
//			capabilities.setCapability("kobiton::baselineSessionId",sessionId);
//						
//			System.out.println("New capabilities added");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
}
