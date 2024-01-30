package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {
}
