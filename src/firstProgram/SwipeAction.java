package firstProgram;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SwipeAction extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		//android.widget.RadialTimePickerView$RadialPickerTouchHelper
		
		driver.findElementByXPath("//*[@content-desc='9']").click();
		TouchAction ta = new TouchAction(driver);
		
		WebElement firstClick = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement SecondClick = driver.findElementByXPath("//*[@content-desc='45']");
		
		ta.longPress(longPressOptions().withElement(element(firstClick)).withDuration(ofSeconds(2))).moveTo(element(SecondClick)).release().perform();
		
	}

}
