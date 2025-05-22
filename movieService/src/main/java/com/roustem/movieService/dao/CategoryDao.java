package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.Category;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category getCategoryByCategoryId(int categoryId);
}