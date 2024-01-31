package com.kfp.craftingrecipes.controller;

import com.kfp.craftingrecipes.controller.api.RecipeApi;
import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.view.RecipeIngredientsProjection;
import com.kfp.craftingrecipes.model.view.RecipeNameProjection;
import com.kfp.craftingrecipes.service.RecipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Tag(name = "recipes")
@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController implements RecipeApi {

    private final RecipeService recipeService;

    //TODO
    // search by profession (add recipes from other professions first)
    // search by rarity
    // add a new recipe
    // dynamic searching by all fields at once
    // move jpa native queries to their own file
    // turn those queries into procedures maybe?

    @Override
    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeIngredientsProjection> get(@PathVariable("recipeId") Integer recipeId){
        try{
            return ResponseEntity.ok(recipeService.getRecipe(recipeId));
        }catch(RecipeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeNameProjection>> getAll(){
        return ResponseEntity.ok(recipeService.getAll());
    }

    @Override
    @GetMapping("search/{searchField}")
    public ResponseEntity<List<RecipeNameProjection>> searchByName(String searchField) {
        return ResponseEntity.ok(recipeService.searchByName(searchField));
    }


}
