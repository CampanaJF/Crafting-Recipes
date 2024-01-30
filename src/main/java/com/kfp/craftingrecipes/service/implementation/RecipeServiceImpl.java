package com.kfp.craftingrecipes.service.implementation;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.RecipeView;
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
    public Recipe getRecipe(Integer recipeId) throws RecipeNotFoundException{
        return recipeJpaRepository.findById(recipeId)
                .orElseThrow( () -> new RecipeNotFoundException(
                        String.format("No candidate with id: %s",recipeId)));
    }

    @Override
    public List<RecipeView> getRecipeView(Integer id) {
        return recipeJpaRepository.findRecipeView(id);
    }
}
