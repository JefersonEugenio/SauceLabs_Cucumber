package steps.produtosSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static framework.tools.Report.extentTest;

public class Produtos {

    WebDriver driver = DriverManager.getDriver();

    @Dado("que o usuário está acessar de login e preencher usuario {string} e senha {string}")
    public void queOUsuárioEstáAcessarDeLoginEPreencherUsuarioESenha(String usuario, String senha) {
        extentTest.log(Status.INFO, "A tela está pagina de login do sistema Sauce Labs");
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        extentTest.log(Status.INFO, "Preenche do usuário: " + usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
        extentTest.log(Status.INFO, "Preenche a senha do usuário: " + senha);
        driver.findElement(By.id("login-button")).click();
        extentTest.log(Status.INFO, "A clica no botão 'LOGIN'");
        extentTest.log(Status.INFO, "Acessou conta e tela está pagina do sistema Sauce Labs");
    }

    @Quando("o usuário escolhe um produto {string}")
    public void o_usuário_escolhe_um_produto(String string) {
        extentTest.log(Status.INFO, "O usuário escolheu um produto " + string);
    }

    @E("o usuário clica no botão ADD TO CART")
    public void o_usuário_clica_no_botão_add_to_cart() {
        driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button")).click();
        extentTest.log(Status.INFO, "A clica no botão 'ADD TO CART'");
    }

    @Então("o botão deverá mudar para REMOVE com cor de borda preta e o texto {string}.")
    public void o_botão_deverá_mudar_para_com_cor_de_borda_preta_e_o_texto(String remove) {
        Assertions.assertEquals(remove, driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button")).getText());
        extentTest.log(Status.INFO, "O botão ficou 'REMOVE' do produto");
    }

    @E("o sistema deverá exibir uma notificação no carrinho.")
    public void o_sistema_deverá_exibir_uma_notificação_no_carrinho() throws IllegalAccessException {
        extentTest.log(Status.PASS, "Adicionou ao carrinho", Screenshot.screenshotBase64(driver));
    }

    @Quando("que o usuário já adicionou um produto {string} ao carrinho")
    public void queOUsuárioJáAdicionouUmProdutoAoCarrinho(String string) {
        driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button")).click();
        extentTest.log(Status.INFO, "A clica no botão 'ADD TO CART'");
    }

    @E("o usuário clica no botão REMOVE")
    public void oUsuárioClicaNoBotãoREMOVE() {
        driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button")).click();
        extentTest.log(Status.INFO, "A clica no botão 'REMOVE'");
    }

    @Então("o botão deverá mudar para {string}")
    public void oBotãoDeveráMudarPara(String string) {
        Assertions.assertEquals(string, driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button")).getText());
        extentTest.log(Status.PASS, "Verificado nome no botão para 'ADD TO CART'");
    }

    @E("a notificação no icone do carrinho não deverá aparecer")
    public void aNotificaçãoNoIconeDoCarrinhoNãoDeveráAparecer() throws IllegalAccessException {
        extentTest.log(Status.PASS, "icone do carrinho não apareceu", Screenshot.screenshotBase64(driver));
    }

    @Quando("o usuário clica no botão {string} todos os produtos")
    public void oUsuárioClicaNoBotãoTodosOsProdutos(String arg0) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn_inventory"));
        for (WebElement button : buttons) {
            if (button.isDisplayed()) {
                button.click();
                extentTest.log(Status.INFO, "Clicar no botão 'ADD TO CART'");
            }
        }
    }

    @Então("os botões deverão mudar para {string}")
    public void osBotõesDeverãoMudarPara(String string) {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn_inventory"));
        for (WebElement button : buttons) {
            if (button.isDisplayed()) {
                Assertions.assertEquals("REMOVE", button.getText());
                extentTest.log(Status.PASS, "O botão está 'REMOVE'");
            }
        }
    }

    @E("a notificação no icone do carrinho com quantidade que selecionado")
    public void aNotificaçãoNoIconeDoCarrinhoComQuantidadeQueSelecionado() throws IllegalAccessException {
        WebElement element = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        extentTest.log(Status.INFO, "Icone do carrinho apareceu com quantidade", Screenshot.screenshotBase64(driver));
    }

    @Quando("que o usuário já clicou no botão {string} para o produto {string}")
    public void queOUsuárioJáClicouNoBotãoParaOProduto(String string1, String string2) {
        driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button")).click();
        extentTest.log(Status.INFO, "A clica no botão " + string1 + " o produto do " + string2);
    }

    @E("o usuário clica no produto {string} para acessar sua página de detalhes")
    public void oUsuárioClicaNoProdutoParaAcessarSuaPáginaDeDetalhes(String string) {
        driver.findElement(By.id("item_0_title_link")).click();
        extentTest.log(Status.INFO, "A clica no produto " + string + " para acessar sua página de detalhes");
    }

    @E("na página de detalhes, clica no botão {string}")
    public void naPáginaDeDetalhesClicaNoBotão(String string) {
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        extentTest.log(Status.PASS, "A clica no botão " + string);
        Assertions.assertEquals("ADD TO CART", driver.findElement(By.cssSelector(".btn_inventory")).getText());
        extentTest.log(Status.PASS, "O botão está 'ADD TO CART'");
    }

    @E("clica no botão BACK para retornar página do produto")
    public void clicaNoBotãoBACKParaRetornarPáginaDoProduto() {
        driver.findElement(By.cssSelector(".inventory_details_back_button")).click();
        extentTest.log(Status.INFO, "A Clica no botão 'BACK'");
    }

    @E("que o usuário está na página do carrinho")
    public void queOUsuárioEstáNaPáginaDoCarrinho() {
        driver.findElement(By.id("shopping_cart_container")).click();
        extentTest.log(Status.INFO, "A clica no botão 'CARRINHO'");
    }
}
