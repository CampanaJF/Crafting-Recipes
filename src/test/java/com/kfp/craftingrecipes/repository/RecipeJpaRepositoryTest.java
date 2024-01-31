package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;


@DataJpaTest
@Sql(scripts = "/insert-data.sql")
@Sql(scripts = "/clean-up.sql", executionPhase = AFTER_TEST_METHOD)
class RecipeJpaRepositoryTest {

    // ESTO SE DEBERIA TESTEAR EN REPO, NO CORRESPONDE AL SERVICE, EL SERVICE NO HACE NADA
    // SOLO DEVUELVE EL RESULTADO DEL REPO, MIDDLEMAN
    // PROJECTIONS

    @Autowired
    private RecipeJpaRepository recipeJpaRepositoryRepository;

    @Test
    void shouldGetARecipe() {
        RecipeIngredientsProjection recipeIngredients = recipeJpaRepositoryRepository
                .getRecipeById(1).orElse(null);

        assertNotNull(recipeIngredients);
        assertEquals("Plans: Hammer of Righteous Might", recipeIngredients.getName());
    }

}