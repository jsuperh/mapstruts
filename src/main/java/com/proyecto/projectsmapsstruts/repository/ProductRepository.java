package com.proyecto.projectsmapsstruts.repository;

import com.proyecto.projectsmapsstruts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
