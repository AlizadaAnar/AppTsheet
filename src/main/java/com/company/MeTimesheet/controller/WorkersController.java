package com.company.MeTimesheet.controller;

import com.company.MeTimesheet.entity.Workers;
import com.company.MeTimesheet.service.WorkersService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://management-app-halliburton.vercel.app/", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class WorkersController {

    private final WorkersService workersService;

    public WorkersController(WorkersService workersService) {
        super();
        this.workersService = workersService;
    }

    //Get:  Brings all data
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping(value = "/workers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Workers> listWorkers() {
        return workersService.getAllWorkers();
    }


    //Post: Posting a new data
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @PostMapping("/workers")
    public void saveWorkers(@RequestBody Workers workers) {
        workersService.saveWorkers(workers);
    }

    //Put: Updates the current data
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @PutMapping("/workers/{wId}")
    public Workers updateWorker(@PathVariable Long wId, @RequestBody Workers workerRequest) {
        return workersService.updateWorkers(wId, workerRequest);
    }


    //Get: Get selected data by id
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping("/worker/{id}")
    public Workers findWorkerById(@PathVariable long id) {
        return workersService.getWorkersById(id);
    }


    //Delete: Deletes a data by id
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @DeleteMapping("/workers/{id}")
    public void DELETE(@PathVariable Long id) {
        workersService.deleteWorkersById(id);
    }


}
