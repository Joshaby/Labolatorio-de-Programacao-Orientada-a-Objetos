package br.edu.ifpb.poo;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class AppTest {
    ProcessadorClientes pc = new ProcessadorClientes();
    Cliente c = new Cliente(12375,"Bruce","Moore",25,"7627 High Bluff End","Caguas","PR",00725);
    Cliente c1 = new Cliente(12388,"Donna","Smith",35,"5292 Heather Zephyr Forest","Caguas","PR",00725);
    Cliente c2 = new Cliente(12379,"Mary","Long",18,"4542 Shady Branch Boulevard","Caguas","PR",00725);

    @Test
    public void testMaiorDezoito() {
        System.out.println(pc.getMaioresDezoito());
        assertThat(pc.getMaioresDezoito(), containsInAnyOrder(c, c1, c2));
    }

    @Before
    public void startCP() throws IOException {
        Path p = Paths.get("/home/jose/Documentos/Engenharia da computação/2019.2/Labolatório de Programação Orientada a Objetos/Prova poo 2/Questao2/modulo-gui-texto/src/test/java/br/edu/ifpb/poo/50-customers.txt");
        pc.lerTodosClientes(p);
    }
}
