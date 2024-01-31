package com.kfp.craftingrecipes.service.implementation;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;
import com.kfp.craftingrecipes.repository.RecipeJpaRepository;
import com.kfp.craftingrecipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeJpaRepository recipeJpaRepository;

    @Override
    public RecipeIngredientsProjection getRecipe(Integer recipeId) throws RecipeNotFoundException{
        return recipeJpaRepository.getRecipeById(recipeId)
                .orElseThrow( () -> new RecipeNotFoundException(
                        String.format("No candidate with id: %s",recipeId)));
    }

    @Override
    public List<RecipeNameProjection> getAll() {
        return recipeJpaRepository.findAllRecipes();
    }

    @Override
    public List<RecipeNameProjection> searchByName(String searchField) {
        return recipeJpaRepository.searchRecipes(searchField);
    }

}
