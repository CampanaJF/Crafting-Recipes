package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.Material;
import com.kfp.craftingrecipes.model.view.RecipeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaterialJpaRepository extends JpaRepository<Material, Integer> {


}
