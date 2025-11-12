package br.com.renner.interactions.acordo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.acordo.AcordoPage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static br.com.renner.steps.hook.WebSetup.*;
import static org.junit.Assert.assertEquals;

public class AcordoInteraction extends AcordoPage {

    public AcordoInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void desmDivida(){
        seleniumRobotsTool.getElement(unmarkDebtCheckbox()).click();
    }

    public void campoPagt(){
        seleniumRobotsTool.getElement(paymentDateCalendar()).click();
    }

    public void selectDiaHoje(){
        seleniumRobotsTool.getElement(selectToday()).click();
    }

    public void selectDiaAmanha(){
        seleniumRobotsTool.getElement(selectTomorrow()).click();
    }

    public void marcDivida(){
        seleniumRobotsTool.getElement(checkboxSelectDebt()).click();
    }

    public void validarProdtParc(){
        List<WebElement> produtos = seleniumRobotsTool.getElements(produtosParc());

        if (!produtos.isEmpty()) {
            WebElement checkbox = produtos.get(0).findElement(By.xpath("preceding::input[@type='checkbox'][1]"));
            checkbox.click();
        }
    }

    public void marcTodasDividas(){
        seleniumRobotsTool.getElement(btnSelectAllDebts()).click();
    }

    public void desmTodasDividas(){
        seleniumRobotsTool.getElement(btnClearSelectAllDebts()).click();
    }


    public void bntParc(){
        seleniumRobotsTool.getElement(btnInstallment()).click();
    }

    public void informarQtd(String quantidade){
        seleniumRobotsTool.getElement(inputTxtQtdParcelas()).clear();
        seleniumRobotsTool.getElement(inputTxtQtdParcelas()).sendKeys(quantidade);
    }

        public void informarDesc(String desconto){
            seleniumRobotsTool.getElement(inputTxtDesconto()).clear();
            seleniumRobotsTool.getElement(inputTxtDesconto()).sendKeys(desconto);
    }



    public void bntCalc(){
        seleniumRobotsTool.getElement(btnCalculate()).click();
    }

    public void validarParcela(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(seleniumRobotsTool.getElement(txtValidateParcel())));
        String valorCampo = campo.getAttribute("value");
        assertEquals("000", valorCampo);
    }

    public void bntConf(){
        seleniumRobotsTool.getElement(btnConfirm()).click();
    }

    public void insertOcorrencia(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(seleniumRobotsTool.getElement(txtInsertOccurrence())));

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatoDataHora);

        String nomeDoCenario = scenarioName;

        seleniumRobotsTool.getElement(txtInsertOccurrence()).sendKeys("Teste Automação - " + nomeDoCenario + " - ", dataHoraFormatada, " ");
    }

    public void bntConfOcorre(){
        seleniumRobotsTool.getElement(btnConfirmOccurrence()).click();
    }

    public void validParc(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(seleniumRobotsTool.getElement(txtValidateInstallment())));
        String valorCampo = campo.getAttribute("value");
        assertEquals("PARC", valorCampo);
    }


    public void aguardarBotaoConfirmar() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(seleniumRobotsTool.getElement(btnConfirm())));
    }
}
