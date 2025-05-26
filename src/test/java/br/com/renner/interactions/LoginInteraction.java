package br.com.renner.interactions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.LoginPage;
import static br.com.renner.steps.hook.WebSetup.*;

import java.time.Duration;

import static br.com.renner.toolbox.RennerTools.*;

public class LoginInteraction extends LoginPage {

    public LoginInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void loginSucesso() {
        esperarElementoVisivel(inputUser);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        String[] usuarios = {getJsonData("user1"), getJsonData("user2"), getJsonData("user3")};
        String senha = getJsonData("pass");

        for (String usuario : usuarios) {
            try {
                inputUser.clear();
                inputUser.sendKeys(usuario);

                inputPass.clear();
                inputPass.sendKeys(senha);

                clickDropdown.click();
                selectEmp.click();
                btnLogin.click();

                try {
                    Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
                    String mensagem = alerta.getText();
                    System.out.println("Mensagem do alerta: " + mensagem);

                    if (mensagem.equals("LIC_RL006: O Operador já esta conectado no sistema.") ||
                            mensagem.equals("A senha é inválida ou o login não existe.")) {

                        alerta.accept();
                        System.out.println("Tentando com próximo usuário...");
                        continue;
                    } else {
                        System.out.println("Mensagem inesperada: " + mensagem);
                        alerta.accept();
                        break;
                    }

                } catch (TimeoutException e) {
                    System.out.println("Login realizado com sucesso usando o usuário: " + usuario);
                    break;
                }

            } catch (UnhandledAlertException e) {
                System.out.println("Alerta não tratado a tempo. Encerrando tentativa.");
                try {
                    driver.switchTo().alert().accept();
                } catch (Exception ignored) {}
            }
        }
    }

    public void clicarSair() {
        esperarElementoVisivelClicavel(btnExit);
        btnExit.click();
    }


}