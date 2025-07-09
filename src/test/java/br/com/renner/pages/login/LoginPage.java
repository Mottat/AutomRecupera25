package br.com.renner.pages.login;

import org.openqa.selenium.By;

public class LoginPage {

    public static By inputUser() { return By.id("txtOperador"); }

    public static By inputPass() { return By.id("txtSenha"); }

    public static By clickDropdown() { return By.id("cmdEmpresa"); }

    public static By selectEmp() { return By.id("dtgEmpresa_TextBox1_0"); }

    public static By btnLogin() { return By.id("cmdOk"); }

    public static By btnExit() { return By.xpath("//td[text()='Sair']"); }
}
