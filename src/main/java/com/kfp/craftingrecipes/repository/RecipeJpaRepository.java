package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.RecipeView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {

    Optional<RecipeView> getRecipeById(Integer id);

}
