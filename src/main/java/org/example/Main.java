package org.example;

import java.util.List;

/**
 * The main class that executes the application.
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        try {
            List<Person> persons = csvReader.readPersonsFromCsv("foreign_names.csv", ';');
            for (Person person : persons) {
                System.out.println("ID: " + person.getId() + ", Name: " + person.getName() +
                        ", Gender: " + person.getGender() +
                        ", Department: " + person.getDepartment().getName() +
                        ", Salary: " + person.getSalary() +
                        ", Birth Date: " + person.getBirthDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}