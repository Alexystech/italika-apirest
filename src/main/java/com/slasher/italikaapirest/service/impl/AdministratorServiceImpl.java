package com.slasher.italikaapirest.service.impl;

import com.slasher.italikaapirest.entity.Administrator;
import com.slasher.italikaapirest.repository.AdministratorRepository;
import com.slasher.italikaapirest.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public boolean createAdministrator(Administrator administrator) {
        if ( administrator != null ) {
            administratorRepository.save(administrator);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAdministratorByFolio(long folio) {
        if ( getAdministratorByFolio(folio) != null ) {
            administratorRepository.deleteById(folio);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAdministrator(Administrator administrator) {
        if ( administrator != null ) {
            administratorRepository.save(administrator);
            return true;
        }
        return false;
    }

    @Override
    public Administrator getAdministratorByFolio(long folio) {
        return administratorRepository.findById(folio).orElse(null);
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return ((List<Administrator>) administratorRepository.findAll());
    }
}
