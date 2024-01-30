package com.kfp.craftingrecipes.service;

import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.RecipeView;

import java.util.List;

public interface RecipeService {

    Recipe getRecipe(Integer id);

    List<RecipeView> getRecipeView(Integer id);
}
