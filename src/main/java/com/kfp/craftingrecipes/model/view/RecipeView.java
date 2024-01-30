package com.kfp.craftingrecipes.model.view;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface RecipeView {

    @Value("#{target.name}")
    String getName();

    @Value("#{target.ingredients}")
    List<IngredientsView>  getIngredients();

}
