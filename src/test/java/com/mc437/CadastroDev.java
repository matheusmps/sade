package com.mc437;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mc437.stepdefs.StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CadastroDev extends StepDefs{
	
	@Then("sou redirecionado para a página inicial de dev")
	public void redirecionarPaginaMembro(){
		String url = ROOT_URL + "dev";
		boolean isCorrectPage = driver.getCurrentUrl().equals(url);
		
		System.out.println("TESTE: " + driver.getCurrentUrl());
		assert isCorrectPage;
	}
		
	@When("^coloco combinação nos campos ([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*)$")
	public void user_pass_input(String nome, String sobrenome, String endereco, String celular, String cpf, String email, String username, String senha){
		WebElement name = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement address = driver.findElement(By.id("address"));
		WebElement tel = driver.findElement(By.id("cellphoneNumber"));
		WebElement cpfInput = driver.findElement(By.id("cpf"));
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement cadastrar = driver.findElement(By.id("cadastrar"));
		
		name.sendKeys(nome);
		lastName.sendKeys(sobrenome);
		address.sendKeys(endereco);
		tel.sendKeys(celular);
		cpfInput.sendKeys(cpf);
		emailInput.sendKeys(email);
//		usernameInput.sendKeys(arg0);
		pass.sendKeys(senha);	
		cadastrar.click();
	}
	
//	@Then("^sou redirecionado para a página \"([^\"]*)\"$")
//	public void chek_page(String url){		
//		boolean isCorrectPage = driver.getCurrentUrl().equals(url);
//		assert isCorrectPage;
//	}
	
	@Then("^é mostrada a mensagem de erro \"(.*)\"")
	public void chek_erro(String msg){
		WebElement errorbx = driver.findElement(By.className("alert"));
		assertThat(errorbx.getText().equals(msg));
	}

		
}