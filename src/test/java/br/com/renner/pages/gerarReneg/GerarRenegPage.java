package br.com.renner.pages.gerarReneg;

import org.openqa.selenium.By;

public class GerarRenegPage {

    public static By cmdRecebimentos() { return By.id("cmdRecebimentos"); }

//    public static By botaoSairRec() { return By.className("commandButtons"); }

    public static By botaoSairRec() { return By.id("cmdSair"); }

//    public static By botaoSair() { return By.id("cmdSair"); }

    public static By cmdReceb() { return By.id("cmdRecebimentos"); }

    public static By txtReceb() { return By.id("txtCodigo"); }

    public static By cmdEstornar() { return By.id("cmdEstornar"); }

    public static By cmdSairOper() { return By.id("cmdSair"); }

    public static By menuRetaguarda2() { return By.xpath("(//td[text()='Retaguarda'])[2]"); }

    public static By menuTarefa() { return By.xpath("(//td[text()='Tarefa'])[2]"); }

    public static By cmdBuscar() { return By.id("cmdBuscar"); }

    public static By txtCodTarefa() { return By.id("txtCodigo"); }

    public static By cmdAtuaPag() { return By.id("cmdAtualizarPagina"); }

    public static By tarefaRENEG() { return By.xpath("//a[normalize-space(text())='RENCDT3M']"); }

    public static By cmdExecutarTarefa() { return By.id("cmdExecutar"); }

    public static By cmdVisuaTarefa() { return By.id("cmdVisualizaTarefa"); }

    public static By execAnterior() { return By.id("optExecAnt"); }

    public static By cmdAtualizar() { return By.id("cmdAtualizar"); }

    public static By campoStatus() { return By.xpath("//span[@id='dtgVisualizar_Label9_0']"); }

    public static By menuRetaguarda3() { return By.xpath("(//td[text()='Retaguarda'])[3]"); }

    public static By menuBoleto2() { return By.xpath("(//td[text()='Boleto'])[2]"); }

    public static By txtNossoNum() { return By.id("txtNossoNumero"); }

    public static By cmdConsultBoleto() { return By.id("cmdConsultarBoleto"); }

    public static By txtDataPagto() { return By.id("txtDataPagto"); }

    public static By txtDataCredito() { return By.id("txtDataCredito"); }

    public static By cmdConfirmar() { return By.id("cmdConfirmar"); }

    public static By msgBaixado() { return By.id("lblMsg"); }

    public static By btnExit() { return By.xpath("//td[text()='Sair']"); }

}
