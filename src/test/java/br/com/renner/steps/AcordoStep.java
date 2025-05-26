package br.com.renner.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import br.com.renner.interactions.AcordoInteraction;
import br.com.renner.interactions.ConsultaInteraction;
import br.com.renner.interactions.LoginInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.renner.steps.hook.WebSetup.driver;
import static br.com.renner.toolbox.RennerTools.*;

public class AcordoStep {

    AcordoInteraction acordoInteraction = new AcordoInteraction();
    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou na pagina inicial do recupera")
    public void queEstouNaPaginaInicialDoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.loginSucesso();
    }

    @Quando("clico no menu operacao")
    public void clicoNoMenuOperacao() {
        consultaInteraction.menuOperacao();
    }

    @E("faço um acordo {string} e {string} e {string}")
    public void facoUmAcordo(String cliente, String quantidade, String desconto) throws InterruptedException {
        selectIfrmAppPrinc();

        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.validaCredor();
        acordoInteraction.desmDivida();
        acordoInteraction.campoPagt();

        acordoInteraction.selectDiaHoje();

        consultaInteraction.validProduto(cliente);

        acordoInteraction.marcTodasDividas();
        acordoInteraction.bntParc();

        selectcCframe1();

        acordoInteraction.aguardarBotaoConfirmar();

//        acordoInteraction.informarQtd(quantidade);
//        acordoInteraction.informarDesc(desconto);
        acordoInteraction.informarQtd(String.valueOf(Integer.parseInt(quantidade)));
        acordoInteraction.informarDesc(String.valueOf(Integer.parseInt(desconto)));

        acordoInteraction.bntCalc();
        acordoInteraction.validarParcela();

        acordoInteraction.bntConf();

        selectcCframe3();

        acordoInteraction.insertOcorrencia();
        acordoInteraction.bntConfOcorre();

        defaultContent();
        selectIfrmAppPrinc();
    }

    @Entao("acordo criado com sucesso")
    public void acordoCriadoComSucesso() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@value='PARC']")));

        acordoInteraction.validParc();

        // Sair da tela Operação
        consultaInteraction.botaoSair();
        defaultContent();

        loginInteraction.clicarSair();
    }

}
