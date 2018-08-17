package com.shoesworld.repositories;

import com.shoesworld.models.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    AdminEntity findById(int id);

    AdminEntity findByName(String name);
}
