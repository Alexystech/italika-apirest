package com.slasher.italikaapirest.service.impl;

import com.slasher.italikaapirest.entity.Mechanic;
import com.slasher.italikaapirest.repository.MechanicRepository;
import com.slasher.italikaapirest.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicServiceImpl implements MechanicService {

    private MechanicRepository mechanicRepository;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public boolean createMechanic(Mechanic mechanic) {
        if ( mechanic != null ) {
            mechanicRepository.save(mechanic);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMechanicByFolio(long folio) {
        if ( getMechanicByFolio(folio) != null ) {
            mechanicRepository.deleteById(folio);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMechanic(Mechanic mechanic) {
        if ( mechanic != null ) {
            mechanicRepository.save(mechanic);
            return true;
        }
        return false;
    }

    @Override
    public Mechanic getMechanicByFolio(long folio) {
        return mechanicRepository.findById(folio).orElse(null);
    }

    @Override
    public List<Mechanic> getAllMechanics() {
        return ((List<Mechanic>) mechanicRepository.findAll());
    }
}
