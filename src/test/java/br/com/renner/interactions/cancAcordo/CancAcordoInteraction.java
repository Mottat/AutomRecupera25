package br.com.renner.interactions.cancAcordo;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.renner.pages.cancAcordo.CancAcordoPage;

import java.time.Duration;

import static br.com.renner.steps.hook.WebSetup.*;


public class CancAcordoInteraction extends CancAcordoPage {

    public CancAcordoInteraction() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void marcAcordo(){
        seleniumRobotsTool.getElement(checkboxSelectDeal()).click();
    }

    public void botaoExcluir(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(seleniumRobotsTool.getElement(btnDelete())));
        seleniumRobotsTool.getElement(btnDelete()).click();
    }

}
