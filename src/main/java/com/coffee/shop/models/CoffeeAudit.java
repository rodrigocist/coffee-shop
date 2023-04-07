package com.coffee.shop.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
@Table(name ="coffee_audit")
public class CoffeeAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String action;
    private String api;
    private String fromRequest;
    private String userRequest;
    private String data;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserted;
    private boolean active;

}
