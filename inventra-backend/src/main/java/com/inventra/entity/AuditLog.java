package com.inventra.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditLog {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String action;

private String userEmail;

private LocalDateTime timestamp;

public AuditLog() {}

public AuditLog(String action,String userEmail){
this.action=action;
this.userEmail=userEmail;
this.timestamp=LocalDateTime.now();
}

public Long getId(){return id;}
public String getAction(){return action;}
public String getUserEmail(){return userEmail;}
public LocalDateTime getTimestamp(){return timestamp;}

}