package com.slasher.italikaapirest.service.impl;

import com.slasher.italikaapirest.entity.TypeOfWork;
import com.slasher.italikaapirest.repository.TypeOfWorkRepository;
import com.slasher.italikaapirest.service.TypeOfWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfWorkServiceImpl implements TypeOfWorkService {

    private TypeOfWorkRepository typeOfWorkRepository;

    @Autowired
    public TypeOfWorkServiceImpl(TypeOfWorkRepository typeOfWorkRepository) {
        this.typeOfWorkRepository = typeOfWorkRepository;
    }

    @Override
    public boolean createTypeOfWork(TypeOfWork typeOfWork) {
        if ( typeOfWork != null ) {
            typeOfWorkRepository.save(typeOfWork);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTypeOfWorkByFolio(long folio) {
        if ( getTypeOfWorkByFolio(folio) != null ) {
            typeOfWorkRepository.deleteById(folio);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTypeOfWork(TypeOfWork typeOfWork) {
        if ( typeOfWork != null ) {
            typeOfWorkRepository.save(typeOfWork);
            return true;
        }
        return false;
    }

    @Override
    public TypeOfWork getTypeOfWorkByFolio(long folio) {
        return typeOfWorkRepository.findById(folio).orElse(null);
    }

    @Override
    public List<TypeOfWork> getAllTypeOfWorks() {
        return ((List<TypeOfWork>) typeOfWorkRepository.findAll());
    }
}
