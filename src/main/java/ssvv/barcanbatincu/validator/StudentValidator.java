package ssvv.barcanbatincu.validator;

import ssvv.barcanbatincu.domain.Student;
import ssvv.barcanbatincu.exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if(s.getName()==null || s.getName().equals("")){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGroup()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail()==null || s.getEmail().equals("")){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if(s.getProfessor()==null || s.getProfessor().equals("")) {
            errors+="Professor invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}