package com.vigilan.onegov.keycloak.spi.dto;

public class UserPasswordResponse {
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
