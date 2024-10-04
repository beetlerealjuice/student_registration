package org.example.student_registration.event;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.student_registration.services.StudentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("app.student-init.enabled")
@RequiredArgsConstructor
public class StudentInitializer {

    private final StudentService studentService;

    @PostConstruct
    public void initStudents() {
        studentService.addStudent("Иван", "Иванов", 20);
        studentService.addStudent("Мария", "Петрова", 22);
    }
}
