package testes.automatizados.casos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testes.automatizados.configuracao.WebDriverProvider;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.time.LocalDate;

@DisplayName("Testes na Sessão Orçamento")
public class orcamento {

    @Test
    @DisplayName("Validar se ao preencher o orçamento com valores iguais ou menores que 0 (zero) está impedindo o usuário de realizar o orçamento   ")
    public void validarPreencherOrcamento() {

        // Usando a classe WebDriverProvider para criar e configurar o navegador que usaremos
        WebDriver navegador = WebDriverProvider.criarNavegador();

        // Abre a página em questão que será validada
        navegador.get("file://" + System.getProperty("user.dir") + "/../index.html");






        // Preencher formulário para realizar orçamento campo Valor da Passagem
        navegador.findElement(By.id("valorPassagem")).sendKeys("1");

        // Preencher formulário para realizar orçamento campo Número de Pessoas
        navegador.findElement(By.id("numeroPessoas")).sendKeys("1");

        // Preencher formulário para realizar orçamento campo Dias de Hospedagem
        navegador.findElement(By.id("diasHospedagem")).sendKeys("1");

        // Preencher formulário para realizar o orçamento campo Data de Nascimento
        navegador.findElement(By.id("dataNascimento")).sendKeys("24012007");

        // Pegar o valor preenchido em cada campo e joga em variaveis para serem comparadas
        double valorPassagem = Double.parseDouble(navegador.findElement(By.id("valorPassagem")).getAttribute("value"));
        double numeroPessoas = Double.parseDouble(navegador.findElement(By.id("numeroPessoas")).getAttribute("value"));
        double diasHospedagem = Double.parseDouble(navegador.findElement(By.id("diasHospedagem")).getAttribute("value"));
        String dataNascimento = navegador.findElement(By.id("dataNascimento")).getAttribute("value");




        // Clica no botão "Calcular" para realizar o cálculo do orçamento para o usuario
        navegador.findElement(By.xpath("//button[text()='Calcular']")).click();




        // Verifica se a pessoa tem 18 anos ou mais
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nascimento = LocalDate.parse(dataNascimento, formatter);
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(nascimento, hoje);
        boolean menorDeIdade = idade.getYears() < 18;



        //Valida se caso o valor esteja inválido para o valor da passagem, está mostrando o alerta para o usuário

        boolean alertaApareceu = false;
        Alert alerta = null;
        if (valorPassagem <= 0) {
            // Verifica se o alerta aparece quando o valor da passagem é 0 ou menor
            try {
                alerta = navegador.switchTo().alert();
                alertaApareceu = true;
            } catch (Exception e) {
                alertaApareceu = false;
            }
            // Validar se o alerta apareceu para o campo "Valor Passagem"
            if (alertaApareceu) {
                System.out.println("Alerta exibido corretamente para 'Valor Passagem'.");
            } else {
                System.out.println("Não apareceu o alerta para 'Valor Passagem'!");
                Assertions.fail("O alerta não apareceu para 'Valor Passagem'. O teste falhou.");
            }
        }


        //Valida se caso o valor esteja inválido para o número de pessoas, está mostrando o alerta para o usuário

        alertaApareceu = false; // Resetando a variável de alerta
        if (numeroPessoas <= 0) {
            // Verifica se o alerta aparece quando o número de pessoas é 0 ou menor
            try {
                alerta = navegador.switchTo().alert();
                alertaApareceu = true;
            } catch (Exception e) {
                alertaApareceu = false;
            }
            // Validar se o alerta apareceu para o campo "Número de Pessoas"
            if (alertaApareceu) {
                System.out.println("Alerta exibido corretamente para 'Número de Pessoas'.");
            } else {
                System.out.println("Não apareceu o alerta para 'Número de Pessoas'!");
                Assertions.fail("O alerta não apareceu para 'Número de Pessoas'. O teste falhou.");
            }
        }

        //Valida se caso o valor esteja inválido para a quantidade de dias para hospedagem, está mostrando o alerta para o usuário
        alertaApareceu = false; // Resetando a variável de alerta
        if (diasHospedagem <= 0) {
            // Verifica se o alerta aparece quando o número de dias de hospedagem é 0 ou menor
            try {
                alerta = navegador.switchTo().alert();
                alertaApareceu = true;
            } catch (Exception e) {
                alertaApareceu = false;
            }
            // Validar se o alerta apareceu para o campo "Dias de Hospedagem"
            if (alertaApareceu) {
                System.out.println("Alerta exibido corretamente para 'Dias de Hospedagem'.");
            } else {
                System.out.println("Não apareceu o alerta para 'Dias de Hospedagem'!");
                Assertions.fail("O alerta não apareceu para 'Dias de Hospedagem'. O teste falhou.");
            }
        }

        //Valida se caso a pessoa seja menor de idade está mostrando um alerta para o usuário
        alertaApareceu = false; // Resetando a variável de alerta
        if (menorDeIdade) {
            // Verifica se o alerta aparece quando a pessoa é menor de idade
            try {
                alerta = navegador.switchTo().alert();
                alertaApareceu = true;
            } catch (Exception e) {
                alertaApareceu = false;
            }
            // Validar se o alerta apareceu para o campo "Idade"
            if (alertaApareceu) {
                System.out.println("Alerta exibido corretamente para 'Menor de Idade'.");
            } else {
                System.out.println("Não apareceu o alerta para 'Menor de Idade'!");
                Assertions.fail("O alerta não apareceu para 'Menor de Idade'. O teste falhou.");
            }
        }




    navegador.quit();


    }
}
