package com.mc437.sade.cucumber;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mc437.sade.cucumber.stepdefs.StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginMembroScenario extends StepDefs {

	private static final String rootUrl = "http://localhost:8080/adm.html#/";
	private static final String login = "admin";
	private static final String pass = "abc125";

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

	
	
	@When("Entrar na página login admin")
	public void openMembro(){
		driver.get(rootUrl);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("titlePageLoginAdm")));
	}
	
	//TESTE COM LOGIN VALIDO
	@When("coloco usuário e senha válido")
	public void autenticacaoMembroValida(){
		WebElement email = driver.findElement(By.id("campo_email"));
		WebElement senha = driver.findElement(By.id("campo_senha"));
		WebElement acessar = driver.findElement(By.id("acessar"));

		email.sendKeys(login);
		senha.sendKeys(pass);
		acessar.click();
	}

	@Then("sou redirecionado para a página inicial de membro")
	public void redirecionarPaginaMembro(){
		String url = "http://localhost:8080/" + "SOMETHING";
		boolean isCorrectPage = driver.getCurrentUrl().equals(url);
		assert isCorrectPage;
	}



	//AINDA ESTAMOS REFATORANDO 
	public static void main(String[] args) {	
		//abre pagina home da conpec
		WebDriver driver = new ChromeDriver();
		driver.get(rootUrl);

		//testar se validacao funciona para membro da Conpec
		WebElement email = driver.findElement(By.id("campo_email"));
		WebElement senha = driver.findElement(By.id("campo_senha"));
		WebElement acessar = driver.findElement(By.id("acessar"));		

		// (1) email valido existente no banco de dados e senha errada
		email.sendKeys("renatogmail.com");
		senha.sendKeys("123456");
		acessar.click();
		WebElement erro1 = driver.findElement(By.id("erro1"));
		if (!driver.getCurrentUrl().equals(rootUrl) || !erro1.isDisplayed()){
			System.out.println("Erro caso 1!");
			return;
		} 


		//(2) email que nao existe na base de dados
		email.sendKeys("renatogmail.com");
		senha.sendKeys("123456");
		acessar.click();
		WebElement erro2 = driver.findElement(By.id("erro2"));
		if (!driver.getCurrentUrl().equals(rootUrl) || !erro2.isDisplayed()){
			System.out.println("Erro caso 2!");
			return;
		}

		//(3) campo de email vazio  
		email.sendKeys("");
		senha.sendKeys("123456");
		acessar.click();
		WebElement erro3 = driver.findElement(By.id("erro3"));
		if (!driver.getCurrentUrl().equals(rootUrl) || !erro3.isDisplayed()){
			System.out.println("Erro caso 3!");
			return;
		}

		//(4) campo de senha vazio
		email.sendKeys("renato@gmail.com");
		senha.sendKeys("");
		acessar.click();
		WebElement erro4 = driver.findElement(By.id("erro4"));
		if (!driver.getCurrentUrl().equals(rootUrl) || !erro4.isDisplayed()){
			System.out.println("Erro caso 4!");
			return;
		}

		//(5) email valido existente no banco de dados e senha correta


		System.out.println("Success!");


		driver.close();
	}

}
