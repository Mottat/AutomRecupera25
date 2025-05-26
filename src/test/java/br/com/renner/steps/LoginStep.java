package br.com.renner.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import br.com.renner.interactions.LoginInteraction;
import static br.com.renner.toolbox.RennerTools.*;
public class LoginStep {

    LoginInteraction loginInteraction = new LoginInteraction();

    @Dado("que estou na pagina de login")
    public void queEstouNaPaginaDeLogin() {
        trocarParaNovaJanela();
//        loginInteraction.aguardarCampoUser();
    }

    @Quando("faço login com dados validos")
    public void facologincomdadosvalidos() {
        loginInteraction.loginSucesso();
    }

    @Entao("realizo login com sucesso")
    public void realizoLoginComSucesso() {
        loginInteraction.clicarSair();
    }

}
