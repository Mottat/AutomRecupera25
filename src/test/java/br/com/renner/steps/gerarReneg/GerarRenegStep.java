package br.com.renner.steps.gerarReneg;

import br.com.renner.interactions.GerarReneg.GerarRenegInteraction;
import br.com.renner.interactions.acordo.AcordoInteraction;
import br.com.renner.interactions.consulta.ConsultaInteraction;
import br.com.renner.interactions.login.LoginInteraction;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static br.com.renner.pages.consulta.ConsultaPage.inputTxtCodigo;
import static br.com.renner.pages.gerarReneg.GerarRenegPage.txtNossoNum;
import static br.com.renner.steps.hook.WebSetup.driver;
import static br.com.renner.steps.hook.WebSetup.seleniumRobotsTool;
import static br.com.renner.toolbox.RennerTools.*;

public class GerarRenegStep {

    GerarRenegInteraction gerarRenegInteraction = new GerarRenegInteraction();
    AcordoInteraction acordoInteraction = new AcordoInteraction();
    ConsultaInteraction consultaInteraction = new ConsultaInteraction();
    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou logado recupera")
    public void queEstouLogadoRecupera() {
        trocarParaNovaJanela();
        loginInteraction.loginSucesso();
    }

    @Quando("consulto codigo de recebimento {string}")
    public void consultCodidReceb(String cliente) {
        consultaInteraction.menuOperacao();
        selectIfrmAppPrinc();
//        seleniumRobotsTool.getElement(inputTxtCodigo()).sendKeys(cliente);
        consultaInteraction.codCliente(cliente);
        consultaInteraction.bntConsult();
        consultaInteraction.validaCredor();
        gerarRenegInteraction.menuRecebimentos();
        gerarRenegInteraction.sairRecebimentos();

        defaultContent();
        selectIfrmAppPrinc();

        aguardar(1);

        // Sair da tela Operação
        consultaInteraction.botaoSair();
        defaultContent();
    }

    @Quando("consulto o codigo de recebimento {string}")
    public void consultoCodigoRecebimento(String cpf) {
        consultaInteraction.menuOperacao();
        selectIfrmAppPrinc();
        seleniumRobotsTool.getElement(inputTxtCodigo()).sendKeys(cpf);
        consultaInteraction.bntConsult();
        consultaInteraction.validaCredor();
        gerarRenegInteraction.menuRecebimentos();
        gerarRenegInteraction.sairRecebimentos();

        defaultContent();
        selectIfrmAppPrinc();

        aguardar(1);

        // Sair da tela Operação
        consultaInteraction.botaoSair();
        defaultContent();
    }

    @E("realizo o pagamento do boleto")
    public void realizoPagamentoPboleto() {
        gerarRenegInteraction.clicoMenuRetaguarda3();
        gerarRenegInteraction.clicoMenuBoleto();
        gerarRenegInteraction.informoNrRecebimento();
        gerarRenegInteraction.clicarConsultar();
        gerarRenegInteraction.informarDataCredito();
        gerarRenegInteraction.confirmarBoleto();
    }

    @E("executo a tarefa de geracao de renegociacao")
    public void executoTarefaGeracaoRenegociacao() {
        gerarRenegInteraction.clicoMenuRetaguarda2();
        gerarRenegInteraction.clicoMenuTarefa();
        aguardar(2);
        gerarRenegInteraction.clicoBtnBuscar();
        gerarRenegInteraction.informCodTarefa();
        gerarRenegInteraction.PesquisoTarefa();
        gerarRenegInteraction.clicoTarefa();
        gerarRenegInteraction.ExecutarTarefa();
        gerarRenegInteraction.VisualizarTarefas();
        gerarRenegInteraction.ExecucoesAnteriores();
        gerarRenegInteraction.AtualizarPagina();
        gerarRenegInteraction.AguardarStatusConcluido(driver);
    }

    @Entao("a renegociacao e criada com sucesso")
    public void renegociacaoCriadaComSucesso() {
        gerarRenegInteraction.botaoSair();
    }

    @Quando("pago boleto de {string}")
    public void pagoBoletoRecebimnento(String recb) {
        gerarRenegInteraction.clicoMenuRetaguarda3();
        gerarRenegInteraction.clicoMenuBoleto();
        gerarRenegInteraction.inserirValorEsq(recb);
        gerarRenegInteraction.clicarConsultar();
        gerarRenegInteraction.informarDataCredito();
        gerarRenegInteraction.confirmarBoleto();
    }

    @Entao("boleto pago com sucesso")
    public void boletoPagoComSucesso() {
        gerarRenegInteraction.validarMsgBaixado();
        gerarRenegInteraction.botaoSair();
    }

}