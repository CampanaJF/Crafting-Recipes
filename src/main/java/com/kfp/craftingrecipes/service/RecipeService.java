package com.kfp.craftingrecipes.service;

import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;

import java.util.List;

public interface RecipeService {

    RecipeIngredientsProjection getRecipe(Integer id);

    List<RecipeNameProjection> getAll();

    List<RecipeNameProjection> searchByName(String searchField);

    List<RecipeNameProjection> searchByProfession(String searchField);

    List<RecipeNameProjection> searchByRarity(String searchField);


}
