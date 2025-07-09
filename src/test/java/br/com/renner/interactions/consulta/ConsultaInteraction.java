package br.com.renner.interactions.consulta;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import br.com.renner.pages.consulta.ConsultaPage;

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
        aguardoElementoClicavel(seleniumRobotsTool.getElement(menuOperation()));
        seleniumRobotsTool.getElement(menuOperation()).click();
    }


    public void codCliente(String cliente){
        seleniumRobotsTool.getElement(inputTxtCodigo()).click();

        switch (cliente) {
            case "CCR":
                seleniumRobotsTool.getElement(inputTxtCodigo()).sendKeys(getJsonData("cntCCR"));
                break;
            case "CBR":
                seleniumRobotsTool.getElement(inputTxtCodigo()).sendKeys(getJsonData("cntCBR"));
                break;
            default:
                seleniumRobotsTool.getElement(inputTxtCodigo()).sendKeys(cliente);
        }
    }

    public void bntConsult(){
        seleniumRobotsTool.getElement(searchButton()).click();
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

        seleniumRobotsTool.getElement(tapDebt()).click();
    }

    public void validProduto(String cliente) {
        WebElement campo = seleniumRobotsTool.getElement(listItemField());

        aguardoElementoClicavel(seleniumRobotsTool.getElement(listItemField()));

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
        aguardoElementoClicavel(seleniumRobotsTool.getElement(btnExit()));
        seleniumRobotsTool.getElement(btnExit()).click();
    }
}
