package steps.loginSistemaSawLabs;

import com.aventstack.extentreports.Status;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.tools.Report.extentTest;

public class LoginBase {

    WebDriver driver = DriverManager.getDriver();

    @Dado("que o usuário está na página de login do sistema Swag Labs")
    public void que_o_usuário_está_na_página_de_login_do_sistema_swag_labs() {
        extentTest.log(Status.INFO, "A tela está pagina de login do sistema Sauce Labs");
    }

    @Quando("o usuário preenche o campo {string} com {string}")
    public void o_usuário_preenche_o_campo(String campo, String string) {
        if (campo.equalsIgnoreCase("username")) {
            driver.findElement(By.id("user-name")).sendKeys(string);
            extentTest.log(Status.INFO, "Preenche do usuário: " + string);
        } else if (campo.equalsIgnoreCase("password")) {
            driver.findElement(By.id("password")).sendKeys(string);

        }
    }

    @E("o usuário deixa o campo {string} em branco")
    public void o_usuário_deixa_o_campo_password_em_branco(String campo) {
        if (campo.equalsIgnoreCase("username")) {
            driver.findElement(By.id("user-name")).clear();
            extentTest.log(Status.INFO, "Não preenche o email do usuário");
        } else if (campo.equalsIgnoreCase("password")) {
            driver.findElement(By.id("password")).clear();
            extentTest.log(Status.INFO, "Não preenche a senha do usuário");
        }
    }

    @E("o usuário clica no botão login")
    public void o_usuário_clica_no_botão_login() {
        driver.findElement(By.id("login-button")).click();
        extentTest.log(Status.INFO, "A clica no botão 'LOGIN'");
    }

    @Então("o sistema exibe a mensagem {string}")
    public void o_sistema_exibe_a_mensagem(String mensagem) throws IllegalAccessException {
        boolean disponivel = driver.findElement(By.cssSelector("#login_button_container > div > form > h3 > button")).isDisplayed();
        String imprimir = driver.findElement(By.cssSelector("#login_button_container > div > form > h3 > button")).getText();
        System.out.println(">>> " + disponivel);
        System.out.println(">>> " + imprimir);
        if (mensagem.contains(imprimir)) {
            extentTest.log(Status.INFO, "Mensagem exibiu: " + imprimir, Screenshot.screenshotBase64(driver));
        }
    }

    @Então("o sistema autentica o usuário")
    public void o_sistema_autentica_o_usuário() {
        extentTest.log(Status.INFO, "Entrando autentica");
    }

    @E("redireciona para a tela principal")
    public void redireciona_para_a_tela_principal() {
        extentTest.log(Status.INFO, "A tela está principal a página do sistema Sauce Labs");
    }
}