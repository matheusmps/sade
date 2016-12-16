package com.mc437;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mc437.stepdefs.StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeScenario extends StepDefs {
	
	@Before
 	public void init(){
 		File classpathRoot = new File(System.getProperty("user.dir"));
 		File chromedriver = new File(classpathRoot, DRIVER_URL);
 		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
 		driver = new ChromeDriver();
 	}
 	
 	@After
 	public void tearDown(){
 		driver.close();
 	}
	
	
	@When("^Entrar na página '(.*)'$")
 	public void open(String url){
 		driver.get(url);
 		
 		WebDriverWait wait = new WebDriverWait(driver, 5);
 //		wait.until(ExpectedConditions.textToBePresentInElement(By.tagName("id"), "cadastro_cv"));
 	}
 
 	@Then("^ela contém 2 links '(.*)', '(.*)'$")
 	public void contains_correct_buttons(String idButton1, String idButton2){
 		boolean found = false;
 		
 		found = isElementInThePage(idButton1);
 		assert found;
 		
 		found = isElementInThePage(idButton2);
 		assert found;
 	}
 	
 	public boolean isElementInThePage(String elementId){
 		WebElement element = driver.findElement(By.id(elementId));
 		return element != null;
 	}
 	
 	@When("^click no elemento '(.*)'$")
 	public void click_button(String id){
 		WebElement element = driver.findElement(By.id(id));
 		element.click();
 		WebDriverWait wait = new WebDriverWait(driver, 5);
 	}
 	
 	@Then("^estou na pagina '(.*)'$")
 	public void check_page(String url){
 		boolean isCorrectPage = driver.getCurrentUrl().equals(url);
 		assert isCorrectPage;
 	}	
}