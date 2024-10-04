package org.example.student_registration;

import lombok.RequiredArgsConstructor;
import org.example.student_registration.services.StudentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class StudentCommands {

    private final StudentService studentService;

    @ShellMethod(value = "Список всех студентов", key = {"list", "ls"})
    public void listStudents() {
        studentService.getAllStudents().forEach(System.out::println);
    }

    @ShellMethod(value = "Добавить нового студента", key = {"add"})
    public void addStudent(@ShellOption(help = "Имя") String firstName,
                           @ShellOption(help = "Фамилия") String lastName,
                           @ShellOption(help = "Возраст") int age) {
        studentService.addStudent(firstName, lastName, age);
    }

    @ShellMethod(value = "Удалить студента по id", key = {"delete"})
    public void deleteStudent(@ShellOption(help = "Студент id") int id) {
        studentService.deleteStudent(id);
    }

    @ShellMethod(value = "Отчистить список", key = {"cls"})
    public void clearStudents() {
        studentService.clearStudents();
        System.out.println("Список студентов очищен.");
    }
}
