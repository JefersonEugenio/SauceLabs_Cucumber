package steps.finalizarSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.supports.Calcule;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Finalizar {

    WebDriver driver = DriverManager.getDriver();
    Calcule calcule = new Calcule();

    @E("o usuário verifica um produto listado na página de Overview")
    public void oUsuárioVerificaUmProdutoListadoNaPáginaDeOverview() {
        boolean elemento = driver.findElement(By.cssSelector(".cart_item")).isDisplayed();
        Assertions.assertTrue(elemento);
        extentTest.log(Status.INFO, "O produto está listado");
    }

    @E("o usuário verifica o valor do produto listado na página de Overview")
    public void oUsuárioVerificaOValorDoProdutoListadoNaPáginaDeOverview() {
        String valor = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        Assertions.assertEquals("$9.99", valor);
        extentTest.log(Status.INFO, "O valor do produto: " + valor);
    }

    @E("o usuário verifica do item total, taxa e total listado na página de Overview")
    public void oUsuárioVerificaDoItemTotalTaxaETotalListadoNaPáginaDeOverview() {
        String valor = driver.findElement(By.cssSelector(".summary_subtotal_label")).getText();
        String valorTaxa = driver.findElement(By.cssSelector(".summary_tax_label")).getText();
        String valorTotal = calcule.calculeTotal(valor, valorTaxa);
        assertThat(driver.findElement(By.cssSelector(".summary_total_label")).getText(), containsString(valorTotal));
        extentTest.log(Status.PASS, "O valor do total está correto: " + valorTotal, Screenshot.screenshotElement(driver.findElement(By.cssSelector(".summary_info")), driver));
    }

    @E("o usuário clica no botão FINISH")
    public void oUsuárioClicaNoBotãoFINISH() {
        driver.findElement(By.cssSelector(".btn_action")).click();
        extentTest.log(Status.INFO, "Clicou no botão 'FINISH'");
    }

    @Então("o sistema deverá redirecionar para a tela de confirmação \\(Finish) exibindo a mensagem {string}")
    public void oSistemaDeveráRedirecionarParaATelaDeConfirmaçãoFinishExibindoAMensagem(String string) throws IllegalAccessException {
        String mensagem = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assertions.assertEquals(string, mensagem);
        extentTest.log(Status.PASS, "Finalizado de comprar", Screenshot.screenshotBase64(driver));
    }
}
