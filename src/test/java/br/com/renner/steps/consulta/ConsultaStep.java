package br.com.renner.steps.consulta;

import br.com.renner.interactions.login.LoginInteraction;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import br.com.renner.interactions.consulta.ConsultaInteraction;
import static br.com.renner.toolbox.RennerTools.*;

public class ConsultaStep {

    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou na pagina do recupera")
    public void queEstouNaPaginaDoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.loginSucesso();
        // Não precisa fazer login novamente, pois já foi feito no LoginStep
        // Não precisa trocar de janela novamente, pois já foi feito no LoginStep
    }

    @Quando("Clico em operacao")
    public void clicoEmOperacao() {
        consultaInteraction.menuOperacao();
    }

    @E("pesquiso pelo cliente {string}")
    public void pesquisoPeloCliente(String cliente) {
        selectIfrmAppPrinc();
        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.validaCredor();
        consultaInteraction.validProduto(cliente);
        consultaInteraction.botaoSair();
        defaultContent();
    }

    @Entao("consulta realizada com sucesso")
    public void consultaRealizadaComSucesso() {
        // Não precisa clicar em sair novamente, pois já foi feito no LoginStep
    }
}
