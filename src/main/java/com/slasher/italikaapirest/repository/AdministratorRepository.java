package com.slasher.italikaapirest.repository;

import com.slasher.italikaapirest.entity.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
