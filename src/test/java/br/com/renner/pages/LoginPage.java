package br.com.renner.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "txtOperador")
    public static WebElement inputUser;

    @FindBy(id = "txtSenha")
    public static WebElement inputPass;

    @FindBy(id = "cmdEmpresa")
    public static WebElement clickDropdown;

    @FindBy(id = "dtgEmpresa_TextBox1_0")
    public static WebElement selectEmp;

    @FindBy(id = "cmdOk")
    public static WebElement btnLogin;

    @FindBy(xpath = "//td[text()='Sair']")
    public static WebElement btnExit;
}
