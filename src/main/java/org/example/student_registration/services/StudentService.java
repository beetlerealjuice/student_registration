package org.example.student_registration.services;

import lombok.RequiredArgsConstructor;
import org.example.student_registration.Student;
import org.example.student_registration.event.StudentCreatedEvent;
import org.example.student_registration.event.StudentDeletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final Map<Integer, Student> students = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();
    private final ApplicationEventPublisher publisher;

    public void addStudent(String firstName, String lastName, int age) {
        Student student = new Student(idGenerator.incrementAndGet(), firstName, lastName, age);
        students.put(student.getId(), student);
        publisher.publishEvent(new StudentCreatedEvent(this, student));
    }


    public void deleteStudent(int id) {
        students.remove(id);
        publisher.publishEvent(new StudentDeletedEvent(this, id));
    }

    public void clearStudents() {
        students.clear();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}
