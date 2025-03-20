package br.com.renner.toolbox;

import static br.com.renner.toolbox.SetupTestRunProperties.*;

public class GlobalTools {

    public static String getExecutionNavegador() {
        String navegador = System.getProperty("navegador");
        if (navegador != null && navegador.length() > 0)
            return navegador.toLowerCase();

        return getConfigNavegador().toLowerCase();
    }

    public static String getTokenPerfecto() {
        return System.getProperty("tokenPerfecto", getConfigTokenPerfecto());
    }

    public static String getUrlPerfecto() {
        return System.getProperty("urlPerfecto", getConfigUrlPerfecto());
    }

    public static String getExecutionUrl() {
        String ambiente = getExecutionAmbiente();
        if (ambiente.toLowerCase().contains("hml")) {
            return getConfigUrlHml().replace("{AMBIENTE}", ambiente.toLowerCase());
        }
        return getConfigUrlPrd().toLowerCase();
    }

    public static String getExecutionAmbiente() {
        String ambiente = System.getProperty("ambiente");
        if (ambiente == null || ambiente.length() == 0) {
            ambiente = getConfigAmbiente();
        }
        return ambiente.toLowerCase();
    }

    public static String getExecutionUrlHml() {
        String ambiente = getExecutionAmbiente();
        if (ambiente.toLowerCase().contains("hml")) {
            return getConfigUrlHml().replace("{AMBIENTE}", ambiente.toLowerCase());
        }
        return getConfigUrlHml().replace("{AMBIENTE}", "hml");
    }

}
