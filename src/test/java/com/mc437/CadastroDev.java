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

public class CadastroDev extends StepDefs{
	
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
	
	@When("^Entrar na página '(.*)'$")
	public void open(String url){
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.textToBePresentInElement(By.tagName("id"), "cadastro_cv"));
	}
	
	WebElement name = driver.findElement(By.id("name"));
	WebElement tel = driver.findElement(By.id("phone"));
	WebElement cp_f = driver.findElement(By.id("cpf"));
	WebElement address = driver.findElement(By.id("address"));
	WebElement e_mail = driver.findElement(By.id("email"));
	WebElement pass = driver.findElement(By.id("pass"));
	WebElement cadastrar = driver.findElement(By.id("cadastrar"));
	
	
	@When("^coloco nome \"([^\"]*)\" telefone \"([^\"]*)\" cpf \"([^\"]*)\" endereco \"([^\"]*)\" email \"([^\"]*)\" senha \"([^\"]*)\"$")
	public void user_pass_input(String nome, String telefone, String cpf, String endereco, String email, String senha){
		name.sendKeys(nome);
		tel.sendKeys(telefone);
		cp_f.sendKeys(cpf);
		address.sendKeys(endereco);
		e_mail.sendKeys(email);
		pass.sendKeys(senha);	
		cadastrar.click();
	}
	
	
	@Then("^sou redirecionado para a página \"([^\"]*)\"$")
	public void chek_page(String url){		
		boolean isCorrectPage = driver.getCurrentUrl().equals(url);
		assert isCorrectPage;
	}
	
	@Then("^é mostrada a mensagem de erro (.*)")
	public void chek_erro(String id){
		WebElement errorbx = driver.findElement(By.id("erro"+id));
		assertThat(errorbx.isDisplayed());
	}

		
}
