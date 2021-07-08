package com.slasher.italikaapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Esta clase se encarga de mapear la tabla {@code TypeOfWork} de la
 * base de datos {@code italikadb}. La estructura de esta clase es la de
 * un POJO en la cual se definen los atributos con sus respectivos
 * getters y setters.
 * <p>
 * Cada atributo representa un campo de la tabla de la base de dadtos.
 * <p>
 * La clase {@code TypeOfWork} implementa {@link Serializable} para que sea
 * transmitida de forma remota.
 * <p>
 * Esta nueva entidad define 2 atributos:
 * <pre>
 *     folio
 *     nameOfWork
 * </pre>
 *
 * @author Alexis Vazquez
 * @see java.io.Serializable
 * @since   11
 */
@Entity
@Table(name = "type_of_work")
public class TypeOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio")
    private Long folio;

    @Column(name = "name_of_work", length = 30, nullable = false)
    private String nameOfWork;

    public TypeOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public TypeOfWork() {}

    public Long getFolio() {
        return folio;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfService) {
        this.nameOfWork = nameOfService;
    }
}
