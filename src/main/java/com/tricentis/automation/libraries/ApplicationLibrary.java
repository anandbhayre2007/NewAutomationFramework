package com.tricentis.automation.libraries;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.tricentis.automation.driver.Driver;

public class ApplicationLibrary {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		ChromeDriver dr= new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://sampleapp.tricentis.com/101/");
						
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		String screenshotName="D://Anand2.png";
		FileHandler.copy(scrFile, new File(screenshotName));
	}
}
