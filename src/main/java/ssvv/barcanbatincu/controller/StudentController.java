package ssvv.barcanbatincu.controller;

import ssvv.barcanbatincu.domain.Student;
import ssvv.barcanbatincu.exceptions.ValidatorException;
import ssvv.barcanbatincu.repository.StudentRepo;
import ssvv.barcanbatincu.validator.StudentValidator;

public class StudentController {
    private StudentRepo studentRepo;
    private StudentValidator studentValidator;

    public StudentController() {
        studentValidator = new StudentValidator();
        studentRepo = new StudentRepo(studentValidator);
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void addStudent(String id, String name, int group, String email, String professor) throws ValidatorException {
        Student student = new Student(id, name, group, email, professor);
        studentRepo.save(student);
        System.out.println("Student added with success");
    }
}
