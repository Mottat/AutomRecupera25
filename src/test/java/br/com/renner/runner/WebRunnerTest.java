package br.com.renner.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.renner.steps",

//        tags = "@Login",

        //// CCR
//        tags = "@ConsultaCCR",
//        tags = "@AVistaSemDescontoCCR",
//        tags = "@AVistaComDescontoCCR",
//        tags = "@ParceladoSemDescontoCCR",
//        tags = "@ParceladoComDescontoCCR",
//        tags = "@CancAcordoCCR",

//        tags = "@Login or @ConsultaCCR or @ParceladoComDescontoCCR or @CancAcordoCCR",

        //// CBR
//        tags = "@ConsultaCBR",
//        tags = "@AVistaSemDescontoCBR",
//        tags = "@AVistaComDescontoCBR",
//        tags = "@ParceladoSemDescontoCBR",
//        tags = "@ParceladoComDescontoCBR",
//        tags = "@CancAcordoCBR",

//        tags = "@Login or @ConsultaCBR or @ParceladoComDescontoCBR or @CancAcordoCBR",

        //// Cenários Esquemas
//        tags = "@EsqConsultaCliente",
//        tags = "@EsqAcordoCliente",
//        tags = "@EsqCancAcordoCliente",
//        tags = "@EsqCancAcordoLista",

//        tags = "@Login or @EsqConsultaCliente or @EsqAcordoCliente or @EsqCancAcordoCliente",

        plugin = {
                "pretty",
                "html:reports/cucumber.html",
                "json:reports/cucumber.json",
                "junit:reports/cucumber.xml",
        }
)
public class WebRunnerTest {}