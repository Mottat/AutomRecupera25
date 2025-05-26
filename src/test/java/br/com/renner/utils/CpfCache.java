package br.com.renner.utils;

public class CpfCache {

    private static String cpfCCR;
    private static String cpfCBR;

    public static String getCpfCCR() {
        return cpfCCR;
    }

    public static void setCpfCCR(String cpf) {
        if (cpfCCR == null) {
            cpfCCR = cpf;
        }
    }

    public static String getCpfCBR() {
        return cpfCBR;
    }

    public static void setCpfCBR(String cpf) {
        if (cpfCBR == null) {
            cpfCBR = cpf;
        }
    }
}
