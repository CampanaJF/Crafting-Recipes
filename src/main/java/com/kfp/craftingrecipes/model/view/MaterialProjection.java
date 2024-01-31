package com.kfp.craftingrecipes.model.view;

import org.springframework.beans.factory.annotation.Value;

public interface MaterialProjection {

    @Value("#{target.name}")
    String getName();


}
