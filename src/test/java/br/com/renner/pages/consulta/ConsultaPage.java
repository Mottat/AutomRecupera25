package br.com.renner.pages.consulta;

import org.openqa.selenium.By;

public class ConsultaPage {

    public static By menuOperation() { return By.xpath("//td[text()='Operação']"); }

    public static By inputTxtCodigo() { return By.id("txtCodigo"); }

    public static By searchButton() { return By.id("cmdConsultar"); }

    public static By campoCPF() { return By.name("name=\"txtCpfCnpj\""); }

    public static By selectCredor() { return By.xpath("//td[text()='3']/parent::tr/td[1]/a"); }

    public static By tapDebt() { return By.id("tbcDivida"); }

    public static By listItemField() { return By.id("objLista005Corpo_00000_00001"); }

    public static By btnExit() { return By.id("cmdSair"); }

}
