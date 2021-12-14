package br.edu.ifpb;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;

public class CitiesProcessorDemo {
    public static void main(String[] args) {
        try {
            CitiesProcessor cp = new CitiesProcessor(Path.of("cities_duplicatas.txt"));
            cp.writeSetOfCities(Path.of("cities_nao_duplicatas.txt"), Comparator.naturalOrder());
            cp.writeSetOfCities(Path.of("cities_nao_duplicatas_by_state.txt"), new ComparatorByState());
            cp.writeSetOfCities(Path.of("cities_nao_duplicatas_by_zip_code.txt"), new ComparatorByZipCode());
        } catch (IOException e) {
            System.err.println("Erro no processamento do arquivo!");
        }
    }
}
