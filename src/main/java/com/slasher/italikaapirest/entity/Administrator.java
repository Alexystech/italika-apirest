package com.slasher.italikaapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Esta clase es la encargada de mapear la tabla {@code administrator}
 * de la base de datos {@code italikadb}. La estructura de esta clase
 * es la de un POJO en la cual se definen los atributos con sus
 * respectivos getters y setters.
 *
 * <p>
 * Cada atributo representa un campo de la tabla de la base de datos.
 * <p>
 * La clase {@code Administrator} implementa {@link Serializable} para
 * que sea transmitida de forma remota.
 * <p>
 * Esta nueva entidad define 8 campos:
 * <pre>
 *     folio
 *     name
 *     lastName
 *     motherLastName
 *     userName
 *     eMail
 *     password
 *     cellphone
 * </pre>
 *
 * @author Alexis Vazquez
 * @see java.io.Serializable
 * @since   11
 */
@Entity
@Table(name = "administrator")
public class Administrator {

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

    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;

    @Column(name = "EMail", length = 40, nullable = false)
    private String eMail;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "cellphone", length = 10, nullable = false)
    private String cellphone;

    public Administrator(String name, String lastName, String motherLastName
            , String userName, String eMail
            , String password, String cellphone) {
        this.name = name;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
        this.cellphone = cellphone;
    }

    public Administrator() {
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
