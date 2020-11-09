package fr.polytech.nancy.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    public Product findByCode(int code);


    // tous les produit dont les prix est supérieure à une certaine valeur ....
   List<Product> findByPrixGreaterThan(double prix);


}
