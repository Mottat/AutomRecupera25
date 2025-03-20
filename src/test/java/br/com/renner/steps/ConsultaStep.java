package br.com.renner.steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import br.com.renner.interactions.ConsultaInteraction;
import br.com.renner.interactions.LoginInteraction;
import static br.com.renner.toolbox.RennerTools.*;

public class ConsultaStep {

    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou na pagina do recupera")
    public void queEstouNaPaginaDoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.aguardarCampoUser();
        loginInteraction.loginSucesso();
    }

    @Quando("Clico em operacao")
    public void clicoEmOperacao() {
        consultaInteraction.aguardarMenuOperacao();
        consultaInteraction.menuOperacao();
    }

    @E("pesquiso pelo cliente {string}")
    public void pesquisoPeloCliente(String cliente) {
        selectIfrmAppPrinc();

        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.abaDivida();

        consultaInteraction.validProduto(cliente);

        consultaInteraction.aguardarBotaoSair();
        consultaInteraction.botaoSair();
        defaultContent();

    }

    @Entao("consulta realizada com sucesso")
    public void consultaRealizadaComSucesso() {
        loginInteraction.aguardarBotaoSair();
        loginInteraction.clicarSair();
    }


}
