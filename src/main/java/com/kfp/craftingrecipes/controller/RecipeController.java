package com.kfp.craftingrecipes.controller;

import com.kfp.craftingrecipes.controller.api.RecipeApi;
import com.kfp.craftingrecipes.controller.dto.Mapper;
import com.kfp.craftingrecipes.controller.dto.RecipeDto;
import com.kfp.craftingrecipes.controller.dto.RecipeSearchFilter;
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
import org.springframework.web.bind.annotation.RequestBody;
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

    private final Mapper mapper;

    //TODO
    // move jpa native queries to their own file <-> why? they aren't complex enough yet
    // turn those queries into procedures maybe? <-> go deeper first
    // filter recipes that use above a certain amount of materials
    // filter recipes that use materials of a certain rarity
    // filter recipes by the total cost of their materials
    // move the testing db from h2 to mysql

    @Override
    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeIngredientsProjection> get(
            @PathVariable("recipeId") Integer recipeId){
        try{
            return ResponseEntity.ok(recipeService.getRecipe(recipeId));
        }catch(RecipeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeNameProjection>> getAll(){
        return ResponseEntity.ok(recipeService.getAllNames());
    }

    @Override
    @GetMapping("search/name/{search}")
    public ResponseEntity<List<RecipeNameProjection>> searchByName(
            @PathVariable("search") String search) {
        return ResponseEntity.ok(recipeService.searchByName(search));
    }

    @Override
    @GetMapping("search/profession/{search}")
    public ResponseEntity<List<RecipeNameProjection>> searchByProfession(
            @PathVariable("search") String search) {
        return ResponseEntity.ok(recipeService.searchByProfession(search));
    }

    @Override
    @GetMapping("search/rarity/{search}")
    public ResponseEntity<List<RecipeNameProjection>> searchByRarity(
            @PathVariable("search") String search) {
        return ResponseEntity.ok(recipeService.searchByRarity(search));
    }

    @Override
    @GetMapping("/filter")
    public ResponseEntity<List<RecipeDto>> filter(
            @RequestBody RecipeSearchFilter recipeSearchFilter) {

        return ResponseEntity.ok(mapper.recipesToDto(
                recipeService.filterByAmountOfMaterials(
                        recipeSearchFilter.amount(),recipeSearchFilter.lessOrMore())));
    }


}
