package com.kfp.craftingrecipes.controller.api;

import com.kfp.craftingrecipes.controller.dto.RecipeDto;
import com.kfp.craftingrecipes.controller.dto.RecipeSearchFilter;
import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    ResponseEntity<RecipeIngredientsProjection> get(
            @PathVariable("recipeId") Integer recipeId)
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
    @GetMapping("search/name/{search}")
    ResponseEntity<List<RecipeNameProjection>> searchByName(
            @PathVariable("search") String search);

    @Operation(
            description = "It should get a list of all recipes that have the specified profession, since" +
                    "its a text field and needs to completely match the searched field," +
                    " the casing is irrelevant",
            summary =  "search for recipes by their profession"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200")})
    @GetMapping("search/profession/{search}")
    ResponseEntity<List<RecipeNameProjection>> searchByProfession(
            @PathVariable("search") String search);

    @Operation(
            description = "It should get a list of all recipes that have the specified rarity, since" +
                    "its a text field and needs to completely match the searched field," +
                    " the casing is irrelevant",
            summary =  "search for recipes by their rarity"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200")})
    @GetMapping("search/rarity/{search}")
    ResponseEntity<List<RecipeNameProjection>> searchByRarity(
            @PathVariable("search") String search);

    @Operation(
            description = "It should get a list of all recipes that have the amount of ingredients" +
                    " specified or less this isn't about the different ingredients," +
                    " but the total amount of all collected ingredients," +
                    " not how many different materials are needed.",
            summary =  "filter recipes by the total amount of ingredients required"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200")})
    @GetMapping("/filter")
    ResponseEntity<List<RecipeDto>> filter(
            @RequestBody RecipeSearchFilter recipeSearchFilter);
}
