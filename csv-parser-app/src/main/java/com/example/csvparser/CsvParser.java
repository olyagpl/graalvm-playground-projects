package com.example.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvParser {

    public void findCapital(String filePath, String countryQuery) {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(reader);

            for (CSVRecord record : records) {
                String country = record.get("Country");
                String capital = record.get("Capital");

                if (country.equalsIgnoreCase(countryQuery)) {
                    System.out.printf("The capital of %s is %s.%n", country, capital);
                    return;
                }
            }

            System.out.printf("Country '%s' not found in the file.%n", countryQuery);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: please provide the CSV file path and the country name.");
            System.exit(1);
        }

        String filePath = args[0];
        String countryQuery = args[1];

        CsvParser parser = new CsvParser();
        parser.findCapital(filePath, countryQuery);
    }
}