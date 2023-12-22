package com.company.MeTimesheet.controller;

import com.company.MeTimesheet.entity.Admin;
import com.company.MeTimesheet.service.AdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my/v2")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }


    //Get: Get an Admin
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Admin> listAdmin() {
        return adminService.getAdmin();
    }

    //Post: Posting the new data
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/admin")
    public void saveAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
    }


    //Put: Update current data by id
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/admin/{wId}")
    public Admin updateAdmin(@PathVariable Long wId, @RequestBody Admin admin) {
        return adminService.updateAdmin(wId, admin);
    }


    //Get: Get an admin by id
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/admin/{id}")
    public Admin findAdminById(@PathVariable long id) {
        return adminService.getAdminById(id);
    }

    //Delete: deletes data by id
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdminById(id);
    }


    //Get: Get an admin by username
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/{username}/password")
    public String getPasswordByUsername(@PathVariable String username) {
        return adminService.getPasswordByUsername(username);
    }
}
