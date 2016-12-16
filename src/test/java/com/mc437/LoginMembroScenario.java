package com.mc437;

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

public class LoginMembroScenario extends StepDefs {
	private static final String login = "admin";
	private static final String pass = "abc125";
	
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
	
	@When("Entrar na página login admin")
	public void openMembro(){
		driver.get(ROOT_URL + "login/");
	}

	//TESTE COM LOGIN VALIDO
	@When("coloco usuário e senha válido")
	public void autenticacaoMembroValida(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

		WebElement email = driver.findElement(By.id("username"));
		WebElement senha = driver.findElement(By.id("pass"));

		email.sendKeys(login);
		senha.sendKeys(pass);
		senha.submit();
	}

	@Then("sou redirecionado para a página inicial de membro")
	public void redirecionarPaginaMembro(){
		String url = ROOT_URL + "member";
		boolean isCorrectPage = driver.getCurrentUrl().equals(url);
		
		System.out.println("TESTE: " + driver.getCurrentUrl());
		assert isCorrectPage;
	}

	//TESTES ERROS
	@When("coloco nome de usuário não cadastrado e senha qualquer")
	public void autenticacaoMembroInvalidaUsuarioNaoCadastrado(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

		WebElement email = driver.findElement(By.id("username"));
		WebElement senha = driver.findElement(By.id("pass"));

		email.sendKeys("xyz");
		senha.sendKeys(pass);
		senha.submit();
	}

	@When("coloco nome de um usuário cadastrado e senha inválida")
	public void autenticacaoMembroInvalidaSenhaIncorreta(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

		WebElement email = driver.findElement(By.id("username"));
		WebElement senha = driver.findElement(By.id("pass"));

		email.sendKeys(login);
		senha.sendKeys("123");
		senha.submit();
	}
	
	@Then("^uma mensagem de erro é mostrada '(.*)'$")
	public void apresentaMensagemErro(String msg){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")));

		WebElement msgElem = driver.findElement(By.className("alert-danger"));
		assert(msgElem.getText()).contains(msg);
	}
}
