package br.com.renner.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.AcordoPage;

import java.time.Duration;

import static br.com.renner.steps.hook.WebSetup.*;
import static org.junit.Assert.assertEquals;

public class AcordoInteraction extends AcordoPage {

    public AcordoInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void desmDivida(){
        unmarkDebtCheckbox.click();
    }

    public void campoPagt(){
        paymentDateCalendar.click();
    }

    public void selectDiaHoje(){
        selectToday.click();
    }

    public void selectDiaAmanha(){
        selectTomorrow.click();
    }

    public void marcDivida(){
        checkboxSelectDebt.click();
    }

    public void marcTodasDividas(){
        btnSelectAllDebts.click();
    }


    public void bntParc(){
        btnInstallment.click();
    }

    public void informarQtd(String quantidade){
        inputTxtQtdParcelas.clear();
        inputTxtQtdParcelas.sendKeys(quantidade);
    }

        public void informarDesc(String desconto){
        inputTxtDesconto.clear();
        inputTxtDesconto.sendKeys(desconto);
    }



    public void bntCalc(){
        btnCalculate.click();
    }

    public void validarParcela(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(txtValidateParcel));
        String valorCampo = campo.getAttribute("value");
        assertEquals("000", valorCampo);
    }

    public void bntConf(){
        btnConfirm.click();
    }

    public void insertOcorrencia(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(txtInsertOccurrence));
        txtInsertOccurrence.sendKeys("Teste Automação");
    }

    public void bntConfOcorre(){
        btnConfirmOccurrence.click();
    }

    public void validParc(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOf(txtValidateInstallment));
        String valorCampo = campo.getAttribute("value");
        assertEquals("PARC", valorCampo);
    }


    public void aguardarBotaoConfirmar() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(btnConfirm));
    }
}
