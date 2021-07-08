package com.slasher.italikaapirest.repository;

import com.slasher.italikaapirest.entity.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {
}
