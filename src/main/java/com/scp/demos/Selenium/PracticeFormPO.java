package com.scp.demos.Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.bcel.classfile.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.scp.utility.InitiazeDrivers;

public class PracticeFormPO {
	
	public Logger log = Logger.getLogger(PracticeFormPO.class);
	
	@FindBy(name="firstname")
	private WebElement firstNameInput;
	
	@FindBy(name="lastname")
	private WebElement lastNameInput;
	
	@FindBy(name="sex")
	private List<WebElement> genderType;
	
	@FindBy(name="exp")
	private List<WebElement> yearOfExp;
	
	@FindBy(id="datepicker")
	private WebElement dateInput;
	
	@FindBy(name="profession")
	private List<WebElement> profession;
	
	@FindBy(id="continents")
	private WebElement continents;
	
	@FindBy(id="selenium_commands")
	private WebElement seleniumCommands;
	
	@FindBy(id="photo")
	private WebElement browseBtn;
	
	

	public void uploadFile(String path) throws AWTException, InterruptedException{
		setFilePathIntoClipBoard(path);////set data into system clipboard
		browseBtn.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	

	private void setFilePathIntoClipBoard(String path) {
		log.info(path);
		StringSelection selection = new StringSelection(path);
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(selection, selection);
	}



	public void fillPracticeForm(String fName,String lName){
		firstNameInput.clear();
		firstNameInput.sendKeys(fName);
		
		lastNameInput.clear();
		lastNameInput.sendKeys(lName);
	}
	
	public void selectGender(String type){
		System.out.println("inside select Gender method" +type);
		
		for (WebElement gender : genderType) {
			if(gender.getAttribute("value").equals(type)){
				gender.click();
				break;
			}
		}
		
	}
	
	public void selectExperience(String value){

		System.out.println("inside selectExperience method" +value);
		
		for (WebElement exp : yearOfExp) {
			if(exp.getAttribute("value").equals(value)){
				exp.click();
				break;
			}
		}
		
	
	}
	
	public void enterDate(String str){
		dateInput.clear();
		dateInput.sendKeys(str);
	}
	
	public void selectProfession(String ...value){
		System.out.println("inside selectProfession method" +value);
		
		for (String str : value) {
			for (WebElement prof : profession) {
				if(prof.getAttribute("value").equals(str)){
					prof.click();
				}
		}
		}
		
		/*
		}*/
	}
	
	public void selectContinents(String countryName){
		Select select = new Select(continents);
		System.out.println(select.isMultiple());
		select.selectByVisibleText(countryName);
		
		//selectbyIndex
		//selectByVisibleText
		//selectByValue
	}
	
	public void selectSeleniumCommands(String ...option){
		Select select = new Select(seleniumCommands);
		System.out.println(select.isMultiple());
		
		for (String selectChoice : option) {
			select.selectByVisibleText(selectChoice);
		}
		
		
	}
	
	
}
