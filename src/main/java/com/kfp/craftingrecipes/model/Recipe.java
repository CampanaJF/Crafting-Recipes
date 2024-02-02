package com.kfp.craftingrecipes.model;

import com.kfp.craftingrecipes.model.enumerate.ProfessionType;
import com.kfp.craftingrecipes.model.enumerate.RarityType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "item_level")
    private Integer itemLevel;

    @Column(name = "rarity")
    @Enumerated(EnumType.STRING)
    private RarityType rarityType;

    @Column(name = "profession")
    @Enumerated(EnumType.STRING)
    private ProfessionType professionType;

    @Column(name = "sell_price")
    private BigDecimal sellPrice;

//    @Column(name = "description")
//    private String description;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public Integer getTotalMaterials() {
        return this.getIngredients().stream()
                .mapToInt(Ingredient::getQuantity)
                .sum();
    }
}
