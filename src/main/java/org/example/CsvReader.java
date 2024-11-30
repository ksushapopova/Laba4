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

/**
 * A class responsible for reading person data from a CSV file.
 */
public class CsvReader {

    /**
     * Reads person data from a CSV file and returns a list of Person objects.
     *
     * @param csvFilePath the path to the CSV file
     * @param separator   the character used to separate values in the CSV file
     * @return a list of Person objects populated from the CSV file
     * @throws Exception if an error occurs while reading the file
     */
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
