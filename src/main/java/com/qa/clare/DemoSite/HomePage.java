package com.qa.clare.DemoSite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserlink;
	

	public void goToAddUser(WebDriver driver)  {

		
		WebElement myWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(addUserlink));
		myWait.click();
	
		
	}
	
	
}
