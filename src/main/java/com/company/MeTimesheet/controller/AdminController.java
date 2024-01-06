package com.company.MeTimesheet.controller;

import com.company.MeTimesheet.entity.Admin;
import com.company.MeTimesheet.service.AdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my/v2")
@CrossOrigin(origins = "https://management-app-halliburton.vercel.app/", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }


    //Get: Get an Admin
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Admin> listAdmin() {
        return adminService.getAdmin();
    }

    //Post: Posting the new data
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @PostMapping("/admin")
    public void saveAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
    }


    //Put: Update current data by id
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @PutMapping("/admin/{wId}")
    public Admin updateAdmin(@PathVariable Long wId, @RequestBody Admin admin) {
        return adminService.updateAdmin(wId, admin);
    }


    //Get: Get an admin by id
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping("/admin/{id}")
    public Admin findAdminById(@PathVariable long id) {
        return adminService.getAdminById(id);
    }

    //Delete: deletes data by id
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdminById(id);
    }


    //Get: Get an admin by username
    @CrossOrigin(origins = "https://management-app-halliburton.vercel.app/")
    @GetMapping("/{username}/password")
    public String getPasswordByUsername(@PathVariable String username) {
        return adminService.getPasswordByUsername(username);
    }
}
