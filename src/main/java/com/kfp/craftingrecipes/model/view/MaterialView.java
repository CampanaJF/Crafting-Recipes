package com.kfp.craftingrecipes.model.view;

import org.springframework.beans.factory.annotation.Value;

public interface MaterialView {

    @Value("#{target.name}")
    String getName();


}
