package br.com.renner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CancAcordoPage {

    @FindBy(id = "objLista005Corpo_00000_00000")
    public static WebElement checkboxSelectDeal;

    @FindBy(id = "cmdExcluir")
    public static WebElement btnDelete;

}
