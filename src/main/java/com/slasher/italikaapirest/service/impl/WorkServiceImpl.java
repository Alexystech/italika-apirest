package com.slasher.italikaapirest.service.impl;

import com.slasher.italikaapirest.entity.Work;
import com.slasher.italikaapirest.repository.WorkRepository;
import com.slasher.italikaapirest.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public boolean createWork(Work work) {
        if ( work != null) {
            workRepository.save(work);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeWorkByFolio(long folio) {
        if ( getWorkByFolio(folio) != null ) {
            workRepository.deleteById(folio);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateWork(Work work) {
        if ( work != null ) {
            workRepository.save(work);
            return true;
        }
        return false;
    }

    @Override
    public Work getWorkByFolio(long folio) {
        return workRepository.findById(folio).orElse(null);
    }

    @Override
    public List<Work> getAllWorks() {
        return ((List<Work>) workRepository.findAll());
    }
}
