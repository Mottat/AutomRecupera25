package br.com.renner.interactions;

import io.cucumber.java.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.LoginPage;
import static br.com.renner.steps.hook.WebSetup.*;

import java.time.Duration;

import static br.com.renner.toolbox.RennerTools.*;
import static org.junit.Assert.assertEquals;

public class LoginInteraction extends LoginPage {

    public LoginInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void aguardarCampoUser() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(inputUser));
    }

    public void loginSucesso() {
        inputUser.click();
//        txtDigiteSeuUser.sendKeys("AUTOM1");
        inputUser.sendKeys(getJsonData("user1"));

        inputPass.click();
//        txtDigiteSuaSenha.sendKeys("renner100");
        inputPass.sendKeys(getJsonData("pass"));

        clickDropdown.click();
        selectEmp.click();

        btnLogin.click();

        try {
            Alert alerta = driver.switchTo().alert();

            if (alerta != null) {
                String mensagem = alerta.getText();
                System.out.println("Mensagem do alerta: " + mensagem);

                assertEquals("LIC_RL006: O Operador já esta conectado no sistema.", mensagem);

                alerta.accept();

                inputUser.clear();
                inputUser.sendKeys("AUTOM2");
//                txtDigiteSeuUser.sendKeys(getJsonData("user2"));
                inputPass.clear();
                inputPass.sendKeys("renner100");
//                txtDigiteSuaSenha.sendKeys(getJsonData("pass"));
                clickDropdown.click();
                selectEmp.click();
                btnLogin.click();

            }
        } catch (Exception e) {
//            System.out.println("Nenhum alerta foi exibido.");
        }

    }

    @After
    public void fecharConsulta() {
        aguardarBotaoSair();
        clicarSair();
    }

    public void aguardarBotaoSair() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(btnExit));
    }

    public void clicarSair() {
        btnExit.click();
    }


}