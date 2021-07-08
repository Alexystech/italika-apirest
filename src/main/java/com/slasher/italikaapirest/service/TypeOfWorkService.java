package com.slasher.italikaapirest.service;

import com.slasher.italikaapirest.entity.TypeOfWork;

import java.util.List;

public interface TypeOfWorkService {
    boolean createTypeOfWork(TypeOfWork typeOfWork);
    boolean removeTypeOfWorkByFolio(long folio);
    boolean updateTypeOfWork(TypeOfWork typeOfWork);
    TypeOfWork getTypeOfWorkByFolio(long folio);
    List<TypeOfWork> getAllTypeOfWorks();
}
