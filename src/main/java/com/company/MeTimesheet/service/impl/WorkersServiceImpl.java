package com.company.MeTimesheet.service.impl;

import com.company.MeTimesheet.entity.Workers;
import com.company.MeTimesheet.repository.AllWorkerRepository;
import com.company.MeTimesheet.service.WorkersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkersServiceImpl implements WorkersService {

    private final AllWorkerRepository allWorkerRepository;

    public WorkersServiceImpl(AllWorkerRepository allWorkerRepository) {
        super();
        this.allWorkerRepository = allWorkerRepository;
    }

    @Override
    public List<Workers> getAllWorkers() {
        return allWorkerRepository.findAll();
    }

    @Override
    public Workers saveWorkers(Workers workers) {
        return allWorkerRepository.save(workers);
    }

    @Override
    public Workers getWorkersById(Long id) {
        return allWorkerRepository.findById(id).get();
    }

    @Override
    public Workers updateWorkers(Long id, Workers workers) {
//        return allWorkerRepository.save(workers);
        Workers existingWorker = allWorkerRepository.findById(id).get();
        existingWorker.setFirstName(workers.getFirstName());
        existingWorker.setLastname(workers.getLastname());
        existingWorker.setNumber(workers.getNumber());
        existingWorker.setEmail(workers.getEmail());
        existingWorker.setMarineDaysOn(workers.getMarineDaysOn());
        existingWorker.setTrainingDays(workers.getTrainingDays());
        existingWorker.setSickDays(workers.getSickDays());
        existingWorker.setVacationDays(workers.getVacationDays());
        existingWorker.setUnpaidWorkingDays(workers.getUnpaidWorkingDays());
        existingWorker.setEducationalVacation(workers.getEducationalVacation());
        existingWorker.setUsername(workers.getUsername());
        existingWorker.setPassword(workers.getPassword());
        return allWorkerRepository.save(existingWorker);
    }

    @Override
    public void deleteWorkersById(Long id) {
        allWorkerRepository.deleteById(id);
    }

}
