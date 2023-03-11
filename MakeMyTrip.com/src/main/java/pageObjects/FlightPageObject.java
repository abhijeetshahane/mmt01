package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPageObject {

	@FindBy  (xpath = "//li[@data-cy='oneWayTrip']")
	private WebElement oneWayTripCheckbox;
	
	@FindBy  (xpath = "//li[@data-cy='roundTrip']")
	private WebElement roundTripCheckbox;
	
	@FindBy  (xpath = "//li[@data-cy='mulitiCityTrip']")
	private WebElement multicityTripCheckbox;
	
	
	public FlightPageObject(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public boolean isOneWayTripCheckBoxIsPresent(){
	return oneWayTripCheckbox.isDisplayed();
	}

    public boolean isRoundTripCheckBoxIsPresent() {
    return roundTripCheckbox.isDisplayed();
    }

    public boolean isMultiCityTripCheckBoxIsPresent() {
	return multicityTripCheckbox.isDisplayed();  
	}

    public String grabAttributeOfoneWayTrip(String attribute) {
    return oneWayTripCheckbox.getAttribute(attribute);
    }




}