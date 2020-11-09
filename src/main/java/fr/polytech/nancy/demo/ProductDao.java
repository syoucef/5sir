package fr.polytech.nancy.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    public Product findByCode(int code);


    // tous les produit dont les prix est supérieure à une certaine valeur ....
   List<Product> findByPrixGreaterThan(double prix);


   // moteur de recherche .....
    public List<Product> findByDesignationLike(String s);

    // récriture de la méthode qui renvoie tous les produits dont le prix est > prix ....

    @Query("SELECT p FROM Product p WHERE p.prix > :prixtest")
    public List<Product> renvoyerProduitChers(double prixtest);


}
