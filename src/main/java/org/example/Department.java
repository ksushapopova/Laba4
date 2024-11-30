package org.example;

/**
 * Represents a department with an ID and a name.
 */
public class Department {
    private int id;
    private String name;

    /**
     * Constructs a Department with the specified ID and name.
     *
     * @param id   the unique identifier for the department
     * @param name the name of the department
     */
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the ID of the department.
     *
     * @return the ID of the department
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the department.
     *
     * @return the name of the department
     */
    public String getName() {
        return name;
    }
}