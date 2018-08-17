package com.shoesworld.repositories;

import com.shoesworld.models.AdminLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminLogRepository extends JpaRepository<AdminLogEntity, Integer> {
    List<AdminLogEntity> findAll();

    List<AdminLogEntity> findByAdminId(int adminId);
}
