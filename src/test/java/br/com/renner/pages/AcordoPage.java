package br.com.renner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AcordoPage {

    @FindBy(id = "cmdDesmarcarDividas")
    public static WebElement unmarkDebtCheckbox;

    @FindBy(id = "objLista005Header_00006")
    public static WebElement paymentDateCalendar;

    @FindBy(className = "CldObjDiaHoje")
    public static WebElement selectToday;

    @FindBy(xpath = "//*[@class='CldObjDiaHoje']/following::input[@class='CldObjDiasSemana'][1]")
    public static WebElement selectTomorrow;

    @FindBy(xpath = "//input[@value='PARC']")
    public List<WebElement> produtosParc;

    @FindBy(id = "objLista005Corpo_00000_00000")
    public static WebElement checkboxSelectDebt;

    @FindBy(id = "cmdMarcarDividas")
    public static WebElement btnSelectAllDebts;

    @FindBy(id = "cmdDesmarcarDividas")
    public static WebElement btnClearSelectAllDebts;

    @FindBy(id = "cmdParcelar")
    public static WebElement btnInstallment;

    @FindBy(id = "cmdAumentaParc")
    public static WebElement btnIncreaseParcel;

    @FindBy(id = "txtQtdParcelas")
    public static WebElement inputTxtQtdParcelas;

    @FindBy(id = "txtDesconto")
    public static WebElement inputTxtDesconto;

    @FindBy(id = "cmdCalcular")
    public static WebElement btnCalculate;

    @FindBy(id = "dtgParce_TextBox25_0")
    public static WebElement txtValidateParcel;

    @FindBy(id = "cmdConfirmar")
    public static WebElement btnConfirm;

    @FindBy(id = "txtComplementoOcorrencia")
    public static WebElement txtInsertOccurrence;

    @FindBy(id = "cmdOkComplOcorrencia")
    public static WebElement btnConfirmOccurrence;

    @FindBy(id = "objLista005Corpo_00000_00001")
    public static WebElement txtValidateInstallment;


}
