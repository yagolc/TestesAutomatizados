package br.siteyag.login.task.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Automatizados da funcionalidade De Sign Up")
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo ususario com dados validos")
    public void testRegistrarUmNovoUsuarioComDadosValidos() {
        //Vou abrir o Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));


        //abrir o site do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Vouclicar no botão que tem o id igual signup

        navegador.findElement(By.id("signup")).click();

        // Vou Digitar o nome no campo com Id igual a name-sign-up

        navegador.findElement(By.id("name-sign-up")).sendKeys("Lucas");

        //vou digitar o login com id igual a login-sign-up

        navegador.findElement(By.id("login-sign-up")).sendKeys("LucasTeste07");

        //vou digitar a senha no campo com id igual a password-sign-up

        navegador.findElement(By.id("password-sign-up")).sendKeys("123456");



        //vou clicar no botão com o campo com id igual a  btn-submit-sign-up
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        //Validar que o texto Hi lucas foi apresentado no elemento que possui a class igual a me
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Lucas", saudacaoAtual);

        //fechar navegador
        navegador.quit();

    }

}
