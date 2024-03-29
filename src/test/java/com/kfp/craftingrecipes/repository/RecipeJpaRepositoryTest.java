package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;


@DataJpaTest
@Sql(scripts = "/clean-up.sql", executionPhase = AFTER_TEST_METHOD)
class RecipeJpaRepositoryTest {

    @Autowired
    private RecipeJpaRepository recipeJpaRepository;

    @Test
    void shouldGetARecipe() {
        RecipeIngredientsProjection recipeIngredients = recipeJpaRepository
                .getRecipeById(1).orElse(null);

        assertNotNull(recipeIngredients);
        assertEquals("Plans: Hammer of Righteous Might", recipeIngredients.getName());
    }

    // H2 IS CASE SENSITIVE FOR THIS CASE, SO THE RESULT IS A LITTLE DIFFERENT
    @Test
    void shouldFindAllMatchingRecipesThatContainTheSearchedParameterInTheirName() {
        List<RecipeNameProjection> recipes = recipeJpaRepository.searchRecipesByName("Ha");

        assertNotNull(recipes);
        assertEquals(2, recipes.size());
        assertEquals("Plans: Hammer of Righteous Might", recipes.get(0).getName());
    }

    @Test
    void shouldFindAllMatchingRecipesThatHaveTheSearchedProfession() {
        List<RecipeNameProjection> recipes = recipeJpaRepository
                .searchRecipesByProfession("Enchanting");

        assertNotNull(recipes);
        assertEquals(4, recipes.size());
        assertEquals("Formula: Enchant Weapon - Mongoose", recipes.get(0).getName());
    }

    @Test
    void shouldFindAllMatchingRecipesThatHaveTheSearchedRarity() {
        List<RecipeNameProjection> recipes = recipeJpaRepository
                .searchRecipesByRarity("Common");

        assertNotNull(recipes);
        assertEquals(4, recipes.size());
        assertEquals("Schematic: White Smoke Flare", recipes.get(0).getName());
    }



}