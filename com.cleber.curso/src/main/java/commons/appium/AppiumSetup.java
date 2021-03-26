package commons.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import commons.start.LocalVariables;
import commons.start.StartParameters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumSetup {
	
	public static void  setConfigMobile(StartParameters sttp) throws MalformedURLException {

		sttp.setCapabilities(new DesiredCapabilities());
		sttp.getCapabilities().setCapability("deviceName", sttp.getProp().getProperty("devicename"));
		sttp.getCapabilities().setCapability("udid", sttp.getProp().getProperty("udid"));
		sttp.getCapabilities().setCapability("platformName", sttp.getProp().getProperty("platformName"));
		sttp.getCapabilities().setCapability("platformVersion", sttp.getProp().getProperty("platformVersion"));
		sttp.getCapabilities().setCapability("noReset", sttp.getProp().getProperty("noReset"));
		// sttp.getCapabilities().setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		sttp.getCapabilities().setCapability(MobileCapabilityType.APP,"C:\\Users\\cbl79\\Desktop\\Projetos\\Mobile\\com.cleber.curso\\src\\main\\resources\\CTAppium_1_2.apk");

		// sttp.getCapabilities().setCapability("appPackage", sttp.getProp().getProperty("appPackage"));
		// sttp.getCapabilities().setCapability("appActivity", sttp.getProp().getProperty("appActivity"));
		sttp.getCapabilities().setCapability("automationName", sttp.getProp().getProperty("automationName"));
		sttp.setUrlAppiumServer(new URL(sttp.getProp().getProperty("urlAppium")));
		sttp.setDriver(new AndroidDriver<MobileElement>(sttp.getUrlAppiumServer(), sttp.getCapabilities()));
		
		System.out.println("Aplicativo start OK !!!!");

	}
	
	static public void clickCoordenates(StartParameters sttp, LocalVariables lv, Integer x, Integer y) throws Throwable {

		TouchAction touchAction = new TouchAction(sttp.getDriver());

		touchAction.tap(PointOption.point(x,y)).perform();	
		
	}
	
	public static void moveScroll(StartParameters sttp, LocalVariables lv, Integer startX, Integer startY, Integer endX, Integer endY) {
		
		
		TouchAction action = new TouchAction(sttp.getDriver()).longPress(PointOption.point(startX,startY)).moveTo(PointOption.point(endX, endY)).release();
		action.perform();
	}
	

}
