package com.kfp.craftingrecipes.controller.api;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RecipeApi {

    @Operation(
            description = "The view/projection of a recipe, this view contains the name of the recipe," +
                          " the view of the ingredients and the quantity of each",
            summary =  "gets all the materials and the quantity necessary for a recipe"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400")})
    @GetMapping("/{recipeId}")
    ResponseEntity<RecipeIngredientsProjection> get(@PathVariable("recipeId") Integer recipeId)
            throws RecipeNotFoundException;

    @Operation(
            description = "It should get a list of all available recipes, only their names",
            summary =  "obtain a list of the names of all recipes"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200")})
    @GetMapping
    ResponseEntity<List<RecipeNameProjection>> getAll();

    @Operation(
            description = "It should get a list of all recipes that contain the text that was searched for",
            summary =  "search for a recipe by its name"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200")})
    @GetMapping("search/name/{searchField}")
    ResponseEntity<List<RecipeNameProjection>> searchByName(@PathVariable("searchField") String searchField);
}
