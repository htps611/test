package com.shoesworld.controllers;

import com.shoesworld.models.CategoryEntity;
import com.shoesworld.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEntity>> getAllCategory() {
        List<CategoryEntity> categoryList = categoryService.getAllCategory();
        System.out.println("size of list = " + categoryList.size());
        if(categoryList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryEntity>>(categoryList, HttpStatus.OK);
    }


}
