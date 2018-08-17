package com.shoesworld.services;

import com.shoesworld.models.CategoryEntity;
import com.shoesworld.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
    }

    public CategoryEntity getCategoryById (int id) {
        return categoryRepository.findById(id);
    }

    public CategoryEntity getCategoryByName (String name) {
        return categoryRepository.findByName(name);
    }

    public void save(CategoryEntity categoryEntity) {
        categoryRepository.save(categoryEntity);
    }

    public void update(CategoryEntity categoryEntity) {
        save(categoryEntity);
    }

    public void delete(CategoryEntity categoryEntity) {
        categoryRepository.delete(categoryEntity);
    }

    public void deleteAll(CategoryEntity categoryEntity) {
        categoryRepository.deleteAll();
    }
}
