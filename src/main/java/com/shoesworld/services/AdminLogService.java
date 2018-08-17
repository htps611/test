package com.shoesworld.services;

import com.shoesworld.models.AdminLogEntity;
import com.shoesworld.repositories.AdminLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLogService {
    @Autowired
    private AdminLogRepository adminLogRepository;

    public List<AdminLogEntity> getAllAdminLog() {
        return adminLogRepository.findAll();
    }

    public List<AdminLogEntity> getAdminLogByAdminId(int adminId) {
        return adminLogRepository.findByAdminId(adminId);
    }
}
