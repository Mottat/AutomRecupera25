package br.com.renner.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.ConsultaPage;

import java.time.Duration;

import static br.com.renner.steps.hook.WebSetup.*;
import static br.com.renner.toolbox.RennerTools.*;
import static org.junit.Assert.assertEquals;


public class ConsultaInteraction extends ConsultaPage {

    public ConsultaInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void aguardarMenuOperacao() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(menuOperation));
    }

    public void menuOperacao(){
        menuOperation.click();
    }


    public void codCliente(String cliente){
        inputTxtCodigo.click();

//        txtCampoCliente.sendKeys("05286578365");
//        txtCampoCliente.sendKeys(getJsonData("cntCCR"));
//        txtCampoCliente.sendKeys(getJsonData("cntCBR"));

        switch (cliente) {
            case "CCR":
                inputTxtCodigo.sendKeys(getJsonData("cntCCR"));                break;
            case "CBR":
                inputTxtCodigo.sendKeys(getJsonData("cntCBR"));
                break;
            default:
                throw new IllegalArgumentException("Cliente Desconhecido: " + cliente);
        }


//        if (WebSetup.scenario.getSourceTagNames().contains("@AcordoCCR")) {
//            txtCampoCliente.sendKeys(getJsonData("cntCCR"));
//        } else if (WebSetup.scenario.getSourceTagNames().contains("@AcordoCBR")) {
//            txtCampoCliente.sendKeys(getJsonData("cntCBR"));
//        }



//        if (scenario.getSourceTagNames().contains("@AcordoCCR") ||
//                scenario.getSourceTagNames().contains("@ConsultaCCR") ||
//                scenario.getSourceTagNames().contains("@CancelaAcordoCCR")) {
//            txtCampoCliente.sendKeys(getJsonData("cntCCR"));
//
//        } else if (scenario.getSourceTagNames().contains("@AcordoCBR")||
//                scenario.getSourceTagNames().contains("@ConsultaCBR") ||
//                scenario.getSourceTagNames().contains("@CancelaAcordoCBR")) {
//            txtCampoCliente.sendKeys(getJsonData("cntCBR"));
//        }
    }

    public void bntConsult(){
        searchButton.click();
    }

    public void abaDivida(){
        tapDebt.click();
    }


    public void validProduto(String cliente){
        switch (cliente) {
            case "CCR":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement campo = wait.until(ExpectedConditions.visibilityOf(listItemField));
                String valorCampo = campo.getAttribute("value");
                assertEquals("CCRCFI", valorCampo);
                break;
            case "CBR":
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement campo1 = wait1.until(ExpectedConditions.visibilityOf(listItemField));
                String valorCampo1 = campo1.getAttribute("value");
                assertEquals("CBRCREL", valorCampo1);
                break;
            default:
                throw new IllegalArgumentException("Cliente Desconhecido: " + cliente);
        }




    }

     public void validProdutoCCR(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(listItemField));
        String valorCampo = campo.getAttribute("value");
        assertEquals("CCRCFI", valorCampo);
    }

    public void validProdutoCBR(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(listItemField));
        String valorCampo = campo.getAttribute("value");
        assertEquals("CBRCREL", valorCampo);
    }

    public void botaoSair(){
        btnExit.click();
    }


    public void aguardarBotaoSair() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(btnExit));
    }
}
