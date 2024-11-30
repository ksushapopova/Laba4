package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * A class for testing the functionality of the CsvReader class and related classes.
 */
public class CsvReaderTest {

    /**
     * Tests the creation of a Department object.
     * Verifies that the ID and name of the department are set correctly.
     */
    @Test
    public void testDepartmentCreation() {
        Department department = new Department(38969, "E");
        assertEquals(38969, department.getId());
        assertEquals("E", department.getName());
    }

    /**
     * Tests the creation of a Person object.
     * Verifies that all attributes of the person are set correctly.
     */
    @Test
    public void testPersonCreation() {
        Department department = new Department(38969, "E");
        Person person = new Person(38969, "Germana", "Female", department, 6800, "06.05.1963");

        assertEquals(38969, person.getId());
        assertEquals("Germana", person.getName());
        assertEquals("Female", person.getGender());
        assertEquals(department, person.getDepartment());
        assertEquals(6800, person.getSalary());
        assertEquals("06.05.1963", person.getBirthDate());
    }

    /**
     * Tests the readPersonsFromCsv method of the CsvReader class.
     * Verifies that the method returns a non-empty list of Person objects,
     * and that the data of the first person in the list matches the expected values.
     *
     * @throws Exception if an error occurs while reading the CSV file
     */
    @Test
    public void testReadPersonsFromCsv() throws Exception {
        CsvReader csvReader = new CsvReader();
        List<Person> persons = csvReader.readPersonsFromCsv("test_data.csv", ';'); // Assume you have a test CSV

        assertNotNull(persons);
        assertFalse(persons.isEmpty());

        Person firstPerson = persons.get(0);
        assertEquals(38969, firstPerson.getId());
        assertEquals("Germana", firstPerson.getName());
        assertEquals("Female", firstPerson.getGender());
        assertEquals("E", firstPerson.getDepartment().getName());
        assertEquals(6800, firstPerson.getSalary());
        assertEquals("06.05.1963", firstPerson.getBirthDate());
    }
}