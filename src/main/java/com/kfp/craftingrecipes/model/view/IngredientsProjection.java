package com.kfp.craftingrecipes.model.view;

import org.springframework.beans.factory.annotation.Value;

public interface IngredientsProjection {

    @Value("#{target.quantity}")
    Integer getQuantity();

    @Value("#{target.material.name}")
    String getMaterialName();
}
