package com.kfp.craftingrecipes.controller.dto;

import java.util.List;

public record RecipeDto(

        String name,

        Integer totalIngredients,

        List<IngredientDto> ingredients
) {
}
