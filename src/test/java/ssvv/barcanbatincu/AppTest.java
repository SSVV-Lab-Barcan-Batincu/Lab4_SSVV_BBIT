package ssvv.barcanbatincu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ssvv.barcanbatincu.controller.StudentController;
import ssvv.barcanbatincu.domain.Nota;
import ssvv.barcanbatincu.domain.TemaLab;
import ssvv.barcanbatincu.exceptions.ValidatorException;
import ssvv.barcanbatincu.repo.NotaRepo;
import ssvv.barcanbatincu.repo.TemaLabRepo;
import ssvv.barcanbatincu.validator.NotaValidator;
import ssvv.barcanbatincu.validator.TemaLabValidator;

import java.time.LocalDateTime;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void addStudentTest() {
        StudentController studentController = new StudentController();
        try {
            studentController.addStudent("1234","abc", 333, "loranz@loranz", "loranz");
            assert studentController.getStudentRepo().size() == 1;
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addAssignmentTest() {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);
        try {
            temaLabRepo.save(new TemaLab(1, "a fost si nu va mai fi", 16, 3));
            assert temaLabRepo.size() == 0;
        } catch (ValidatorException e) {
            assert e.toString().equals("ssvv.barcanbatincu.exceptions.ValidatorException: Termen limita invalid\n");
            e.printStackTrace();
        }
    }

    @Test
    public void addGradeTest() {
        NotaValidator notaValidator = new NotaValidator();
        NotaRepo notaRepo = new NotaRepo(notaValidator);

        try {
            notaRepo.save(new Nota(1, "", 1, 4, LocalDateTime.now()));
        } catch (ValidatorException e) {
            assert e.toString().equals("ssvv.barcanbatincu.exceptions.ValidatorException: Id student invalid\n");
            e.printStackTrace();
        }
    }

    @Test
    public void IntegratedGradeTest() {
        StudentController studentController = new StudentController();

        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);

        NotaValidator notaValidator = new NotaValidator();
        NotaRepo notaRepo = new NotaRepo(notaValidator);

        try {
            studentController.addStudent("1234","abc", 333, "loranz@loranz", "loranz");
            assert studentController.getStudentRepo().size() == 1;

            temaLabRepo.save(new TemaLab(1, "a fost si nu va mai fi", 13, 3));
            assert temaLabRepo.size() == 1;

            notaRepo.save(new Nota(1, "1234", 1, -1, LocalDateTime.now()));
        } catch (ValidatorException e) {
            assert e.toString().equals("ssvv.barcanbatincu.exceptions.ValidatorException: Valoare invalida\n");
            e.printStackTrace();
        }
    }

}
