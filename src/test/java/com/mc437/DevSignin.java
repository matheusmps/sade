package com.mc437;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mc437.stepdefs.StepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DevSignin extends StepDefs {
		
	@When("^coloco usuário \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void user_pass_input(String user, String password){
		WebElement email = driver.findElement(By.id("campo_email"));
		email.sendKeys(user);
		WebElement senha = driver.findElement(By.id("campo_senha"));
		senha.sendKeys(password);	
		WebElement acessar = driver.findElement(By.id("acessar"));
		acessar.click();
	}
	
	@Then("^sou redirecionado para a página \"([^\"]*)\"$")
	public void check_page(String url){		
		assertThat(driver.getCurrentUrl().equals(url));
	}
	
	@Then("^é mostrada a mensagem de erro (.*)")
	public void check_erro(String id){
		WebElement errorbox = driver.findElement(By.id("erro"+id));
		assertThat(errorbox.isDisplayed());
	}

}
