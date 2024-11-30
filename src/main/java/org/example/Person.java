package org.example;

/**
 * Represents a person with attributes such as ID, name, gender, department, salary, and birth date.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private double salary;
    private String birthDate;

    /**
     * Constructs a Person with the specified attributes.
     *
     * @param id         the unique identifier for the person
     * @param name       the name of the person
     * @param gender     the gender of the person
     * @param department the department the person belongs to
     * @param salary     the salary of the person
     * @param birthDate  the birth date of the person
     */
    public Person(int id, String name, String gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Returns the ID of the person.
     *
     * @return the ID of the person
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the gender of the person.
     *
     * @return the gender of the person
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the department of the person.
     *
     * @return the department of the person
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Returns the salary of the person.
     *
     * @return the salary of the person
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns the birth date of the person.
     *
     * @return the birth date of the person
     */
    public String getBirthDate() {
        return birthDate;
    }
}
