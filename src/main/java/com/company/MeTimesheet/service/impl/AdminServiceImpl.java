package com.company.MeTimesheet.service.impl;

import com.company.MeTimesheet.entity.Admin;
import com.company.MeTimesheet.repository.AdminRepository;
import com.company.MeTimesheet.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Admin existingAdmin = adminRepository.findById(id).get();
        existingAdmin.setFirstName(admin.getFirstName());
        existingAdmin.setLastname(admin.getLastname());
        existingAdmin.setNumber(admin.getNumber());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setMarineDaysOn(admin.getMarineDaysOn());
        existingAdmin.setTrainingDays(admin.getTrainingDays());
        existingAdmin.setSickDays(admin.getSickDays());
        existingAdmin.setVacationDays(admin.getVacationDays());
        existingAdmin.setUnpaidWorkingDays(admin.getUnpaidWorkingDays());
        existingAdmin.setEducationalVacation(admin.getEducationalVacation());
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public String getPasswordByUsername(String username) {
        Admin admin = adminRepository.findByUsername(username);
        return (admin != null) ? admin.getPassword() : null;
    }

}
