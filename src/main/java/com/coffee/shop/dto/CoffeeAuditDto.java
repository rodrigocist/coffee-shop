package com.coffee.shop.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
public class CoffeeAuditDto {

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
