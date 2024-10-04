package org.example.student_registration.event;

import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class StudentEventListener {

    @EventListener
    public void onStudentCreated(StudentCreatedEvent event) {
        System.out.println("Студент создан: " + event.getStudent());
    }

    @EventListener
    public void onStudentDeleted(StudentDeletedEvent event) {
        System.out.println("Студент удален: " + event.getId());
    }
}
