package br.edu.ifpb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class repoAeroportosTXT implements repoAeroportosTXT_IF {
    private Map<String, String> aeroportos;

    private final Path CAMINHO_TXT = Path.of("/home/jose/Documentos/Engenharia da computação/2019.2/Labolatório de Programação Orientada a Objetos/Prova poo 3/proj-aeroportos/modulo-servidor/Arquivos//airports.txt");

    public repoAeroportosTXT() throws IOException {
        aeroportos = new TreeMap<>();
        txtToMap();
    }

    @Override
    public String listarAeroportoPor(String letra) throws RemoteException, IOException {
        String AUX = "";
        boolean cond = false;
        for (String a : aeroportos.keySet()) {
           if (a.startsWith(letra)) {
               AUX += (aeroportos.get(a) + "\n");
               cond = true;
           }
        }
        if (cond) {
            mapToTxt();
            return AUX;
        }
        return "Erro: nenhum aeroporto foi encontrado!";
    }

    @Override
    public String getNomeAeroporto(String id) throws RemoteException, IOException {
        if (aeroportos.containsKey(id)) return aeroportos.get(id);
        return "Erro: nenhum aeroporto foi encontrado!";
    }

    @Override
    public String editarNomeAeroporto(String id, String novoNome) throws RemoteException, IOException {
        if (aeroportos.containsKey(id)) {
            aeroportos.put(id, novoNome);
            mapToTxt();
            return "Nome do aeroporto atualizado com sucesso!";
        }
        return "Erro - não foi possível editar o nome";
    }

    @Override
    public void txtToMap() throws RemoteException, IOException {
        List<String> AUX = Files.readAllLines(CAMINHO_TXT);
        for (String a : AUX) {
            String[] AUX1 = a.split(",");
            aeroportos.put(AUX1[0], AUX1[1]);
        }
    }

    @Override
    public void mapToTxt() throws RemoteException, IOException {
        List<String> AUX = new ArrayList<>();
        for (String a : aeroportos.keySet()) {
            AUX.add(a.concat(",".concat(aeroportos.get(a))));
        }
        Files.write(CAMINHO_TXT, AUX, Charset.defaultCharset()
                , StandardOpenOption.CREATE
                , StandardOpenOption.TRUNCATE_EXISTING
                , StandardOpenOption.WRITE);
    }
}
