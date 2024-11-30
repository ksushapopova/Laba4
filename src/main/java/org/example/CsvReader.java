package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class CsvReader {

    public List<Person> readPersonsFromCsv(String csvFilePath, char separator) throws Exception {
        List<Person> persons = new ArrayList<>();
        int departmentId = 1;

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             InputStreamReader reader = new InputStreamReader(in)) {

            if (in == null) {
                throw new FileNotFoundException(csvFilePath);
            }

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                    .build();

            String[] nextLine;

            csvReader.readNext();

            while ((nextLine = csvReader.readNext()) != null) {
                try {
                    int personId = Integer.parseInt(nextLine[0]);
                    String name = nextLine[1];
                    String gender = nextLine[2];
                    String birthDate = nextLine[3];
                    String categoryCode = nextLine[4];
                    double salary = Double.parseDouble(nextLine[5]);

                    Department department = new Department(departmentId++, categoryCode);
                    Person person = new Person(personId, name, gender, department, salary, birthDate);
                    persons.add(person);
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка при парсинге данных: " + e.getMessage());
                    System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                }
            }
        }

        return persons;
    }

}
