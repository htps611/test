package com.shoesworld.services;

import com.shoesworld.models.AdminEntity;
import com.shoesworld.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminEntity> getAllAdmin() {
        return adminRepository.findAll();
    }

    public AdminEntity getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public boolean isExist(String name) {
        return adminRepository.findByName(name) != null;
    }

    public void save(AdminEntity adminEntity) {
        adminRepository.save(adminEntity);
    }

    public void update(AdminEntity adminEntity) {
        save(adminEntity);
    }

    public void delete(AdminEntity adminEntity) {
        adminRepository.delete(adminEntity);
    }

    public void deleteAll() {
        adminRepository.deleteAll();
    }
}
