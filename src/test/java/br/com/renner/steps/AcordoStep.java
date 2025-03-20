package br.com.renner.steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import br.com.renner.interactions.AcordoInteraction;
import br.com.renner.interactions.ConsultaInteraction;
import br.com.renner.interactions.LoginInteraction;

import static br.com.renner.toolbox.RennerTools.*;

public class AcordoStep {

    AcordoInteraction acordoInteraction = new AcordoInteraction();
    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou na pagina inicial do recupera")
    public void queEstouNaPaginaInicialDoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.aguardarCampoUser();
        loginInteraction.loginSucesso();
    }

    @Quando("Clico no menu operacao")
    public void ClicoNoMenuOperacao() {
        consultaInteraction.aguardarMenuOperacao();
        consultaInteraction.menuOperacao();
    }

    @E("faço um acordo {string}")
    public void facoUmAcordo(String cliente) throws InterruptedException {
        selectIfrmAppPrinc();

        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.abaDivida();
        acordoInteraction.desmDivida();
        acordoInteraction.campoPagt();

        acordoInteraction.selectDiaAmanha();
//        acordoTasks.selectDiaHoje();

        consultaInteraction.validProduto(cliente);

//        consultaInteraction.validProdutoCCR();
//        consultaInteraction.validProdutoCBR();//

        // consultaTasks.marcDivida();
        acordoInteraction.marcTodasDividas();
        acordoInteraction.bntParc();


        selectcCframe1();

        acordoInteraction.aguardarBotaoConfirmar();

        acordoInteraction.aumentParc();
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
        Thread.sleep(5000);

        acordoInteraction.validParc();

        // Sair da tela Operação
        consultaInteraction.aguardarBotaoSair();
        consultaInteraction.botaoSair();
        defaultContent();

        loginInteraction.aguardarBotaoSair();
        loginInteraction.clicarSair();
    }

}
