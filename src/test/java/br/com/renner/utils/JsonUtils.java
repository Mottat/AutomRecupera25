package br.com.renner.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static final String FILE_PATH = "src/test/resources/configs/data/testData.json";

    // Atualiza o arquivo JSON com os CPFs armazenados no cache
    public static void atualizarCpfs() {
        String novoCntCCR = CpfCache.getCpfCCR();  // Pega o CPF do cache
        String novoCntCBR = CpfCache.getCpfCBR();  // Pega o CPF do cache

        if (novoCntCCR == null || novoCntCBR == null) {
            System.out.println("CPFs não definidos no cache. Não foi possível atualizar o arquivo.");
            return;  // Se não houver CPFs no cache, não faz nada
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            File file = new File(FILE_PATH);

            // Carrega o JSON existente
            ObjectNode root = (ObjectNode) mapper.readTree(file);

            // Atualiza os campos nos blocos desejados
            for (String bloco : new String[]{"Consulta", "Acordo", "CancelaAcordo"}) {
                ObjectNode blocoNode = (ObjectNode) root.get(bloco);
                if (blocoNode != null) {
                    blocoNode.put("cntCCR", novoCntCCR);
                    blocoNode.put("cntCBR", novoCntCBR);
                }
            }

            // Salva o arquivo atualizado
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
