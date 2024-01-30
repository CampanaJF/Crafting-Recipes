# Crafting Recipes

Materials and Recipes:

    A material can be used in multiple recipes.
    A recipe can contain multiple materials.

In a many-to-many relationship between materials and recipes, you would typically need a junction table (also known as an associative or link table)
to represent the relationship. This table facilitates the link between materials and recipes.
The attributes of this junction table can include:

    Quantity:
        Represents the quantity or amount of the materials used in the recipe.
        


## Notes:

* Recipe is the recipe itself, not the knowledge of that the recipe holds.