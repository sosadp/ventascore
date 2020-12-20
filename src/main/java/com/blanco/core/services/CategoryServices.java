package com.blanco.core.services;

import com.blanco.core.entities.Category;

import java.util.List;

public interface CategoryServices {

    Category finById(Long id);

    List<Category> findAll();

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Long id);

    Boolean isExistCategory(Category category);
}
