package testes.automatizados.configuracao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverProvider {

    public static WebDriver criarNavegador() {

        // Configura o WebDriver (chromedriver) compatível com a versão do navegador atual
        WebDriverManager.chromedriver().setup();

        // Configura opções para o ChromeDriver
        ChromeOptions options = new ChromeOptions();

        // Permite conexões remotas de qualquer origem para contornar erros de mesma origem no Google chrome
        options.addArguments("--remote-allow-origins=*");

        // Inicializa o navegador Google Chrome com as configurações definidas em 'options'
        ChromeDriver navegador = new ChromeDriver(options);

        // Maximiza a janela do navegador aberto
        navegador.manage().window().maximize();

        // Configura um tempo neste caso de 6 segundo para dar tempo da página carregar antes de apontar um erro
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        return navegador;

    };

}
