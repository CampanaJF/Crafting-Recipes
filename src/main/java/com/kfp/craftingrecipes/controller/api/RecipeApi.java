package com.kfp.craftingrecipes.controller.api;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.view.RecipeView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface RecipeApi {

    @Operation(
            description = "The view/projection of a recipe, this view contains the name of the recipe," +
                          " the view of the ingredients and the quantity of each",
            summary =  "gets all the materials and the quantity necessary for a recipe"
    )
    @ApiResponses(value = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400")})
    @GetMapping
    ResponseEntity<RecipeView> get(@PathVariable("recipeId") Integer recipeId)
            throws RecipeNotFoundException;
}
