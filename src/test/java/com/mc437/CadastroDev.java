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
		
	@When("^coloco nome \"([^\"]*)\" sobrenome \"([^\"]*)\" endereco \"([^\"]*)\" celular \"([^\"]*)\" cpf \"([^\"]*)\"  email \"([^\"]*)\" username \"([^\"]*)\" senha \"([^\"]*)\"$")
	public void user_pass_input(String nome, String telefone, String cpf, String endereco, String email, String senha){
		WebElement name = driver.findElement(By.id("name"));
		WebElement tel = driver.findElement(By.id("phone"));
		WebElement cp_f = driver.findElement(By.id("cpf"));
		WebElement address = driver.findElement(By.id("address"));
		WebElement e_mail = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement cadastrar = driver.findElement(By.id("cadastrar"));
		
		name.sendKeys(nome);
		tel.sendKeys(telefone);
		cp_f.sendKeys(cpf);
		address.sendKeys(endereco);
		e_mail.sendKeys(email);
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