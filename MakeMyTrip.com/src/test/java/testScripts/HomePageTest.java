package testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;

public class HomePageTest {                                                                                                                                                                                                                                    
	WebDriver driver;
	HomePageObjects hpo;
	@Parameters({"myUrl","myBrowser"})
	@BeforeTest
	public void launchBrowser(String url, String Browser) {
	if(Browser.equalsIgnoreCase("chrome")) {
    	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\admin\\Downloads\\edgedriver_win32\\msedgedriver.exe");
	driver = new EdgeDriver();
	}
	 driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(url);
    }
    @BeforeClass
    void initializeObjects() {
    hpo = new HomePageObjects(driver);
    }

    @Test(priority=2)
    void logoTest() {
    boolean logoFlag = hpo.isFlightOptionPresent();
    Assert.assertTrue(logoFlag, "Page Verified");
    }
  
    @Parameters("myUrl")
    @Test(priority=1)
    void urlTest(String expectedUrl) {
    String actualUrl =  driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl, "URL Test Successful");
    }

    @Test(priority=3)
    void verifyFlightsOption() {
    boolean flightsFlag = hpo.isFlightOptionPresent();
    Assert.assertTrue(flightsFlag, "Flight option is Displaying");
    hpo.clickOnFlights();
    String actualUrl =  driver.getCurrentUrl();
    Assert.assertEquals(actualUrl," https://www.makemytrip.com/flights/", "Flights Page Verifyed");
    }
    
    @AfterTest
    void quiteBrowser() {
    driver.quit();
    }
    
    
    
    
    
    
}
