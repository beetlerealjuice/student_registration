package org.example.student_registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + "' " +
                ", lastName='" + lastName + "' " +
                ", age=" + age +
                '}';
    }
}
