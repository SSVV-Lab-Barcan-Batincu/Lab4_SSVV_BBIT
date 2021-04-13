package ssvv.barcanbatincu.repo;

import ssvv.barcanbatincu.domain.Nota;
import ssvv.barcanbatincu.validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer, Nota> {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}