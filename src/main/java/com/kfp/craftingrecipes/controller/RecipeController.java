package com.kfp.craftingrecipes.controller;

import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.Recipe;
import com.kfp.craftingrecipes.model.view.RecipeView;
import com.kfp.craftingrecipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> get(@PathVariable("recipeId") Integer recipeId){
        try{
            return ResponseEntity.ok(recipeService.getRecipe(recipeId));
        }catch(RecipeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("view/{recipeId}")
    public ResponseEntity<List<RecipeView>> getView(@PathVariable("recipeId") Integer recipeId){
        try{
            return ResponseEntity.ok(recipeService.getRecipeView(recipeId));
        }catch(RecipeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
