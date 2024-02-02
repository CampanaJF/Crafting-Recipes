package com.kfp.craftingrecipes.service.implementation;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.Recipe;
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
    public List<Recipe> getAll() {
        return recipeJpaRepository.findAll();
    }

    @Override
    public RecipeIngredientsProjection getRecipe(Integer recipeId) throws RecipeNotFoundException{
        return recipeJpaRepository.getRecipeById(recipeId)
                .orElseThrow( () -> new RecipeNotFoundException(
                        String.format("No candidate with id: %s",recipeId)));
    }

    @Override
    public List<RecipeNameProjection> getAllNames() {
        return recipeJpaRepository.findAllRecipes();
    }

    @Override
    public List<RecipeNameProjection> searchByName(String searchField) {
        return recipeJpaRepository.searchRecipesByName(searchField);
    }

    @Override
    public List<RecipeNameProjection> searchByProfession(String searchField) {
        return recipeJpaRepository.searchRecipesByProfession(searchField);
    }

    @Override
    public List<RecipeNameProjection> searchByRarity(String searchField) {
        return recipeJpaRepository.searchRecipesByRarity(searchField);
    }

    // where to filter?
    @Override
    public List<Recipe> filterByAmountOfMaterials(Integer amount,Boolean lessOrMore) {
        List<Recipe> recipes = getAll();

        if(!lessOrMore){
            return removeRecipesWithMoreIngredients(amount, recipes);
        }

        return removeRecipesWithLessIngredients(amount, recipes);
    }

    private List<Recipe> removeRecipesWithMoreIngredients(Integer amount,List<Recipe> recipes) {

        recipes.removeIf(recipe -> recipe.getTotalMaterials() > amount);

        return recipes;
    }

    private List<Recipe> removeRecipesWithLessIngredients(Integer amount,List<Recipe> recipes) {

        recipes.removeIf(recipe -> recipe.getTotalMaterials() < amount);

        return recipes;
    }


}
