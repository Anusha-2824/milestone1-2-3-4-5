package com.inventra.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SecurityAlert {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String alertType;

private String description;

private LocalDateTime time;

public SecurityAlert(){}

public SecurityAlert(String alertType,String description){
this.alertType=alertType;
this.description=description;
this.time=LocalDateTime.now();
}

public Long getId(){return id;}
public String getAlertType(){return alertType;}
public String getDescription(){return description;}
public LocalDateTime getTime(){return time;}

}