package br.edu.ifpb.poo;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ServidorDeSignos implements ObjetosRemotos_IF {
    private Map<String, List<String>> mapaSignos;
    private final Random r = new Random();

    public ServidorDeSignos() {
        mapaSignos = new HashMap<>();
        mapaSignos.put("Oi", Arrays.asList("aeae", "tudo bem", "quanto tempo", "quecoisa feia glr"));
        mapaSignos.put("Tu", Arrays.asList("menimo", "tudo", "tempo", "que coisa glr"));
    }

    @Override
    public String getMensagemSigno(String signo) {
        List<String> AUX = mapaSignos.get(signo);
        int randomPosi = r.nextInt(AUX.size());
        return AUX.get(randomPosi);
    }

    @Override
    public String getSignosDisponiveis() {
        return mapaSignos.keySet().stream().collect(Collectors.joining(","));
    }
}