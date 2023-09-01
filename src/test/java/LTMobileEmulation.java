import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LTMobileEmulation {
    public static final String USERNAME = "";
    public static final String ACCESS_KEY = "";
    public static final String LT_GRID_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

    public static void main(String[] args) throws Exception {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 6");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation",mobileEmulation);
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        chromeOptions.setCapability("browserName", "Chrome");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "");
        ltOptions.put("accessKey", "");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("browserVersion", "114.0");
        ltOptions.put("build", "Mobile Emulation");
        ltOptions.put("test", "Test 1");
        ltOptions.put("w3c", true);
        chromeOptions.setCapability("LT:Options", ltOptions);

        WebDriver driver = new RemoteWebDriver(new URL(LT_GRID_URL), chromeOptions);

        driver.get("https://whatismyviewport.com/");
        Thread.sleep(10000);

        driver.quit();
    }
}
