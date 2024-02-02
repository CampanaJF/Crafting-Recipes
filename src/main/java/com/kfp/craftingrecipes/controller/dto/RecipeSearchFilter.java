package com.kfp.craftingrecipes.controller.dto;

public record RecipeSearchFilter(
        Integer amount,
        Boolean lessOrMore
) {
}
