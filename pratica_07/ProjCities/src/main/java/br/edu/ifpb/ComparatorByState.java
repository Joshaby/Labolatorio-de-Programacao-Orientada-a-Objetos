package br.edu.ifpb;

import java.util.Comparator;

public class ComparatorByState implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) { return city1.getEstado().compareTo(city2.getEstado()); }
}
