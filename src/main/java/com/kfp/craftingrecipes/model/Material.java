package com.kfp.craftingrecipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "materials")
public class Material {

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

    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ingredients> ingredients;

}
