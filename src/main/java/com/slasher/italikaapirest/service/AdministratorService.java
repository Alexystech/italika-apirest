package com.slasher.italikaapirest.service;

import com.slasher.italikaapirest.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    boolean createAdministrator(Administrator administrator);
    boolean removeAdministratorByFolio(long folio);
    boolean updateAdministrator(Administrator administrator);
    Administrator getAdministratorByFolio(long folio);
    List<Administrator> getAllAdministrators();
}
