package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class World {
    private final List<Continent> continentsList = new ArrayList<>();

    public void addContinent(Continent continent) {
        continentsList.add(continent);
    }

    public List<Continent> getContinentsList() {
        return new ArrayList<>(continentsList);
    }

    public void prepareWorld() {
        Continent europe = new Continent("Europa");
        europe.addCountry(new Country("Polska", new BigDecimal("38000000")));
        europe.addCountry(new Country("Niemcy", new BigDecimal("82000000")));
        europe.addCountry(new Country("Francja", new BigDecimal("67000000")));
        europe.addCountry(new Country("Hiszpania", new BigDecimal("48000000")));
        europe.addCountry(new Country("Włochy", new BigDecimal("60000000")));
        Continent africa = new Continent("Afryka");
        africa.addCountry(new Country("Egipt", new BigDecimal("97000000")));
        africa.addCountry(new Country("RPA", new BigDecimal("55000000")));
        africa.addCountry(new Country("Libia", new BigDecimal("6600000")));
        africa.addCountry(new Country("Zair", new BigDecimal("46500000")));
        africa.addCountry(new Country("Sudan", new BigDecimal("37300000")));
        Continent asia = new Continent("Azja");
        asia.addCountry(new Country("Rosja", new BigDecimal("144400000")));
        asia.addCountry(new Country("Chiny", new BigDecimal("1379000000")));
        asia.addCountry(new Country("Indie", new BigDecimal("1281900000")));
        asia.addCountry(new Country("Japonia", new BigDecimal("126450000")));
        asia.addCountry(new Country("Iran", new BigDecimal("78285000")));
        Continent northAmerica = new Continent("Ameryka Północna");
        northAmerica.addCountry(new Country("USA", new BigDecimal("323000000")));
        northAmerica.addCountry(new Country("Kanada", new BigDecimal("36708000")));
        northAmerica.addCountry(new Country("Meksyk", new BigDecimal("124574000")));
        Continent southAmerica = new Continent("Ameryka Południowa");
        southAmerica.addCountry(new Country("Brazylia", new BigDecimal("207353000")));
        southAmerica.addCountry(new Country("Argentyna", new BigDecimal("44293000")));
        southAmerica.addCountry(new Country("Peru", new BigDecimal("31000000")));
        southAmerica.addCountry(new Country("Chile", new BigDecimal("17789267")));
        southAmerica.addCountry(new Country("Kolumbia", new BigDecimal("47698524")));
        Continent australia = new Continent("Ausralia");
        australia.addCountry(new Country("Astralia", new BigDecimal("24511800")));
        addContinent(europe);
        addContinent(africa);
        addContinent(asia);
        addContinent(northAmerica);
        addContinent(southAmerica);
        addContinent(australia);
    }

    public List<String> getNamesOfCountries() {
        World world = new World();
        world.prepareWorld();
         List<String> namesList = world.getContinentsList().stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(country -> country.getNameOfCountry())
                .collect(Collectors.toList());
         return namesList;
    }

    public BigDecimal getPeopleQuantity() {
        World world = new World();
        world.prepareWorld();
        BigDecimal totalPeople = world.getContinentsList().stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, next) -> sum = sum.add(next));
        System.out.println("Liczba wszystkich ludzi na świecie --> " + totalPeople);
        return totalPeople;
    }

    public static void main(String[] args) {
        World world = new World();
        world.getPeopleQuantity();
        System.out.println();
        System.out.println("Lista krajów branych pod uwagę podczas liczenia:");
        world.getNamesOfCountries().stream()
                .forEach(names -> System.out.println(names + ", "));







    }
}
