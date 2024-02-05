package com.kfp.craftingrecipes.service.implementation;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.Ingredient;
import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.IngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.repository.RecipeJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;
    private RecipeJpaRepository recipeJpaRepository;

    @BeforeEach
    public void setup() {

        recipeJpaRepository = mock(RecipeJpaRepository.class);
        recipeService = new RecipeServiceImpl(recipeJpaRepository);
    }

    @Test
    public void shouldThrowExceptionWhenRecipeDoesNotExist(){

        assertThrows(RecipeNotFoundException.class, () -> recipeService.getRecipe(1));
    }

    @Test
    public void shouldReturnRecipeIngredientsProjectionIfItExists(){

        RecipeIngredientsProjection givenProjection = givenRecipeIngredientsProjection();

        when(recipeJpaRepository.getRecipeById(1)).thenReturn(Optional.of(givenProjection));

        RecipeIngredientsProjection actual = recipeService.getRecipe(1);

        assertEquals("Thunderfury Blessed Blade of the Windseeker", actual.getName());
        assertEquals(10, actual.getIngredients().get(0).getQuantity());
    }

    @Test
    public void shouldReturnAllRecipes(){

        List<Recipe> givenRecipes = givenExistingRecipes();

        when(recipeJpaRepository.findAll()).thenReturn(givenRecipes);

        List<Recipe> actual = recipeService.getAll();

        assertEquals("Void Shatter", actual.get(0).getName());
        assertEquals("White Smoke Flare", actual.get(1).getName());
    }

    @Test
    public void shouldFilterRecipesByAmountOfIngredientsLessThan(){
        List<Recipe> givenRecipes = givenExistingRecipes();

        when(recipeJpaRepository.findAll()).thenReturn(givenRecipes);

        List<Recipe> actual = recipeService.filterByAmountOfMaterials(2,false);

        assertEquals(1, actual.size());
        assertEquals("Void Shatter", actual.get(0).getName());
        assertEquals(1, actual.get(0).getTotalMaterials());
    }

    @Test
    public void shouldFilterRecipesByAmountOfIngredientsMoreThan(){
        List<Recipe> givenRecipes = givenExistingRecipes();

        when(recipeJpaRepository.findAll()).thenReturn(givenRecipes);

        List<Recipe> actual = recipeService.filterByAmountOfMaterials(2,true);

        assertEquals(1, actual.size());
        assertEquals("White Smoke Flare", actual.get(0).getName());
        assertEquals(3, actual.get(0).getTotalMaterials());
    }

    private List<Recipe> givenExistingRecipes() {

        Ingredient voidCrystal = Ingredient.builder().id(1).quantity(1).build();

        Recipe voidShatter = Recipe.builder()
                .name("Void Shatter")
                .ingredients(List.of(voidCrystal))
                .id(1)
                .build();

        Ingredient netherweaveCloth = Ingredient.builder().id(2).quantity(3).build();

        Recipe whiteSmokeFlare = Recipe.builder()
                .name("White Smoke Flare")
                .ingredients(List.of(netherweaveCloth))
                .id(2)
                .build();

        List<Recipe> recipes = new ArrayList<>();

        recipes.add(voidShatter);
        recipes.add(whiteSmokeFlare);

        return recipes;
    }

    private RecipeIngredientsProjection givenRecipeIngredientsProjection() {

        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

        IngredientsProjection ingredientsProjection = factory
                .createProjection(IngredientsProjection.class);
        RecipeIngredientsProjection recipeProjection = factory
                .createProjection(RecipeIngredientsProjection.class);

        recipeProjection.setName("Thunderfury Blessed Blade of the Windseeker");
        ingredientsProjection.setMaterialName("Khorium Bar");
        ingredientsProjection.setQuantity(10);
        recipeProjection.setIngredients(List.of(ingredientsProjection));

        return recipeProjection;
    }


}