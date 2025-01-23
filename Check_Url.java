/*TO CHECK URL IS ACCESSIBLE OR NOT*/
package selenium1;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Check_Url
{
	static WebDriver driver;

	public WebDriver setWebDriver(String drvr)
	{
		if(drvr.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
	}

	public void getSite(WebDriver driverr)
	{
		driverr.get("https://www.quora.com/profile/Quora");
	}

	public void takeScreenShot(WebDriver driver) throws Exception
	{
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	//Saving the screenshot in desired location
	File source = screenshot.getScreenshotAs(OutputType.FILE);
	//Path to the location to save screenshot
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
	//FileUtils.copyFile(source, new File("C:\\Users\\Dell\\Downloads\\SELENIUM_course\\mini_pro_ss\\"+sdf.format(d)+".png"));
	FileUtils.copyFile(source, new File("C:\\Users\\Dell\\Desktop\\FINAL_MINI_PROJECT\\All_ScreenShots\\"+sdf.format(d)+".png"));
	}

	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	public static void main(String[] args) throws Exception
	{
		Check_Url obj=new Check_Url();

		String brow1="Firefox";
		String brow2="Chrome";

		WebDriver dr=obj.setWebDriver(brow1);
		obj.getSite(dr);
		obj.takeScreenShot(dr);
		obj.closeBrowser(dr);

		WebDriver drr=obj.setWebDriver(brow2);
		obj.getSite(drr);
		obj.takeScreenShot(drr);
		obj.closeBrowser(drr);
	}
}