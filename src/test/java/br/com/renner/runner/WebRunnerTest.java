package br.com.renner.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.renner.steps",

//        tags = "@Login",

        //// Somente CCR
//        tags = "@ConsultaCCR",
//        tags = "@AcordoCCR",
//        tags = "@CancelaAcordoCCR",
//        tags = "@ConsultaCCR and @AcordoCCR and @CancelaAcordoCCR",

        //// Somente CBR
//        tags = "@ConsultaCBR",
//        tags = "@AcordoCBR",
//        tags = "@CancelaAcordoCBR",
//        tags = "@ConsultaCBR and @AcordoCBR and @CancelaAcordoCBR",

        //// Cenários Esquemas
        tags = "@ConsultaCliente",    // Esquema
//        tags = "@AcordoCliente",    // Esquema
//        tags = "@CancelaAcordoCliente",    // Esquema

        //// Todos os cenários
//        tags = "@Consulta",
//        tags = "@Acordo",
//        tags = "@CancelaAcordo",

        plugin = {
                "pretty",
                "html:reports/cucumber.html",
                "json:reports/cucumber.json",
                "junit:reports/cucumber.xml",
        }
)
public class WebRunnerTest {
}