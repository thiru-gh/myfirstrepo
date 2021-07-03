package firstProgram;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class RealDeviceBase {

	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;
		
		File file = new File("src");
		File source = new File(file,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(device.equals("emulator")) {
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Thiruemulator");			
		}
		else if(device.equals("real")){
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}	
		
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;

	}

}
