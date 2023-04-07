package com.coffee.shop.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Component
@Validated
@PropertySource("classpath:application-aws.properties")
@ConfigurationProperties(prefix = "security.api.credentials")
@Data
public class ApiCustomCredentials {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String role;

}