package br.com.renner.utils;

import java.sql.*;

public class DatabaseUtils {
    private static final String URL = "jdbc:oracle:thin:@//rnnhmlo1exdb-w3gup-scan.lojasrenner.com.br:1521/ol09hml.hmldbcli.nonprodocivcn.oraclevcn.com";
    private static final String USER = "L926751DB";
    private static final String PASSWORD = "dbs$$2023";

    // Método genérico para buscar CPF
    private static String buscarCpf(String query) {
        String cpf = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                cpf = rs.getString("DES_CPF");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar CPF: " + e.getMessage());
            e.printStackTrace();
        }

        return cpf;
    }

    public static String buscarCpfClienteCCR() {
        String query = "SELECT R.DES_CPF " +
                "FROM RECUPERA.TBL_CARGA_PRESTACOES CP " +
                "JOIN RECUPERA.TBL_REGISTROS R ON R.DES_REGIS = CP.DES_REGIS AND R.COD_CREDOR = CP.COD_CREDOR " +
                "JOIN RECUPERA.TBL_REGISTROS_OPERACIONAL RO ON RO.DES_REGIS = CP.DES_REGIS " +
                "WHERE CP.COD_CREDOR = 3 " +
                "AND CP.COD_PRODUT IN ('CCRCFI', 'EPCFI') " +
                "AND CP.DAT_PROCE >= TO_DATE('01/10/2024', 'dd/mm/yyyy') " +
                "AND RO.TIP_STATU != 99 " +
                "AND R.DES_CPF NOT IN (33381091484, 52042057053, 85352301303, 38522116032, 11550518747, 39440375531, 54581527783) " +
                "AND NOT EXISTS (SELECT 1 FROM RECUPERA.TBL_RENEGOCIACAO REN WHERE REN.DES_REGIS = CP.DES_REGIS) " +
                "AND NOT EXISTS (SELECT 1 FROM RECUPERA.TBL_PARCELAMENTO PAR WHERE PAR.DES_REGIS = CP.DES_REGIS) " +
                "AND ROWNUM < 2";

        return buscarCpf(query);
    }

    public static String buscarCpfClienteCBR() {
        String query = "SELECT R.DES_CPF " +
                "FROM RECUPERA.TBL_CARGA_PRESTACOES CP " +
                "JOIN RECUPERA.TBL_REGISTROS R ON R.DES_REGIS = CP.DES_REGIS AND R.COD_CREDOR = CP.COD_CREDOR " +
                "JOIN RECUPERA.TBL_REGISTROS_OPERACIONAL RO ON RO.DES_REGIS = CP.DES_REGIS " +
                "WHERE CP.COD_CREDOR = 3 " +
                "AND CP.COD_PRODUT IN ('CBRCREL') " +
                "AND CP.DAT_PROCE >= TO_DATE('01/06/2024', 'dd/mm/yyyy') " +
                "AND RO.TIP_STATU != 99 " +
                "AND NOT EXISTS (SELECT 1 FROM RECUPERA.TBL_RENEGOCIACAO REN WHERE REN.DES_REGIS = CP.DES_REGIS) " +
                "AND NOT EXISTS (SELECT 1 FROM RECUPERA.TBL_PARCELAMENTO PAR WHERE PAR.DES_REGIS = CP.DES_REGIS) " +
                "AND ROWNUM < 2";

        return buscarCpf(query);
    }
}
