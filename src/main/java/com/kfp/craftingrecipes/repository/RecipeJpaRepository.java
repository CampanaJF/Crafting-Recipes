package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {

    Optional<RecipeIngredientsProjection> getRecipeById(Integer id);

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r; "
    )
    List<RecipeNameProjection> findAllRecipes();

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r where r.name like %:name% ;"
    )
    List<RecipeNameProjection> searchRecipesByName(@Param("name")String search);

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r where r.profession like :profession ;"
    )
    List<RecipeNameProjection> searchRecipesByProfession(@Param("profession") String search);

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r where r.rarity like :rarity ;"
    )
    List<RecipeNameProjection> searchRecipesByRarity(@Param("rarity") String search);

}
