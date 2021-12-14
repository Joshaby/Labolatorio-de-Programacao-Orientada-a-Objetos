package br.edu.ifpb;

import org.junit.Assert;
import org.junit.Test;

public class UniversidadeTest {
    Instituto i = new Instituto();
    @Test
    public void UniTest() {
        Professor p1 = new Professor(18, "Rua 122", "José Azevedo", 480, 8, 0);
        Professor p2 = new Professor(19, "Rua 123", "José Henrique", 4180, 18, 1);
        Professor p3 = new Professor(18, "Rua 124", "José", 890, 9, 2);

        Assert.assertTrue(i.adicionarFuncionario(p1));
        Assert.assertFalse(i.adicionarFuncionario(p1));
        Assert.assertNull(i.buscarFuncionario(-1));
        Assert.assertFalse(i.removerFuncionario(10));
        Assert.assertEquals(p1.getMatricula(), i.buscarFuncionario(0).getMatricula());
    }
}
