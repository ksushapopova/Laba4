package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
                    .withCSVParser(new com.opencsv.CSVParserBuilder().withSeparator(separator).build())
                    .build();

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                int personId = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                String departmentName = nextLine[3];
                double salary = Double.parseDouble(nextLine[4]);
                String birthDate = nextLine[5];

                Department department = new Department(departmentId++, departmentName);

                Person person = new Person(personId, name, gender, department, salary, birthDate);
                persons.add(person);
            }
        }

        return persons;
    }
}