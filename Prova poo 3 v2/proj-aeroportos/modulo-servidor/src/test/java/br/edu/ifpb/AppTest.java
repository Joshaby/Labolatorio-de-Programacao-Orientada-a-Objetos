package br.edu.ifpb;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AppTest {
    repoAeroportosTXT rpat = new repoAeroportosTXT();

    public AppTest() throws IOException {

    }

//    @Test
//    public void testListarAeroportoPor() throws IOException {
//        assertThat(rpat.listarAeroportoPor("A")
//                , equals("kkklllmnn\nAlbuquerque International\nPittsburgh/Allegheny County\nAtlantic City International\nAnchorage International\nArlanda (Stockholm Sweden)\npoiuy\nAustin Robert Mueller Municipal\nAsheville (NC) Regional\n"));
//    }

//    @Test
//    public void testGetNomeAeroporto() throws IOException {
//        assertThat(rpat.getNomeAeroporto("ABQ"), is("Albuquerque International\n"));
//    }
}
