package com.slasher.italikaapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Esta clase se encarga de mapear la tabla {@code vehicle} de la
 * base de datos {@code italikadb}. La estructura de esta clase es
 * la de un POJO en la cual se definnen los atributos con sus
 * respectivos getters y setters.
 * <p>
 * Cada atributo representa un campo de la tabla de la base de datos.
 * <p>
 * La clase {@code Vehicle} implementa {@link Serializable} para que sea
 * transmitida de forma remota.
 * <p>
 * Esta nueva entidad define 4 atributos:
 * <pre>
 *     palque
 *     brand
 *     model
 *     year
 * </pre>
 *
 * @author Alexis Vazquez
 * @see java.io.Serializable
 * @since   11
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "plaque", length = 7)
    private String plaque;

    @Column(name = "brand", length = 20, nullable = false)
    private String brand;

    @Column(name = "model", length = 20, nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private Integer year;

    public Vehicle(String plaque, String brand
            , String model, Integer year) {
        this.plaque = plaque;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Vehicle() {}

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
