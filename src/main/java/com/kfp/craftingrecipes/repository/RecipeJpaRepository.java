package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.RecipeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {
    @Query(
            nativeQuery = true,
            value = "select r.name, m.name as material, i.quantity from recipes r " +
                    "left join ingredients i on i.recipe_id = r.id " +
                    "left join materials m on m.id = i.material_id " +
                    "where r.id = :id ;"
    )
    List<RecipeView> findRecipeView(Integer id);

    RecipeView getRecipeById(Integer id);

}
