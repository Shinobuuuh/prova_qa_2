package testes.automatizados.casos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testes.automatizados.configuracao.WebDriverProvider;

import java.time.Duration;

@DisplayName("Testes na Sessão Entre em Contato")
public class contato {
    @Test
    @DisplayName("Validar se ao preencher os campos de Nome, E-mail e Mensagem na sessão \"Entre em Contato\" e clicar no botão \"Enviar\" está retornando um Alerta dizendo \"Mensagem enviada com sucesso!\"")
    public void testValidarEnvioMensagem() {

        // Usando a classe WebDriverProvider para criar e configurar o navegador que usaremos
        WebDriver navegador = WebDriverProvider.criarNavegador();

        // Abre a página em questão que será validada
        navegador.get("file://" + System.getProperty("user.dir") + "/../index.html");

        // Preencher formulário para entrar em contato campo NOME
        navegador.findElement(By.id("nome")).sendKeys("Murillo Rosa da Silva");

        // Preencher formulário para entrar em contato campo E-mail
        navegador.findElement(By.id("email")).sendKeys("murillo@gmail.com");

        // Preencher formulário para entrar em contato campo Mensagem
        navegador.findElement(By.id("mensagem")).sendKeys("Olá, estou enviando uma mensagem de teste");

        // Clica no botão "Enviar" para enviar a mensagem após preencher o formulário
        navegador.findElement(By.xpath("//button[text()='Enviar']")).click();




        // Validar que o texto Mensagem enviada com sucesso! foi apresentado após o envio da mensagem

        // Alterna para o alerta apresentado
        Alert alerta = navegador.switchTo().alert();

        //Exibe o texto para o alerta
        String mensagemSucesso = alerta.getText();

        //Exibe o texto do alerta no console
        System.out.println(mensagemSucesso);

        // Compara o texto da mensagem com o texto que deseja comparar para saber se são iguais
        Assertions.assertEquals("Mensagem enviada com sucesso!", mensagemSucesso);


        // Da ok no alerta para o alerta fechar
        alerta.accept();

        navegador.quit();
    }



}

