package com.blanco.core.services.impl;

import com.blanco.core.entities.Category;
import com.blanco.core.services.CategoryServices;
import com.blanco.core.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category finById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        saveCategory(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Boolean isExistCategory(Category category) {
        return categoryRepository.existsById(category.getId());
    }
}