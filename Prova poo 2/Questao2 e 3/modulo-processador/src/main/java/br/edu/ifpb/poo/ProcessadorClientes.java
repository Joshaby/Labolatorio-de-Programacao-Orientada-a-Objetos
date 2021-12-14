package br.edu.ifpb.poo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessadorClientes implements Iterable<Cliente> {
    private Set<Cliente> clientes;
    private Map<Integer, List<Integer>> clientesMaiorDezeito;

    public Set<Cliente> lerTodosClientes(Path pathOrigem) throws IOException {
        // Pega os clientes de um txt e joga em List
        // É usado o método split para quebrar a String e gerar um lista de String
        // Depois é feito um cast de número em String para int usando o método Integer.parseInt
        List<String> AUX = Files.readAllLines(pathOrigem);
        this.clientes = new HashSet<>();
        for (String c : AUX) {
            String[] AUX1 = c.split(";");
            clientes.add(new Cliente(Integer.parseInt(AUX1[0]), AUX1[1], AUX1[2], Integer.parseInt(AUX1[3]), AUX1[4], AUX1[5], AUX1[6], Integer.parseInt(AUX1[7])));
        }
        return clientes;
    }

    public void salvarClientesOrdenadosPor(Path pathDestino, Comparator<Cliente> comparator) throws IOException {
        // Cria um TreeSet de clientes usando um comparator, para ordenar e tirar duplicatas
        // è adiconado todos os clientes no Set clientes em clientesOrdenados
        //      clientesOrdenados.stream().map(Cliente::toString).collect(Collectors.toList())
        //      Esse código pega o fluxo de dados, mapea os toString de cada cliente e joga esses toString e joga num List
        // Depois cada String na List é escrita no path
        TreeSet<Cliente> clientesOrdenados = new TreeSet<>(comparator);
        clientesOrdenados.addAll(this.clientes);
        List<String> clientesOrdenadosString = clientesOrdenados.stream().map(Cliente::toString).collect(Collectors.toList());
        for (Cliente c : clientesOrdenados) {
            clientesOrdenadosString.add(c.toString());
        }
        Files.write(pathDestino, clientesOrdenadosString, Charset.defaultCharset()
                , StandardOpenOption.CREATE
                , StandardOpenOption.TRUNCATE_EXISTING
                , StandardOpenOption.WRITE);
    }

    public Set<Cliente> getMaioresDezoito() {
        // filtra os clientes pela idade e joga num Set
        return clientes.stream().filter(cliente -> cliente.getIdade() >= 18).collect(Collectors.toSet());
    }

    public void salvarClientes(Path pathDestino) throws IOException {
        // vê função salvarClientesOrdenadosPor
        salvarClientesOrdenadosPor(pathDestino, Comparator.naturalOrder());
    }

    public Map<Integer, List<Integer>> agrupatClientesPorIdade() {
        // Set<Integer> idades = pega o fluxo de dados de clientes, mapea a idade dos clientes e joga num Set
        //      clientes.stream().filter(cliente -> cliente.getIdade() == c).map(Cliente::getCodigo).collect(Collectors.toList())
        //      pega o fluxo de dados de clientes, filtra os clientes por um c que é uma idade, mapea o codigo e joga num List
        Set<Integer> idades = clientes.stream().map(Cliente::getIdade).collect(Collectors.toSet());
        clientesMaiorDezeito = new HashMap<>();
        for (int c : idades) {
            clientesMaiorDezeito.put(c, clientes.stream().filter(cliente -> cliente.getIdade() == c).map(Cliente::getCodigo).collect(Collectors.toList()));
        }
        return clientesMaiorDezeito;
    }
    
    public void gravarMapaClientes(Path pathDestino) throws IOException {
        // Cria um List<String> mapaClientes para pegar as String
        // Primeiro, vai ser criado um String para concatenar as idades com os IDs dos clientes com essa idade
        // Depois é escrito num arquivo
        List<String> mapaClientes = new ArrayList<>();
        for (int c : clientesMaiorDezeito.keySet()) {
            StringBuilder AUX = new StringBuilder();
            List<Integer> AUX1 = clientesMaiorDezeito.get(c);
            for (int i = 0; i < AUX1.size(); i ++) {
                if (i != AUX1.size() - 1) AUX.append(AUX1.get(i)).append(", ");
                else AUX.append(AUX1.get(i));
            }
            mapaClientes.add(String.format("%d ; [%s]\n", c, AUX.toString()));
        }
        Files.write(pathDestino, mapaClientes, Charset.defaultCharset()
                , StandardOpenOption.CREATE
                , StandardOpenOption.TRUNCATE_EXISTING
                , StandardOpenOption.WRITE);
    }

    @Override
    public Iterator<Cliente> iterator() { return getMaioresDezoito().iterator(); }
}
