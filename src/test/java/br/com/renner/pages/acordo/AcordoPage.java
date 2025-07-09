package br.com.renner.pages.acordo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AcordoPage {

    public static By unmarkDebtCheckbox() { return By.id("cmdDesmarcarDividas"); }

    public static By paymentDateCalendar() { return By.id("objLista005Header_00006"); }

    public static By selectToday() { return By.className("CldObjDiaHoje"); }

    public static By selectTomorrow() { return By.id("//*[@class='CldObjDiaHoje']/following::input[@class='CldObjDiasSemana'][1"); }

    public static By produtosParc() { return By.xpath("//input[@value='PARC']"); }

    public static By checkboxSelectDebt() { return By.id("objLista005Corpo_00000_00000"); }

    public static By btnSelectAllDebts() { return By.id("cmdMarcarDividas"); }

    public static By btnClearSelectAllDebts() { return By.id("cmdDesmarcarDividas"); }

    public static By btnInstallment() { return By.id("cmdParcelar"); }

    public static By btnIncreaseParcel() { return By.id("cmdAumentaParc"); }

    public static By inputTxtQtdParcelas() { return By.id("txtQtdParcelas"); }

    public static By inputTxtDesconto() { return By.id("txtDesconto"); }

    public static By btnCalculate() { return By.id("cmdCalcular"); }

    public static By txtValidateParcel() { return By.id("dtgParce_TextBox25_0"); }

    public static By btnConfirm() { return By.id("cmdConfirmar"); }

    public static By txtInsertOccurrence() { return By.id("txtComplementoOcorrencia"); }

    public static By btnConfirmOccurrence() { return By.id("cmdOkComplOcorrencia"); }

    public static By txtValidateInstallment() { return By.id("objLista005Corpo_00000_00001"); }

}
