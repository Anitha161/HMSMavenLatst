package parallelMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelMavenclass {
	WebDriver driver;
	String expval;
	String actval;
	@Parameters("browser")
	@BeforeTest
	
	public void setup(String Browser) throws InterruptedException
	{
		if (Browser.equalsIgnoreCase("firefox"))
				{
				
				System.setProperty("webdriver.gecko.driver","G:\\Library\\geckodriver.exe");
		
				driver = new FirefoxDriver();
				}
		else if (Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","G:\\Library\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","G:\\Library\\ieDriverserver.exe");
			driver=new InternetExplorerDriver();
		}
	}
	@Test
	public void login() throws InterruptedException
	{
		driver.navigate().to("http://www.selenium4testing.com/hms");

	this.expval="User Login";
		this.actval= driver.findElement(By.xpath("//h4[@align='center'][contains(.,'User Login')]")).getText();
		if (actval.equalsIgnoreCase(actval))
		{
			System.out.println("Application is opened");		
		}
		else
		{
			System.out.println("application is not opened");
		}
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("user1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("user1");
		
		driver.findElement(By.cssSelector("input.log")).click();
		expval="About Application:";
		actval=driver.findElement(By.xpath("//strong[contains(.,'About Application:')]")).getText();
		if(actval.equalsIgnoreCase(expval))
		{
			System.out.println("Main page is opened");
		}	
		else
		{
			System.out.println("Main page is not opened");
		}
	//	driver.findElement(By.xpath("(//div[contains(@class,'hitarea expandable-hitarea')])[1]")).click();
		driver.findElement(By.linkText("Registration")).click();
		expval="Permanent Registration";
		actval = driver.findElement(By.xpath("//span[contains(.,'Permanent Registration')]")).getText();
		if(actval.equalsIgnoreCase(expval))
		{
			System.out.println("Permanent page is opened");
		}
		else
		{
			System.out.println("Permanent page is not opened");
		}
		Select Patcat= new Select(driver.findElement(By.xpath("//*[@name='PATIENT_CAT']")));
		Patcat.selectByVisibleText("Self");
		Select Tit= new Select(driver.findElement(By.xpath("//select[@name='TITLE']")));
		Tit.selectByIndex(1);
		driver.findElement(By.xpath("//input[@type='text'][@name='PNT_NAME']")).sendKeys("Nagesh");
		driver.findElement(By.xpath("//input[@type='text'][@name='MIDDLE_NAME']")).sendKeys("Kala");
		driver.findElement(By.name("AGE")).sendKeys("15");
		driver.findElement(By.name("SEX")).sendKeys("Female");
		driver.findElement(By.name("MTRL_STATUS")).sendKeys("Single");
		driver.findElement(By.name("RELIGION")).sendKeys("Hindu");
		driver.findElement(By.name("PLANGUAGE")).sendKeys("Arabbi");
		driver.findElement(By.name("ADDRESS1")).sendKeys("uppal");
		driver.findElement(By.name("MOBILE_NO")).sendKeys("0000000000");
		driver.findElement(By.name("EMAIL_ID")).sendKeys("1234@gmail.com");
		driver.findElement(By.name("COUNTRY_CODE")).sendKeys("India");
		driver.findElement(By.name("RELATION")).sendKeys("Brother");
		driver.findElement(By.name("MOTHER_NAME")).sendKeys("Fgjhjgjg");
		driver.findElement(By.name("PAT_IDENTITY")).sendKeys("AAdhar Card");
		driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("abchgh000000");
		driver.findElement(By.name("NATIONALITY")).sendKeys("Britan");
		driver.findElement(By.name("IS_MLC")).sendKeys("No");
		driver.findElement(By.name("EDUCATION")).sendKeys("MCA");
		driver.findElement(By.name("OCCUPATION")).sendKeys("Former");
		driver.findElement(By.name("BLOOD_GRP_CODE")).sendKeys("A+");
		driver.findElement(By.name("CITIZENSHIP")).sendKeys("XXXXXX");
		driver.findElement(By.name("SC_PROOF")).sendKeys("No");
		driver.findElement(By.name("ADDRESS2")).sendKeys("Habsiguda");
		driver.findElement(By.name("ZIP")).sendKeys("543210");
		driver.findElement(By.name("image")).sendKeys("F:\\Flower.jpg");
		driver.findElement(By.name("LAST_NAME")).sendKeys("E");
		driver.findElement(By.name(("DOB"))).sendKeys("19-01-2019");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		actval=driver.switchTo().alert().getText();
		expval="Patient Registration Successfully.";
		if(actval.contains(expval))
		{
			System.out.println("created successfully");
			
		}
		
		else
		{
			System.out.println("already exist");
		}
		driver.switchTo().alert().accept();
	
		//driver.findElement(By.cssSelector("li[class='expandable']")).click();//
		//driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[2]/div")).click();
}
	}

