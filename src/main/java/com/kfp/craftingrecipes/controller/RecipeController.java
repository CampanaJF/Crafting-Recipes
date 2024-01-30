package com.kfp.craftingrecipes.controller;

import com.kfp.craftingrecipes.controller.api.RecipeApi;
import com.kfp.craftingrecipes.exception.RecipeNotFoundException;
import com.kfp.craftingrecipes.model.view.RecipeView;
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

@Tag(name = "recipes")
@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController implements RecipeApi {

    private final RecipeService recipeService;


    @Override
    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeView> get(@PathVariable("recipeId") Integer recipeId){
        try{
            return ResponseEntity.ok(recipeService.getRecipe(recipeId));
        }catch(RecipeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

}
