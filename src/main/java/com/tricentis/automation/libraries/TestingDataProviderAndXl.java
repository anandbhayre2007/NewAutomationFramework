package com.tricentis.automation.libraries;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tricentis.automation.configuration.Config;

public class TestingDataProviderAndXl {
	
	@Test(dataProvider="getData")	
	public void test1(String username1, String password1)
	{
		SoftAssert asser=new SoftAssert();
		System.out.println("Enter "+username1+" in username field");
		System.out.println("Enter "+password1+" in password field");
		
		//Assert.assertEquals(username1, "anand" ); -- Hard Assertion
		asser.assertEquals("Anand", "iiugsdig");
		
		asser.assertEquals("Anand1", "iiugsdig");
		
		
		asser.assertEquals("Anand2", "iiugsdig");
		
		asser.assertEquals("Anand3", "iiugsdig");
		
		asser.assertAll();
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException
	{
		
		Xls_ReaderForXLSX xl= new Xls_ReaderForXLSX(Config.testDataPath);
		
		int rows=xl.getRowCount("Sheet1");
		int cols=xl.getColumnCount("Sheet1");
		
		String[][] data=  new String[rows][cols];
		
		for(int r=0; r<rows; r++)
		{
			for(int c=0; c<cols; c++)
			{
				data[r][c]=xl.getCellData("Sheet1", r, c);
			}
		}
		
		return data;		
	}

}
