package br.edu.ifpb.poo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Servidor implements MetodosClientes_IF {
    private Set<Cliente> clientes;
    private String nome;

    public static final String CAMINHO_TXT = "/home/jose/Documentos/Engenharia da computação/2019.2/Labolatório de Programação Orientada a Objetos/ifpb-poo-master/praticas/Atividades/pratica_extra/rmi/Arquivos/clientes.txt";

    public Servidor(String nome) throws IOException {
        clientes = new TreeSet<>();
        txtToSet();
        this.nome = nome;
    }

    @Override
    public void txtToSet() throws IOException {
        List<String> AUX = Files.readAllLines(Path.of(CAMINHO_TXT));
        for (String c : AUX) {
            String[] AUX1 = c.split(" ");
            clientes.add(new Cliente(Integer.parseInt(AUX1[0]), AUX1[1], AUX1[2]));
        }
    }
    @Override
    public void setToTxt() throws IOException {
        List<String> AUX = clientes.stream().map(Cliente::toString).collect(Collectors.toList());
        Files.write(Path.of(CAMINHO_TXT), AUX, Charset.defaultCharset()
                , StandardOpenOption.CREATE
                , StandardOpenOption.TRUNCATE_EXISTING
                , StandardOpenOption.WRITE);
    }

    @Override
    public boolean adicionarCliente(int num, String nome, String sobrenome) throws RemoteException {
        return clientes.add(new Cliente(num, nome, sobrenome));
    }
    @Override
    public boolean removerClientes(int num) throws RemoteException {
        Cliente c = new Cliente(num, "", "");
        return clientes.remove(c);
    }
    @Override
    public String buscarCliente(int num) throws RemoteException, ClienteException {
        return clientes.stream().filter(Cliente -> Cliente.getNum() == num).findFirst().map(Cliente::toString).orElseThrow(ClienteException::new);
    }
    @Override
    public String listarClientes() throws RemoteException {
        return clientes.stream().map(Cliente::toString).collect(Collectors.joining("\n"));
    }
}
