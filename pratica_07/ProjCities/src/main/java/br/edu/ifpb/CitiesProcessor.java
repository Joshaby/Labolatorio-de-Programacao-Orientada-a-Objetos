package br.edu.ifpb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class CitiesProcessor {
    Set<City> citiesSet;

    public CitiesProcessor(Path path) throws IOException { citiesSet = buildSetOfCities(path); }

    private Set<City> buildSetOfCities(Path path) throws IOException {
        Set<City> citiesSetAux = new HashSet<>();
        List<String> citiesString = Files.readAllLines(path);
        for (String s : citiesString) {
            String[] aux = s.split(", ");
            citiesSetAux.add(new City(aux[0], aux[1], aux[2]));
        }
        return citiesSetAux;
    }

    public void writeSetOfCities(Path path, Comparator<City> comparator) throws IOException {
        TreeSet<City> citiesInOrder = new TreeSet<>(comparator);
        citiesInOrder.addAll(citiesSet);
        List<String> AUX = new ArrayList<>();
        for (City c : citiesInOrder) {
            AUX.add(c.toString());
        }
        Files.write(path, citiesInOrder.stream().map(City::toString).collect(Collectors.toList()), Charset.defaultCharset()
                , StandardOpenOption.CREATE
                , StandardOpenOption.TRUNCATE_EXISTING
                , StandardOpenOption.WRITE);
    }
}