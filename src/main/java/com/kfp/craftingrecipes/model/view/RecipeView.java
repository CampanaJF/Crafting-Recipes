package com.kfp.craftingrecipes.model.view;

import org.springframework.beans.factory.annotation.Value;

public interface RecipeView {

    @Value("#{target.name}")
    String getName();

    @Value("#{target.material}")
    String getMaterial();

    @Value("#{target.quantity}")
    Integer getQuantity();

}
