package Ballogy.Framework;
import java.net.MalformedURLException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Elements;
import io.appium.java_client.TouchAction;
import static  io.appium.java_client.touch.TapOptions.tapOptions;
import static  io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
public class Gestures extends Base



{

	//Elements h= new Elements(driver);
	//Utilities u= new Utilities();

	@Test
	public void Gestures() throws IOException, InterruptedException
	
	{
		// TODO Auto-generated method stub
		
		service= startServer();
		 AndroidDriver<AndroidElement> driver= capabilities("ApiDemosApp");		
		Elements h= new Elements(driver);
		Utilities u= new Utilities();
		h.views.click();		 	
		u.tap(h.drag_drop, driver );
		u.longpress(2, h.firstindex, driver);
	    service.stop();
	}
	
	@Test
	public void Accessablilty() throws IOException, InterruptedException 
	{
		service= startServer();
	    AndroidDriver<AndroidElement> driver= capabilities("ApiDemosApp");		
		Elements h= new Elements(driver);
		Utilities u= new Utilities();
		u.tap(h.accessability, driver);
		 service.stop();
		
		
		
		
	}
	
	
	
	
	 
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		   
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
		
		
		
	}
	
	
	
	

}
