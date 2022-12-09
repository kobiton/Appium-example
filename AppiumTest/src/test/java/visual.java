
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;

public class visual {

	enum DEVICE_SOURCE_ENUMS {
		KOBITON, OTHER
	}

	public static final String KOBITON_USERNAME = "{kobiton_username}";
	public static final String KOBITON_API_KEY = "{your_api_key}";
	public static final String KOBITON_API_URL = "{https://your-kobiton-api-url}";
	public static final String APPIUM_SERVER_URL = "https://" + KOBITON_USERNAME + ":" + KOBITON_API_KEY
			+ "@{Kobiton-api-url}/wd/hub";
	public static final DEVICE_SOURCE_ENUMS DEVICE_SOURCE = DEVICE_SOURCE_ENUMS.KOBITON;
	public static final int IMPLICIT_WAIT_IN_SECOND = 30;
	public static final int DEVICE_WAITING_MAX_TRY_TIMES = 5;
	public static final int DEVICE_WAITING_INTERVAL_IN_MS = 30000;

	public static String getBasicAuthString() {
		String authString = KOBITON_USERNAME + ":" + KOBITON_API_KEY;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authEncString = new String(authEncBytes);
		return "Basic " + authEncString;
	}

	public static DesiredCapabilities getPixel3Android10DesiredCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("fullReset", true);
		capabilities.setCapability("captureScreenshots", true);
		capabilities.setCapability("newCommandTimeout", 15 * 60);
		capabilities.setCapability("ensureWebviewsHavePages", true);
		capabilities.setCapability("kobiton:ReferenceSessionId", 111910);
		capabilities.setCapability("kobiton:visualValidation", true);
		capabilities.setCapability("app", "kobiton-store:v385600");
		capabilities.setCapability("deviceGroup", "KOBITON");
		capabilities.setCapability("deviceName", "Galaxy S20+ 5G (Payload Enabled)");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("platformName", "Android"); 
		return capabilities;
	}
}
