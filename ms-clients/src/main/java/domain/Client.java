package domain;

import jakarta.persistence.Column;


public class Client extends Person{

    @Column(nullable = false, unique = true)
    private String clientId;

    @Column(nullable = false)
    private String password;

    private Boolean status;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return status;
    }

    public void setState(Boolean state) {
        this.status = state;
    }
}
