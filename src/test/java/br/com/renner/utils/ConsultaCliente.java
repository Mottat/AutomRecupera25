package br.com.renner.utils;

public class ConsultaCliente {
    public static void main(String[] args) {
        String cpf = DatabaseUtils.buscarCpfClienteCCR();
//        String cpf = DatabaseUtils.buscarCpfClienteCBR();

        System.out.println("CPF buscado do banco: " + cpf);
    }
}
