package steps.carrinhoSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.supports.Wait;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;

public class Carrinho {

    WebDriver driver = DriverManager.getDriver();

    @Quando("o usuário clicadas no botão REMOVE")
    public void asdoUsuárioClicaNoBotãosRemove(String arg0) {
    }

    @Então("a notificação no icone do carrinho desaparece")
    public void aNotificaçãoNoIconeDoCarrinhoDesaparece() {
        extentTest.log(Status.INFO, "O icone do carrinho não apareceu");
    }

    @E("a lista do produto desaparece")
    public void aListaDoProdutoDesaparece() throws IllegalAccessException {
        extentTest.log(Status.PASS, "A lista do produto não apareceu", Screenshot.screenshotBase64(driver));
    }

    @Quando("o usuário clica no botão REMOVE a página do carrinho")
    public void oUsuárioClicaNoBotãoREMOVEAPáginaDoCarrinho() {
        driver.findElement(By.cssSelector(".item_pricebar button")).click();
        extentTest.log(Status.INFO, "A clica no botão 'REMOVE'");
    }

    @Quando("o usuário clica no botão CONTINUE SHOPPING")
    public void oUsuárioClicaNoBotãoCONTINUESHOPPING() {
        driver.findElement(By.cssSelector(".cart_footer .btn_secondary")).click();
        extentTest.log(Status.INFO, "A clica no botão 'CONTINUE SHOPPING'");
    }

    @Então("o sistema deverá redirecionar para a tela principal com produtos")
    public void oSistemaDeveráRedirecionarParaATelaPrincipalComProdutos() throws IllegalAccessException {
        extentTest.log(Status.PASS, "A redireciona para a tela principal com produtos", Screenshot.screenshotBase64(driver));
    }

    @Quando("o usuário clica no botão CHECKOUT")
    public void oUsuárioClicaNoBotãoCHECKOUT() {
        driver.findElement(By.cssSelector(".cart_footer .btn_action")).click();
        extentTest.log(Status.INFO, "A clica no botão 'CHECKOUT'");
    }

    @Então("o sistema deverá redirecionar para a tela	de informações \\(checkout)")
    public void oSistemaDeveráRedirecionarParaATelaDeInformaçõesCheckout() throws IllegalAccessException {
        extentTest.log(Status.PASS, "A redireciona para a tela informações (checkout)", Screenshot.screenshotBase64(driver));
    }
}
