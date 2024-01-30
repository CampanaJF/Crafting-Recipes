package com.kfp.craftingrecipes.repository;

import com.kfp.craftingrecipes.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialJpaRepository extends JpaRepository<Material, Integer> {
}
