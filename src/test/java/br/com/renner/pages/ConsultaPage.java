package br.com.renner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultaPage {

    @FindBy(xpath = "//td[text()='Operação']")
    public static WebElement menuOperation;

    @FindBy(id = "txtCodigo")
    public static WebElement inputTxtCodigo;

    @FindBy(id = "cmdConsultar")
    public static WebElement searchButton;

    @FindBy(name = "name=\"txtCpfCnpj\"")
    public static WebElement campoCPF;

    @FindBy(id = "tbcDivida")
    public static WebElement tapDebt;

    @FindBy(id = "objLista005Corpo_00000_00001")
    public static WebElement listItemField;

    @FindBy(id = "cmdSair")
    public static WebElement btnExit;

}
