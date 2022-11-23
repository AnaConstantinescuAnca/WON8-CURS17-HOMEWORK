package org.fasttrackit.Homework;

import java.io.IOException;
import java.util.List;

public class Main {
    private static String pathFile = "files/Countries2.txt";

    public static void main(String[] args) throws IOException {
        List<Country> list = CountryReader.ReadFromFile(pathFile);

        //list all countries:  -> returns a list of country objects
        System.out.println(CountryService.getList());

        //- list all country names :  -> returns a list of strings
        System.out.println(CountryService.allCountriesName);

        //- get capital of a country :  -> returns a string
        System.out.println(CountryService.getCapitalOfCountry);

        //- get population of a country : -> returns a long
        System.out.println("Population contry Afghanistan in Long");
        System.out.println(CountryService.getLongPopulationOfCountry);

        //- get population of a country : -> returns a Double
        System.out.println("Population contry Afghanistan in Double");
        System.out.println(CountryService.getDoublePopulationOfCountry);

        //- get countries in continent : -> returns list of Country objects
        System.out.println(CountryService.getCountriesInContinent);

        //- get country neighbours :  -> returns list of Strings
        System.out.println(CountryService.getCountriesNeighbours);

        //get countries in <continent> with population larger than <population> : -> returns list of Country objects
        System.out.println(CountryService.getCountriesWithlLargerPopulation(1.77532E7));

        //- get countries that neighbor X but not neighbor Y :-> returns list of Country objects

    }


}
