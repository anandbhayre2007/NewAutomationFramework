package com.tricentis.automation.pages;

import org.openqa.selenium.WebDriver;

import com.tricentis.automation.pages.AutomobilePages.Automobile;
import com.tricentis.automation.pages.HomePage.HomePage;

public class PageHost{

	
	public Automobile automobile;
	public HomePage homePage;
	
	public PageHost(WebDriver dr)
	{
		automobile= new Automobile(dr);
		 homePage= new HomePage(dr);
	}
}
