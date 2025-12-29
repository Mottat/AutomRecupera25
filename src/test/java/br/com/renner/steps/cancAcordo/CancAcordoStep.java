package br.com.renner.steps.cancAcordo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import br.com.renner.interactions.acordo.AcordoInteraction;
import br.com.renner.interactions.cancAcordo.CancAcordoInteraction;
import br.com.renner.interactions.consulta.ConsultaInteraction;
import br.com.renner.interactions.login.LoginInteraction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.renner.pages.consulta.ConsultaPage.inputTxtCodigo;
import static br.com.renner.steps.hook.WebSetup.driver;
import static br.com.renner.steps.hook.WebSetup.seleniumRobotsTool;
import static br.com.renner.toolbox.RennerTools.*;

public class CancAcordoStep {

    CancAcordoInteraction cancAcordoInteraction = new CancAcordoInteraction();
    AcordoInteraction acordoInteraction = new AcordoInteraction();
    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou no recupera")
    public void queEstouNoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.loginSucesso();
    }

    @Quando("pesquiso cliente com acordo {string}")
    public void pesquisoClienteComAcordo(String cliente) {
        consultaInteraction.menuOperacao();

        selectIfrmAppPrinc();

        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.validaCredor();
    }

    @Quando("pesquiso clientes com acordo {string}")
    public void pesquisoClientesComAcordo(String cpf) {
        consultaInteraction.menuOperacao();

        selectIfrmAppPrinc();

//        inputTxtCodigo.sendKeys(cpf);
        seleniumRobotsTool.getElement(inputTxtCodigo()).sendKeys(cpf);
        consultaInteraction.bntConsult();
        consultaInteraction.validaCredor();
    }

    @E("cancelo acordo")
    public void canceloAcordo() {
        aguardar(2);

        acordoInteraction.desmTodasDividas();
        acordoInteraction.campoPagt();

        acordoInteraction.validarProdtParc();

        acordoInteraction.bntParc();

        selectcCframe1();

        cancAcordoInteraction.botaoExcluir();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        alerta.accept();

    }

    @Entao("acordo cancelado com sucesso")
    public void acordoCanceladoComSucesso() throws InterruptedException {
        defaultContent();
        selectIfrmAppPrinc();

        aguardar(1);

        // Sair da tela Operação
        consultaInteraction.botaoSair();
        defaultContent();

        loginInteraction.clicarSair();

    }

}
