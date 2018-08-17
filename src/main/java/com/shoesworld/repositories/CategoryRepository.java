package com.shoesworld.repositories;

import com.shoesworld.models.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    CategoryEntity findById(int id);

    CategoryEntity findByName(String name);

}
