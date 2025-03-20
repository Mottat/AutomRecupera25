package br.com.renner.steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import br.com.renner.interactions.AcordoInteraction;
import br.com.renner.interactions.CancAcordoInteraction;
import br.com.renner.interactions.ConsultaInteraction;
import br.com.renner.interactions.LoginInteraction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.renner.steps.hook.WebSetup.driver;
import static br.com.renner.toolbox.RennerTools.*;

public class CancAcordoStep {

    CancAcordoInteraction cancAcordoInteraction = new CancAcordoInteraction();
    AcordoInteraction acordoInteraction = new AcordoInteraction();
    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou no recupera")
    public void queEstouNoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.aguardarCampoUser();
        loginInteraction.loginSucesso();
    }

    @Quando("pesquiso cliente com acordo {string}")
    public void pesquisoClienteComAcordo(String cliente) {
        consultaInteraction.aguardarMenuOperacao();
        consultaInteraction.menuOperacao();

        selectIfrmAppPrinc();

        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.abaDivida();
    }

    @E("cancelo acordo")
    public void canceloAcordo() {
        acordoInteraction.marcTodasDividas();

        acordoInteraction.bntParc();

        selectcCframe1();

        cancAcordoInteraction.botaoExcluir();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
//        Alert alerta = driver.switchTo().alert();
        alerta.accept();
    }

    @Entao("acordo cancelado com sucesso {string}")
    public void acordoCanceladoComSucesso(String cliente) throws InterruptedException {
        defaultContent();
        selectIfrmAppPrinc();

        Thread.sleep(5000);

        consultaInteraction.validProduto(cliente);

//        consultaInteraction.validProdutoCCR();
//        consultaInteraction.validProdutoCBR();//

        // Sair da tela Operação
        consultaInteraction.aguardarBotaoSair();
        consultaInteraction.botaoSair();
        defaultContent();

        loginInteraction.aguardarBotaoSair();
        loginInteraction.clicarSair();

    }

}
