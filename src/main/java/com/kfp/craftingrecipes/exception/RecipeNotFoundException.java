package com.kfp.craftingrecipes.exception;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String message){
        super(message);
    }
}
