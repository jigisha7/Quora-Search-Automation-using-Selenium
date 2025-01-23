/*TO CHECK QUORA SITE WITH INVALID STRING*/
package selenium1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;

public class Quora_invalid_search {
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

	public boolean search(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//*[@placeholder='Search for questions, people, and topics']"));
		element.sendKeys("99ACbd");

		try{Thread.sleep(4000);
		}catch(Exception e){}

		driver.findElement(By.xpath("//*[@id='selector-option-0']/div/div")).click();

		try{Thread.sleep(4000);
		}catch(Exception e){}

		String result=driver.findElement(By.xpath("//div[@class='q-box qu-borderBottom qu-p--medium']")).getText();
		StringTokenizer tokens = new StringTokenizer(result, ".");

		String result1=(String)tokens.nextElement();

		WebElement ele=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div/button"));
		String result2=ele.getText();

		if((result1.equals("We couldn't find any results for '99ACbd'"))&& (result2.equals("Add Question")))
			return true;
		else
			return false;
	}

	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}

	public static void main(String[] args) throws Exception
	{
		Quora_invalid_search obj=new Quora_invalid_search();
		String brow1="Firefox";
		String brow2="Chrome";

		WebDriver dr=obj.setWebDriver(brow1);
		obj.getSite(dr);
		boolean res1=obj.search(dr);
		obj.takeScreenShot(dr);
		obj.closeBrowser(dr);

		WebDriver drr=obj.setWebDriver(brow2);
		obj.getSite(drr);
		boolean res2=obj.search(drr);
		obj.takeScreenShot(drr);
		obj.closeBrowser(drr);

		if(res1==true &&res2==true)
			System.out.println("**********PASS**********");
		else
			System.out.println("**********FAIL**********");
	}
}
