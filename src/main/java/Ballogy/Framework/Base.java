package Ballogy.Framework;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AndroidDriver<AndroidElement> driver;
	
	public static AppiumDriverLocalService service;

	public AppiumDriverLocalService  startServer()
	{
		boolean flag= checkIfServerIsRunnning(4723);
	  if(!flag)
	{

		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	return service;
	}
	
	
	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static AndroidDriver<AndroidElement>capabilities(String App) throws IOException, InterruptedException {
		
		
	    System.getProperty("user.dir");
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\Ballogy\\Framework\\global.properties");   		
		Properties prop=new Properties();
		prop.load(fis);
		prop.get(App);		
		File appDir = new File ("src"); 
		//File app= new File (appDir, "ApiDemos-debug.apk");
		File app= new File (appDir, (String) prop.get(App));
		DesiredCapabilities cap= new DesiredCapabilities(); 
		String device=(String) prop.get("deivce");
		if(device.contains("emulator"))
		{
			startEmulator();
		}
		
	
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device );
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device" );
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	    driver= new AndroidDriver<>(new URL ("http://127.0.0.1:4723/wd/hub") ,cap);
		return driver;
		
	}
	
	public static void getScreenShot(String s) throws IOException 
	{
		
     	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File((System.getProperty("user.dir")+"\\"+s+".png")));
		
		
		
	} 
	
	
	
	
	
	
}
