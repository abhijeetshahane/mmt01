package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlightPageObject;
import pageObjects.HomePageObjects;
import utils.Utitity;

public class FlightFunctionalityTest {

WebDriver driver;
HomePageObjects homePageObject;
FlightPageObject flightPageObject;


@Parameters({"myUrl", "myBrowser"})
@BeforeTest
void startApplication(String url, String browser) {
driver = Utitity.luanchBrowser(url, browser);
homePageObject = new HomePageObjects(driver);
flightPageObject = new FlightPageObject(driver);
}

@Test(priority=1)

void verifyDiffrentTripOptions() {
boolean flightFlag = homePageObject.isFlightOptionPresent();
Assert.assertTrue(flightFlag, "Flight Option Displaying");
homePageObject.clickOnFlights();
String actualUrl = driver.getCurrentUrl();
Assert.assertEquals(actualUrl, "https://www.makemytrip.com/flights/", "Flight Page");
boolean oneWayTripFlag = flightPageObject.isOneWayTripCheckBoxIsPresent();
Assert.assertTrue(oneWayTripFlag, "One Way Trip is Displaying");
boolean roundTripFlag = flightPageObject.isRoundTripCheckBoxIsPresent();
Assert.assertTrue(roundTripFlag, "Round Trip is Displaying");
boolean multiCityFlag = flightPageObject.isMultiCityTripCheckBoxIsPresent();
Assert.assertTrue(multiCityFlag, "Multi City Trip is Displaying");
}

@Test(priority=2)
void verifyDefaultTripSelection() {
String actualAttribute = flightPageObject.grabAttributeOfoneWayTrip("class");
Assert.assertEquals(actualAttribute, "Selected", "By Default OneWayTrip Option is  Selected");
}

@AfterTest

void quitBrowser() {
driver.quit();
}




}
