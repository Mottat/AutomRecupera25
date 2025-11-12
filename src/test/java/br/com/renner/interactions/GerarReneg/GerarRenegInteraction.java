package br.com.renner.interactions.GerarReneg;

import br.com.renner.pages.gerarReneg.GerarRenegPage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static br.com.renner.steps.hook.WebSetup.driver;
import static br.com.renner.steps.hook.WebSetup.seleniumRobotsTool;
import static br.com.renner.toolbox.RennerTools.*;
import static org.junit.Assert.assertEquals;

public class GerarRenegInteraction extends GerarRenegPage {

    public GerarRenegInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void menuRecebimentos(){
        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdRecebimentos()));
        seleniumRobotsTool.getElement(cmdRecebimentos()).click();
        selectcCframe1();
        aguardar(2);
        aguardoElementoClicavel(seleniumRobotsTool.getElement(txtReceb()));
        WebElement campoCodigo = driver.findElement(By.id("txtCodigo"));
        String codReceb = campoCodigo.getAttribute("value");
        System.out.println("Cod recebimento é: " + codReceb);

        setJsonData("codReceb", codReceb);
    }

    public void sairRecebimentos() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(botaoSairRec()));
        seleniumRobotsTool.getElement(botaoSairRec()).click();
    }
    public void estornarRecebimentos() {
//        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdEstornar()));
//        seleniumRobotsTool.getElement(cmdEstornar()).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();  // Clica no OK
//        alert.dismiss(); // Clica em Cancel

        aguardoElementoClicavel(seleniumRobotsTool.getElement(botaoSairRec()));
        seleniumRobotsTool.getElement(botaoSairRec()).click();

    }

    public void clicoMenuRetaguarda2() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(menuRetaguarda2()));
        seleniumRobotsTool.getElement(menuRetaguarda2()).click();
    }

    public void clicoMenuTarefa() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(menuTarefa()));
        seleniumRobotsTool.getElement(menuTarefa()).click();
    }

    public void clicoBtnBuscar() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdBuscar()));
        seleniumRobotsTool.getElement(cmdBuscar()).click();
    }

    public void informCodTarefa() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(txtCodTarefa()));
        seleniumRobotsTool.getElement(txtCodTarefa()).sendKeys("RENCDT3M");
    }

    public void PesquisoTarefa() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdAtuaPag()));
        seleniumRobotsTool.getElement(cmdAtuaPag()).click();
    }

    public void clicoTarefa() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(tarefaRENEG()));
        seleniumRobotsTool.getElement(tarefaRENEG()).click();
    }

    public void ExecutarTarefa() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdExecutarTarefa()));
        seleniumRobotsTool.getElement(cmdExecutarTarefa()).click();
    }

    public void VisualizarTarefas() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdVisuaTarefa()));
        seleniumRobotsTool.getElement(cmdVisuaTarefa()).click();
    }

    public void ExecucoesAnteriores() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(execAnterior()));
        seleniumRobotsTool.getElement(execAnterior()).click();
    }

    public void AtualizarPagina() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(cmdAtualizar()));
        seleniumRobotsTool.getElement(cmdAtualizar()).click();
    }

    public void AguardarStatusConcluido(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // tempo máximo total

        boolean concluido = false;
        long startTime = System.currentTimeMillis();

        while (!concluido && (System.currentTimeMillis() - startTime) < 60000) { // tenta por até 60 segundos
            try {
                // aguarda o status aparecer na tela
                WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(campoStatus()));
                String status = statusElement.getText().trim();
                System.out.println("Status atual: " + status);

                if (status.equalsIgnoreCase("Concluído")) {
                    concluido = true;
                    System.out.println("✅ Status chegou em Concluído!");
                    break;
                } else {
                    System.out.println("🔄 Status ainda não concluído, clicando em Atualizar...");
                    AtualizarPagina();
                    aguardar(3);
                }

            } catch (Exception e) {
                System.out.println("⚠️ Erro ao verificar status: " + e.getMessage());
                AtualizarPagina();
                aguardar(3);
            }
        }

        if (!concluido) {
            System.out.println("⏰ Tempo esgotado: o status não chegou em Concluído.");
        }
    }

    public void clicoMenuRetaguarda3() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(menuRetaguarda3()));
        seleniumRobotsTool.getElement(menuRetaguarda3()).click();
    }

    public void clicoMenuBoleto() {
        aguardoElementoClicavel(seleniumRobotsTool.getElement(menuBoleto2()));
        seleniumRobotsTool.getElement(menuBoleto2()).click();
    }

    public void informoNrRecebimento(){
        aguardoElementoClicavel(seleniumRobotsTool.getElement(txtNossoNum()));
        seleniumRobotsTool.getElement(txtNossoNum()).sendKeys(getJsonData("codReceb"));
    }

    public void inserirValorEsq(String recb){
        aguardoElementoClicavel(seleniumRobotsTool.getElement(txtNossoNum()));
        seleniumRobotsTool.getElement(txtNossoNum()).sendKeys(recb);
    }

    public void clicarConsultar(){
        seleniumRobotsTool.getElement(cmdConsultBoleto()).click();
    }

    public void informarDataCredito(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(txtDataCredito()));

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatoDataHora);

        WebElement campoDataCredito = seleniumRobotsTool.getElement(txtDataCredito());
        campoDataCredito.clear();
        campoDataCredito.sendKeys(dataHoraFormatada);

    }

    public void confirmarBoleto() {
        seleniumRobotsTool.getElement(cmdConfirmar()).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();  // Clica no OK
        alert.dismiss(); // Clica em Cancel

    }

    public void validarMsgBaixado(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement campo = wait.until(
                ExpectedConditions.visibilityOf(seleniumRobotsTool.getElement(msgBaixado()))
        );

        String mensagem = campo.getText().trim();
        Assert.assertEquals("BOLETO BAIXADO COM SUCESSO!!", mensagem);
    }

    public void botaoSair(){
        aguardoElementoClicavel(seleniumRobotsTool.getElement(btnExit()));
        seleniumRobotsTool.getElement(btnExit()).click();
    }
}
