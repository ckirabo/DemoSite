package com.qa.clare.DemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input" )
	private WebElement usernameL;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passwordL;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement loginButton;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement status;
	

	public String logInMethod(String username, String password) throws InterruptedException {
		

		usernameL.click();
		usernameL.sendKeys(username);

		Thread.sleep(2000);
		
		passwordL.click();
		passwordL.sendKeys(password);
		
		loginButton.click();
	    
		
		return status.getText();
	}
	
}
