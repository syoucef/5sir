package fr.polytech.nancy.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    private int code;
    private String designation;
    private double prix;

    public Product() {
    }

    public Product(int code, String designation, double prix) {
        this.code = code;
        this.designation = designation;
        this.prix = prix;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                '}';
    }
}
