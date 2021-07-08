package com.slasher.italikaapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Esta clase se encarga de mapear la tabla {@code work} de la
 * base de datos {@code italikadb}. La estructura de esta clase es
 * la de un POJO en la cual se definen los atributos con sus
 * respectivos getters y setters.
 * <p>
 * Cada atrbuto representa un campo de la tabla de la base de datos.
 * La clase {@code Work} implementa {@link Serializable} para que sea
 * transmitida de forma remota.
 * <p>
 * Esta nueva entidad define 9 atributos:
 * <pre>
 *     folio
 *     typeOfWork
 *     mechanic
 *     vehicle
 *     cost
 *     fechaRecibido
 *     fechaEntrega
 *     client
 *     issues
 * </pre>
 *
 * @author Alexis Vazquez
 * @see java.io.Serializable
 * @since   11
 */
@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio")
    private Long folio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_type_of_work", referencedColumnName = "folio", nullable = false)
    private TypeOfWork typeOfWork;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_mechanic", referencedColumnName = "folio", nullable = false)
    private Mechanic mechanic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_vehicle", referencedColumnName = "plaque", nullable = false)
    private Vehicle vehicle;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "fecha_recibido", nullable = false)
    private LocalDateTime fechaRecibido;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDateTime fechaEntrega;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_client", referencedColumnName = "folio", nullable = false)
    private Client client;

    @Column(name = "issues", length = 225, nullable = false)
    private String issues;

    public Work(TypeOfWork typeOfWork, Mechanic mechanic,
                Vehicle vehicle, Double cost,
                LocalDateTime fechaRecibido, LocalDateTime fechaEntrega,
                Client client, String issues) {
        this.typeOfWork = typeOfWork;
        this.mechanic = mechanic;
        this.vehicle = vehicle;
        this.cost = cost;
        this.fechaRecibido = fechaRecibido;
        this.fechaEntrega = fechaEntrega;
        this.client = client;
        this.issues = issues;
    }

    public Work() {}

    public Long getFolio() {
        return folio;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(LocalDateTime fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }
}
