package com.slasher.italikaapirest.repository;

import com.slasher.italikaapirest.entity.TypeOfWork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfWorkRepository extends CrudRepository<TypeOfWork, Long> {
}
