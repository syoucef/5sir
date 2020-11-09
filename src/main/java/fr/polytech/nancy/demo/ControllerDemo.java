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



}
