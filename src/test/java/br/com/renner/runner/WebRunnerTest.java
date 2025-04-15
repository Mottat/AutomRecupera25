package br.com.renner.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.renner.steps",

//        tags = "@Login or @ConsultaCCR or @AcordoAVistaSemDescontoCCR or @CancelaAcordoCCR",
//        tags = "@Login or @ConsultaCBR or @AcordoAVistaSemDescontoCBR or @CancelaAcordoCBR",

//        tags = "@Login",


        //// Somente CCR
//        tags = "@ConsultaCCR",
//        tags = "@AcordoAVistaSemDescontoCCR",
//        tags = "@AcordoAVistaComDescontoCCR",
//        tags = "@AcordoParceladoSemDescontoCCR",
//        tags = "@AcordoParceladoComDescontoCCR",
//        tags = "@CancelaAcordoCCR",


        //// Somente CBR
//        tags = "@ConsultaCBR",
//        tags = "@AcordoAVistaSemDescontoCBR",
//        tags = "@AcordoAVistaComDescontoCBR",
//        tags = "@AcordoParceladoSemDescontoCBR",
//        tags = "@AcordoParceladoComDescontoCBR",
//        tags = "@CancelaAcordoCBR",


        //// Cenários Esquemas
//        tags = "@EsquemaConsultaCliente",
//        tags = "@EsquemaAcordoCliente",
        tags = "@EsquemaCancelaAcordoCliente",


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
public class WebRunnerTest {}