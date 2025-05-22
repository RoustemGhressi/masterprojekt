package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.Category;

public interface CategoryService {

    List<Category> getall();

    Category getCategoryById(int categoryId);
}
