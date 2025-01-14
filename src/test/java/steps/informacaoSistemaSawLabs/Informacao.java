package steps.informacaoSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Informacao {

    WebDriver driver = DriverManager.getDriver();

    @Quando("que o usuário está na página do checkout")
    public void queOUsuárioEstáNaPáginaDoCheckout() {
        extentTest.log(Status.INFO, "A tela da página do checkout");
    }

    @E("o usuário preenche o campo First Name com {string}")
    public void oUsuárioPreencheOCampoComONome(String nome) {
        driver.findElement(By.id("first-name")).sendKeys(nome);
        extentTest.log(Status.INFO, "Preenche o nome: " + nome);
    }

    @E("o usuário preenche o campo Last Name com {string}")
    public void oUsuárioPreencheOCampoComONúmero(String sobrenome) {
        driver.findElement(By.id("last-name")).sendKeys(sobrenome);
        extentTest.log(Status.INFO, "Preenche o sobrenome: " + sobrenome);
    }

    @E("o usuário preenche o campo ZipPostal com {string}")
    public void oUsuárioPreencheOCampoZipPostalCom(String cep) {
        driver.findElement(By.id("postal-code")).sendKeys(cep);
        extentTest.log(Status.INFO, "Preenche o CEP: " + cep);
    }

    @E("o usuário clica no botão CONTINUE")
    public void oUsuárioClicaNoBotãoCONTINUE() {
        driver.findElement(By.cssSelector(".cart_button")).click();
        extentTest.log(Status.INFO, "A clica no botão CONTINUE");
    }

    @Então("o sistema deverá redirecionar para a página {string}")
    public void oSistemaDeveráRedirecionarParaAPágina(String titulo) throws IllegalAccessException {
        String title = driver.findElement(By.cssSelector(".subheader")).getText();
        assertThat(title, containsString(titulo));
        extentTest.log(Status.PASS, "A página está Overview", Screenshot.screenshotBase64(driver));
    }

    @Então("O sistema exibirá a mensagem: {string}")
    public void oSistemaExibiráAMensagem(String mensagem) throws IllegalAccessException {
        String error = driver.findElement(By.cssSelector("form h3")).getText();
        assertThat(error, containsString(mensagem));
        extentTest.log(Status.PASS, "A mensagem exibir: " + error, Screenshot.screenshotBase64(driver));
    }

    @E("o usuário clica no botão CANCEL")
    public void oUsuárioClicaNoBotãoCANCEL() {
        driver.findElement(By.cssSelector(".btn_secondary")).click();
        extentTest.log(Status.INFO, "Clicou no botão 'CANCEL'");
    }

    @Então("o sistema deverá redirecionar para a tela do {string}")
    public void oSistemaDeveráRedirecionarParaATelaDoCarrinho(String titulo) throws IllegalAccessException {
        String title = driver.findElement(By.cssSelector(".subheader")).getText();
        assertThat(title, containsString(titulo));
        extentTest.log(Status.PASS, "A tela da página está 'Your Cart'", Screenshot.screenshotBase64(driver));
    }
}