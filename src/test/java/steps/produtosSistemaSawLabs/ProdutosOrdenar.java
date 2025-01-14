package steps.produtosSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static framework.tools.Report.extentTest;

public class ProdutosOrdenar {

    WebDriver driver = DriverManager.getDriver();

    @Quando("o usuário clica no Select Name\\(A to Z)")
    public void oUsuárioClicaNoSelectNameAToZ() {
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        extentTest.log(Status.INFO, "A clica no menu 'Name (A to Z)'");
    }

    @E("aparecer a lista de opções Name \\(A to Z), Name \\(Z to A), Price \\(low to high) e Price \\(high to low)")
    public void aparecerAListaDeOpçõesNameAToZNameZToAPriceLowToHighEPriceHighToLow() {
        extentTest.log(Status.INFO, "Aparecer a lista de opções: \"Name (A to Z)\", \"Name (Z to A)\", \"Price (low to high)\" e \"Price (high to low)\"");
    }

    @E("o usuário seleciona Name \\(Z to A)")
    public void oUsuárioSelecionaNameZToA() {
        new Select(driver.findElement(By.cssSelector(".product_sort_container"))).selectByValue("za");
        extentTest.log(Status.INFO, "Clicou no filtro para ordenar de Z a A");
    }

    @Então("os produtos deverão ser reorganizados na página em ordem decrescente de Z para A")
    public void osProdutosDeverãoSerReorganizadosNaPáginaEmOrdemDecrescenteDeZParaA() throws IllegalAccessException {
        extentTest.log(Status.PASS, "Ordenou os produtos Z para A", Screenshot.screenshotBase64(driver));
    }

    @E("o usuário seleciona Price \\(low to high)")
    public void oUsuárioSelecionaPriceLowToHigh() {
        new Select(driver.findElement(By.cssSelector(".product_sort_container"))).selectByValue("lohi");
        extentTest.log(Status.INFO, "Clicou no filtro para ordenar os preços do menor para o maior");
    }

    @Então("os produtos deverão ser reorganizados na página do menor para o maior preço")
    public void osProdutosDeverãoSerReorganizadosNaPáginaDoMenorParaOMaiorPreço() throws IllegalAccessException {
        extentTest.log(Status.PASS, "Ordenou os produtos preço do menor para o maior", Screenshot.screenshotBase64(driver));
    }

    @E("o usuário seleciona Price \\(high to low)")
    public void oUsuárioSelecionaPriceHighToLow() {
        new Select(driver.findElement(By.cssSelector(".product_sort_container"))).selectByValue("hilo");
        extentTest.log(Status.INFO, "Clicou no filtro para ordenar os preços do maior para o menor");
    }

    @Então("os produtos deverão ser reorganizados na página do maior para o menor preço")
    public void osProdutosDeverãoSerReorganizadosNaPáginaDoMaiorParaOMenorPreço() throws IllegalAccessException {
        extentTest.log(Status.PASS, "Ordenou os produtos preço do maior para o menor", Screenshot.screenshotBase64(driver));
    }
}
