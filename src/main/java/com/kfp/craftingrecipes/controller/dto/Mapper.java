package com.kfp.craftingrecipes.controller.dto;

import com.kfp.craftingrecipes.model.Ingredient;
import com.kfp.craftingrecipes.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {

    public IngredientDto ingredientToDto(Ingredient ingredient){

        return new IngredientDto(ingredient.getMaterial().getName(), ingredient.getQuantity());
    }

    public RecipeDto recipeToDto(Recipe recipe){

        List<IngredientDto> ingredients = recipe.getIngredients()
                .stream()
                .map(this::ingredientToDto)
                .toList();

        return new RecipeDto(recipe.getName(), recipe.getTotalMaterials(), ingredients);
    }

    public List<RecipeDto> recipesToDto(List<Recipe> recipes){

       return recipes.stream()
                .map(this::recipeToDto)
                .toList();
    }
}
