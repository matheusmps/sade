//package com.mc437;
//
//import java.io.File;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class AdminSignin {
//
//	private static final String rootUrl = "http://www.conpec2016.com/AdminSignin";
//
//	public static void main(String[] args) {
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File chromedriver = new File(classpathRoot, "driver/chromedriver");
//		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
//		
//		//abre pagina home da conpec
//		WebDriver driver = new ChromeDriver();
//		driver.get(rootUrl);
//		
//		//testar se validacao funciona para membro da Conpec
//		WebElement email = driver.findElement(By.id("campo_email"));
//		WebElement senha = driver.findElement(By.id("campo_senha"));
//		WebElement acessar = driver.findElement(By.id("acessar"));
//		
//		
//		
//		
//		
//		// (1) email valido existente no banco de dados e senha errada
//		email.sendKeys("renatogmail.com");
//		senha.sendKeys("123456");
//		acessar.click();
//		WebElement erro1 = driver.findElement(By.id("erro1"));
//		if (!driver.getCurrentUrl().equals(rootUrl) || !erro1.isDisplayed()){
//			System.out.println("Erro caso 1!");
//			return;
//		} 
//		
//		
//		//(2) email que nao existe na base de dados
//		email.sendKeys("renatogmail.com");
//		senha.sendKeys("123456");
//		acessar.click();
//		WebElement erro2 = driver.findElement(By.id("erro2"));
//		if (!driver.getCurrentUrl().equals(rootUrl) || !erro2.isDisplayed()){
//			System.out.println("Erro caso 2!");
//			return;
//		}
//			
//		//(3) campo de email vazio  
//		email.sendKeys("");
//		senha.sendKeys("123456");
//		acessar.click();
//		WebElement erro3 = driver.findElement(By.id("erro3"));
//		if (!driver.getCurrentUrl().equals(rootUrl) || !erro3.isDisplayed()){
//			System.out.println("Erro caso 3!");
//			return;
//		}
//			
//		//(4) campo de senha vazio
//		email.sendKeys("renato@gmail.com");
//		senha.sendKeys("");
//		acessar.click();
//		WebElement erro4 = driver.findElement(By.id("erro4"));
//		if (!driver.getCurrentUrl().equals(rootUrl) || !erro4.isDisplayed()){
//			System.out.println("Erro caso 4!");
//			return;
//		}
//		
//		//(5) email valido existente no banco de dados e senha correta
//		email.sendKeys("renato@gmail.com");
//		senha.sendKeys("renato");
//		acessar.click();
//		WebElement erro5 = driver.findElement(By.id("erro5"));
//		if (!driver.getCurrentUrl().equals("http://www.conpec2016.com/" + "adminperfil") ){
//			System.out.println("Erro caso 5!");
//		return;
//		}
//				
//		System.out.println("Success!");
//		
//		
//		driver.close();
//	}
//
//}
