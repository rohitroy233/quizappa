package com.online.services.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.Repository.CategoryRepository;
import com.online.model.exam.Category;
import com.online.services.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Category addCategory(Category category) {
        // TODO Auto-generated method stub
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        // TODO Auto-generated method stub
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        // TODO Auto-generated method stub
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(int categoryId) {
        // TODO Auto-generated method stub
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(int categoryId) {
        // TODO Auto-generated method stub
        Category category=new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
        
    }

}
