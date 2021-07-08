package com.slasher.italikaapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Esta clase se encarga de mapear la tabla {@code client} de la
 * base de datos {@code italikadb}. La estructura de esta clase es
 * la de un POJO en la cual se definen los atributos con sus
 * respectivos getters y setters.
 * <p>
 * Cada atributo representa un campo de la tabla de la base de datos.
 * <p>
 * La clase {@code Client} implementa {@link Serializable} para que sea
 * transmitida de forma remota.
 * <p>
 * Esta nueva entidad define 5 atributos:
 * <pre>
 *     folio
 *     name
 *     lastName
 *     motherLastName
 *     cellphone
 * </pre>
 *
 * @author Alexis Vazquez
 * @see java.io.Serializable
 * @since    11
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio")
    private Long folio;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "mother_last_name", length = 20, nullable = false)
    private String motherLastName;

    @Column(name = "cellphone", length = 10, nullable = false)
    private String cellphone;

    public Client(String name, String lastName,
                  String motherLastName, String cellphone) {
        this.name = name;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.cellphone = cellphone;
    }

    public Client() {}

    public Long getFolio() {
        return folio;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
