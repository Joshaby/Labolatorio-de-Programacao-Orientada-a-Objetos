package br.edu.ifpb.poo;

import br.edu.ifpb.poo.ProcessadorClientes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProcessadorDemo {
    public static void main(String[] args) {
        ProcessadorClientes pc = new ProcessadorClientes();
        try {
            Set<Cliente> c = pc.lerTodosClientes(Path.of("Arquivos/50-customers.txt"));
            pc.salvarClientes(Path.of("Arquivos/50-customers-In-Order-Default.txt"));
            pc.salvarClientesOrdenadosPor(Path.of("Arquivos/50-customers-In-Order-Per-State"), new ComparatorEstado());
            pc.salvarClientesOrdenadosPor(Path.of("Arquivos/50-customers-In-Order-Per-Name"), new ComparatorNome());
            pc.salvarClientesOrdenadosPor(Path.of("Arquivos/50-customers-In-Order-Per-Age"), new ComparatorIdade());
            Set<Cliente> maior18 = pc.getMaioresDezoito();
            System.out.println(maior18);
            Map<Integer, List<Integer>> c2 = pc.agrupatClientesPorIdade();
            System.out.println(c2);
            pc.gravarMapaClientes(Path.of("Arquivos/MapaClientes.txt"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
