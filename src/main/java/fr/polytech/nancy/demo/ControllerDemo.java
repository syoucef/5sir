package fr.polytech.nancy.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerDemo {

    @Autowired
    private ProductDao productDao;


    // injection de dépendances .....

    @GetMapping(value = "/afficher")
    public String afficherBonjour(){
        return "Nous remettre dans le bain !";
    }


    @GetMapping(value = "/tous")
    public List<Product> afficherTousLesProduits(){
        return  this.productDao.findAll();
    }

    /*
    GET : envoyer une ressource
    POST : créer unenouvelle ressources
    PUT : mettre à jour une ressource
    DELETE : supprimer une ressource
     */

    // question :

    @PutMapping(value = "/metteajour")
    public void mettreAJour(@RequestBody  Product product){
        this.productDao.save(product);
    }


// méthode qui renvoie un produit sachant son code ....
    @GetMapping(value = "/produit/{code}")
    public Product afficherUnSeulProduit(@PathVariable  int code){
        return this.productDao.findByCode(code);
    }


  // On ajoute un Endpoint ....
    @GetMapping(value = "/produitCher/{prix}")
  public List<Product> afficherProduitPrixSuperieur(@PathVariable  double prix){
        return this.productDao.findByPrixGreaterThan(prix);
  }


  // petit moteur de recherche textuel .....
    @GetMapping(value = "/chercher/{s}")
    public List<Product> chercherDesProduits(@PathVariable  String s){
        return  this.productDao.findByDesignationLike("%"+ s + "%");
    }


    // méthode pour supprimer un produit sachant son code ....
    @DeleteMapping(value = "/supprimer/{code}")
    public void supprimer(@PathVariable  int code){
        this.productDao.deleteById(code);
    }


    // écriture des requête "à la main" ....
    // Exercice : récrire la méthode qui permet de renvoyer tous les produits dont le prix est supérieur à une certaine
    // valeur ?

    @GetMapping(value = "/chers/{prix}")
    public List<Product> afficherChers(@PathVariable double prixtest){
    return this.productDao.renvoyerProduitChers(prixtest);
    }




}
