package org.fasttrackit.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.tools.javac.jvm.ByteCodes.pop;

public class CountryService {
    private static String pathFile; //= "files/Countries2.txt";
    private static List<Countries> countriesList;

    //- list all country names :  -> returns a list of strings
    static List<String> allCountriesName = getList().stream()
            .map(Countries::getName)
            .toList();

    //- get capital of a country :  -> returns a string
    static List<String> getCapitalOfCountry = getList().stream()
            .filter(countries -> countries.getName().equals("Afghanistan"))
            .map(countries -> countries.getCapital())
            .collect(Collectors.toList());

    //- get population of a country : -> returns a long
    static List<Long> getLongPopulationOfCountry = getList().stream()
            .filter(countries -> countries.getName().equals("Afghanistan"))
            .map(countries -> Double.doubleToLongBits(countries.getPopulation()))
            .collect(Collectors.toList());
    //- get population of a country : -> returns a Double
    static List<Double> getDoublePopulationOfCountry = getList().stream()
            .filter(countries -> countries.getName().equals("Afghanistan"))
            .map(countries -> countries.getPopulation())
            .collect(Collectors.toList());


    //- get countries in continent : -> returns list of Country objects
    static List<Countries> getCountriesInContinent = getList().stream()
            .filter(countries -> countries.getContinent().equals("Asia"))
            .toList();

    //- get country neighbours :  -> returns list of Strings
    static List<List<String>> getCountriesNeighbours = getList().stream()
            .map(Countries::getNeighbour)
            .toList();

    //- get countries in <continent> with population larger than <population> : -> returns list of Country objects
    static List<Countries> getCountriesWithlLargerPopulation(double population) {
        return getList().stream()
                .filter(countries -> countries.getPopulation() > population)
                .toList();
    }

    //- get countries that neighbor X but not neighbor Y :-> returns list of Country objects


    public CountryService() {
    }

    public static List<Countries> getList() {
        //CountryReader.getCountriesList();
        return countriesList = CountryReader.getCountriesList();
    }
}
