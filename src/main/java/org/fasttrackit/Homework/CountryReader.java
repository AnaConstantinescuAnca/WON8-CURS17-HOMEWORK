package org.fasttrackit.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CountryReader {
   private final static List<Country> countriesList = new ArrayList<>();

    private String pathfile;

    public static List<Country> getCountriesList() {
        return countriesList;
    }

    public CountryReader(String pathfile) {
        this.pathfile = pathfile;
    }

    public String getPathfile() {
        return pathfile;
    }

    public static List<Country> readFromFile(String pathfile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathfile));
        //String line = bufferedReader.readLine();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            countriesList.add(countriesFromLine(line));
        }
        return countriesList;
    }


    private static Country countriesFromLine(String line) {
        String[] token = line.split(Pattern.quote("|"));
        if (isABoolean(line)) {
            return new Country(idGenerate(), token[0], token[1], Double.parseDouble(token[2]), Double.parseDouble(token[3]),
                    token[4], null);

        }
        return new Country(idGenerate(), token[0], token[1], Double.parseDouble(token[2]), Double.parseDouble(token[3]),
                token[4], extractNeighbour(token[5]));
    }

    //verific daca ultimul caracter din line este |
    private static boolean isABoolean(String line) {
        return line.endsWith("|");
    }

    private static List<String> extractNeighbour(String s) {
        String[] tokenNeiborough = s.split(Pattern.quote("~"));
        List<String> result = List.of(tokenNeiborough);
        return result;
    }

    private static int idGenerate() {
        return countriesList.size() + 1;
    }
}
