package com.slasher.italikaapirest.repository;

import com.slasher.italikaapirest.entity.Mechanic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends CrudRepository<Mechanic, Long> {
}
