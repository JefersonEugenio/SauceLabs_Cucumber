package steps.produtosSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.supports.Wait;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

import static framework.tools.Report.extentTest;

public class ProdutoMenu {

    WebDriver driver = DriverManager.getDriver();
    Wait wait = new Wait(driver);

    public void listasMenu(String menu) {
        switch (menu) {
            case "All Items":
                wait.waitVisibilityElement(By.id("inventory_sidebar_link"));
                driver.findElement(By.id("inventory_sidebar_link")).click();
                extentTest.log(Status.INFO, "Clicou no 'All Items' e mostrou os produtos na página");
                break;
            case "About":
                wait.waitVisibilityElement(By.id("about_sidebar_link"));
                driver.findElement(By.id("about_sidebar_link")).click();
                extentTest.log(Status.INFO, "Clicou no 'About' e redirecionar para site de 'SauceLabs'");
                break;
            case "Logout":
                wait.waitVisibilityElement(By.id("logout_sidebar_link"));
                driver.findElement(By.id("logout_sidebar_link")).click();
                extentTest.log(Status.INFO, "Clicou no 'Logout' e redirecionar para a tela de login, deslogando o usuário");
                break;
            case "Reset App State":
                wait.waitVisibilityElement(By.id("reset_sidebar_link"));
                driver.findElement(By.id("reset_sidebar_link")).click();
                extentTest.log(Status.INFO, "Clicou no 'Reset App State'");
            case "X":
                wait.waitVisibilityElement(By.id("reset_sidebar_link"));
                driver.findElement(By.cssSelector(".bm-cross-button"));
                extentTest.log(Status.INFO, "Clicou no 'X' e menu fechar");
            default:
                System.out.println("Opção inválida");
        }
    }

    @Quando("o usuário clica no ícone ou símbolo de três linhas")
    public void oUsuárioClicaNoÍconeOuSímboloDeTrêsLinhas() {
        driver.findElement(By.cssSelector(".bm-burger-button")).click();
        extentTest.log(Status.INFO, "Clicou no menu e aparece uma lista");
    }

    @E("aparece uma lista de opções: All Items, About, Logout, Reset App State e X")
    public void apareceUmaListaDeOpçõesAllItemsAboutLogoutResetAppStateEX() {
        extentTest.log(Status.INFO, "uma lista de opções: All Items, About, Logout, Reset App State e X");
    }

    @E("o usuário clica {string}")
    public void oUsuárioClica(String menu) {
        listasMenu(menu);
    }

    @Então("o sistema deverá redirecionar para a tela principal com a lista de produtos")
    public void oSistemaDeveráRedirecionarParaATelaPrincipalComAListaDeProdutos() throws IllegalAccessException {
        extentTest.log(Status.INFO, "O sistema redireciona para a tela principal com a lista de produtos", Screenshot.screenshotBase64(driver));
    }

    @Então("o sistema deverá redirecionar para site de SauceLabs")
    public void oSistemaDeveráRedirecionarParaSiteDeSauceLabs() throws IllegalAccessException {
        extentTest.log(Status.PASS, "O sistema redireciona para site de SauceLabs".toLowerCase(Locale.ROOT), Screenshot.screenshotBase64(driver));
    }

    @Então("o sistema deverá redirecionar para a tela de login, deslogando o usuário")
    public void oSistemaDeveráRedirecionarParaATelaDeLoginDeslogandoOUsuário() throws IllegalAccessException {
        extentTest.log(Status.PASS, "O sistema redireciona para a tela de login, deslogando o usuário", Screenshot.screenshotBase64(driver));
    }

    @E("o sistema deve exibir uma notificação no carrinho")
    public void oSistemaDeveExibirUmaNotificaçãoNoCarrinho() throws IllegalAccessException {
        WebElement element = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        extentTest.log(Status.INFO, "Icone do carrinho apareceu com quantidade", Screenshot.screenshotBase64(driver));
    }

    @Então("O sistema deverá remover a notificação do carrinho")
    public void oSistemaDeveráRemoverANotificaçãoDoCarrinho() {
        extentTest.log(Status.INFO, "O sistema remove a notificação do carrinho");
    }

    @Então("o menu deverá fechar")
    public void oMenuDeveráFechar() {
        extentTest.log(Status.INFO, "O menu fecha");
    }
}
