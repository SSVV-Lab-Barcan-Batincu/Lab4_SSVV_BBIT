package ssvv.barcanbatincu.repository;

import ssvv.barcanbatincu.domain.Student;
import ssvv.barcanbatincu.validator.IValidator;
import ssvv.barcanbatincu.repository.AbstractCrudRepo;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}