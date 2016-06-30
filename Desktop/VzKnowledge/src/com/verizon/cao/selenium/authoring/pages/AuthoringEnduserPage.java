package com.verizon.cao.selenium.authoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Authoring;

public class AuthoringEnduserPage implements Authoring {
	
	private static WebElement element = null;
	static String object_path = null;
	
	public static WebElement lnktaxonomy(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnktaxonomy));

		return element;

	}
	public static WebElement elemyfeed(WebDriver driver)
	{
		element = driver.findElement(By.xpath(elemyfeed));

		return element;

	}
	public static WebElement eledocnum(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eledocnum));

		return element;

	}
	public static WebElement lnkAlerts(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkAlerts));

		return element;

	}
	public static WebElement eleAlerts(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleAlerts));

		return element;

	}
	}
