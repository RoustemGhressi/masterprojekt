package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.roustem.movieService.business.abstracts.CategoryService;
import com.roustem.movieService.dao.CategoryDao;
import com.roustem.movieService.entity.Category;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Cacheable(value = "categories")
    @Override
    public List<Category> getall() {

        return categoryDao.findAll(Sort.by(Sort.Direction.ASC, "categoryName"));
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryDao.getCategoryByCategoryId(categoryId);
    }
}
