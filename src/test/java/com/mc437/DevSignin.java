package com.mc437;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mc437.stepdefs.StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DevSignin extends StepDefs {
		
	private static final String rootUrl = "http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/";
	
	@Before
	public void init(){
		File classpathRoot = new File(System.getProperty("user.dir"));
		File chromedriver = new File(classpathRoot, "driver/chromedriver");
		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
		driver = new ChromeDriver();
	}

	@After
	public void tearDown(){
		driver.close();
	}

	@When("Entrar na página login dev$")
	public void openMembro(){
		driver.get(rootUrl + "login");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rememberme")));
	}
	
	@When("^coloco usuário \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void user_pass_input(String user, String password){
		WebElement email = driver.findElement(By.id("username"));
		email.sendKeys(user);
		WebElement senha = driver.findElement(By.id("pass"));
		senha.sendKeys(password);	
		WebElement acessar = driver.findElement(By.tagName("button"));
		acessar.click();
	}
	
	@Then("^sou redirecionado para a página de ([^\"]*)$")
	public void check_page(String url){		
		assertThat(driver.getCurrentUrl().equals(rootUrl + url));
	}
	
	@Then("estou na página do dev ([^\"]*)$")
	public void ownership(String dev){
		WebElement owner = driver.findElement(By.tagName("span"));
		assertThat(owner.getText().equals("Olá " + dev));
	}
	
	@Then("^é mostrada a mensagem de erro (.*)")
	public void check_erro(String message){
		WebElement errorbox = driver.findElement(By.className("alert"));
		assertThat(errorbox.getText().equals(message));
	}

}
