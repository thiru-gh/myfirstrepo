package firstProgram;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Gestures extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		TouchAction tact = new TouchAction(driver);
		WebElement expandlist = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		tact.tap(tapOptions().withElement(element(expandlist))).perform();
		
		//1. Custom Adapter
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement pn =	driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		tact.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		//android:id/title
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
	}

}
