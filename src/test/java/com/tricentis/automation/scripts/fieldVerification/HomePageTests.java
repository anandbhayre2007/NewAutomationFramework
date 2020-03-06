package com.tricentis.automation.scripts.fieldVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tricentis.automation.driver.Driver;
import com.tricentis.automation.pages.PageHost;

public class HomePageTests extends Driver{
	
	//Global variables
	PageHost pages;
	
	@Test
	public void verifyAutomationlink()
	{
		pages= new PageHost(dr);
		//Verify that we are on home page
		Assert.assertEquals(dr.getTitle(), "Tricentis Vehicle Insurance");
		
		//Click on Automobile link
		pages.homePage.clickAutomobile();
		
		//Verify that enter vehicle data page opened
		Assert.assertEquals(dr.getTitle(), "Enter Vehicle Data");
		
	}
	
	@Test
	public void verifyTrucklink()
	{
		System.out.println("verify Truck Link");
	}
	
	@Test
	public void verifyMotorCyclelink()
	{
		System.out.println("verify MotorCycle Link");	
	}
	
	@Test
	public void verifyCamperlink()
	{
		
	}

}
