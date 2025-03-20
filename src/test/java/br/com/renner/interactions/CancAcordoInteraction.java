package br.com.renner.interactions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.CancAcordoPage;

import java.time.Duration;

import static br.com.renner.steps.hook.WebSetup.*;


public class CancAcordoInteraction extends CancAcordoPage {

    public CancAcordoInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void marcAcordo(){
        checkboxSelectDeal.click();
    }

    public void botaoExcluir(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(btnDelete));
        btnDelete.click();
    }

}
