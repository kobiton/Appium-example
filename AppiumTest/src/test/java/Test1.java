import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.AppiumDriver;
public class Test1 {

	public static AppiumDriver apDriver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logs();
	
	}
	
	public static void Logs()
	{		
		
				
		

String kobitonServerUrl = "https://gyanadeeps:15a9ea3f-38fb-450c-9706-08a72ed71950@api.kobiton.com/wd/hub";

DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("sessionName", "Automation test session");
capabilities.setCapability("sessionDescription", "");
capabilities.setCapability("deviceOrientation", "portrait");
capabilities.setCapability("noReset", true);
capabilities.setCapability("fullReset", false);
capabilities.setCapability("captureScreenshots", true);
// The maximum size of application is 4000MB
// By default, HTTP requests from testing library are expired
// in 2 minutes while the app copying and installation may
// take up-to 30 minutes. Therefore, you need to extend the HTTP
// request timeout duration in your testing library so that
// it doesn't interrupt while the device is being initialized.
capabilities.setCapability("app", "kobiton-store:v385600");

// The given team is used for finding devices and the created session will be visible for all members within the team.
capabilities.setCapability("groupId", 12170); // Group: AutomationDocs
capabilities.setCapability("deviceGroup", "ORGANIZATION");
// For deviceName, platformVersion Kobiton supports wildcard
// character *, with 3 formats: *text, text* and *text*
// If there is no *, Kobiton will match the exact text provided
capabilities.setCapability("deviceName", "Galaxy S20+ 5G (Payload Enabled)");
// The tag is used for finding devices and the user can input only one tag. 
// For example, the data value will be inputted: tagName="TagName1"
capabilities.setCapability("tagName", "");
capabilities.setCapability("platformVersion", "12");
capabilities.setCapability("platformName", "Android"); 

//capabilities.setCapability("kobiton:flexCorrect", true);

//capabilities.setCapability("kobiton:baselineSessionId",4928134);

//	S
		RemoteWebDriver driver=null;
		try {
			driver = new RemoteWebDriver(new URL(kobitonServerUrl),capabilities);
			
			SessionId kobitonSessionId = driver.getSessionId();// getSessionDetails().get("kobitonSessionId").toString(); 
			System.out.println("kobitonSessionId: " + kobitonSessionId);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String kobitonSessionId1 = driver.getCapabilities().getCapability("kobitonSessionId").toString(); 
			System.out.println("kobitonSessionId: " + kobitonSessionId1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//apDriver= new AppiumDriver(url,capabilities);		
		try {
			
			Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();

			System.out.println(logTypes);

			LogEntries logEntries = driver.manage().logs().get("client");
			List<LogEntry> l1= logEntries.getAll();
			System.out.println("Log 1: " + l1.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		driver.quit();
		
	}
	

}
