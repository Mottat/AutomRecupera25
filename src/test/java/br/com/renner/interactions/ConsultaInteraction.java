package br.com.renner.interactions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.ConsultaPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static br.com.renner.steps.hook.WebSetup.*;
import static br.com.renner.toolbox.RennerTools.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ConsultaInteraction extends ConsultaPage {

    public ConsultaInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void menuOperacao(){
        esperarElementoVisivel(menuOperation);
        menuOperation.click();
    }


    public void codCliente(String cliente){
        inputTxtCodigo.click();

        switch (cliente) {
            case "CCR":
                inputTxtCodigo.sendKeys(getJsonData("cntCCR"));
                break;
            case "CBR":
                inputTxtCodigo.sendKeys(getJsonData("cntCBR"));
                break;
            default:
                throw new IllegalArgumentException("Cliente Desconhecido: " + cliente);
        }
    }

    public void bntConsult(){
        searchButton.click();
    }

    public void validaCredor(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        List<WebElement> elementos = driver.findElements(By.xpath("//td[text()='3']/parent::tr/td[1]/a"));

        if (!elementos.isEmpty()) {
            elementos.get(0).click();
            System.out.println("CPF clicado com sucesso!");
        } else {
            System.out.println("Elemento não encontrado. Seguindo o fluxo...");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        tapDebt.click();
    }

    public void validProduto(String cliente) {
        WebElement campo = esperarElementoVisivel(listItemField);

        String valorCampo = campo.getAttribute("value");

        switch (cliente) {
            case "CCR":
                List<String> valoresValidosCCR = Arrays.asList("CCRCFI", "EPCFI", "FACRELI");
                assertTrue("Valor inválido para cliente CCR: " + valorCampo, valoresValidosCCR.contains(valorCampo));
                break;
            case "CBR":
                assertEquals("CBRCREL", valorCampo);
                break;
            default:
                throw new IllegalArgumentException("Cliente Desconhecido: " + cliente);
        }
    }

    public void botaoSair(){
        esperarElementoVisivel(btnExit);
        btnExit.click();
    }
}
