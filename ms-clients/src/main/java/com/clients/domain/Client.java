package com.clients.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends Person{


    private Long clientId;

    @Column(nullable = false)
    private String userPassword;

    private Boolean status;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean state) {
        this.status = state;
    }
}
