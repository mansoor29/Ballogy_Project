package Ballogy.Framework;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import PageObjects.Elements;
import io.appium.java_client.TouchAction;
import static  io.appium.java_client.touch.TapOptions.tapOptions;
import static  io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Utilities 

{
	void tap ( WebElement e, AndroidDriver<AndroidElement> driver ) throws IOException
	{
			
		TouchAction t= new TouchAction(driver);
		t.tap(tapOptions().withElement(element(e))).perform();	
		System.out.print("In Utiltitles class Tap method");
				
	}
	void longpress(int sec, WebElement e, AndroidDriver<AndroidElement> driver  )
	{
		TouchAction t= new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(sec))).release().perform();   
		System.out.print("In Utiltitles class LongPress method");
	}
	
	
	
	
	
	
	
	
	
}
