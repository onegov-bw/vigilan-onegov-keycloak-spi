package com.vigilan.onegov.keycloak.spi.provider;

import com.vigilan.onegov.keycloak.spi.resource.UserPasswordResource;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class CustomResourceProvider implements RealmResourceProvider {

    private final KeycloakSession session;
    public CustomResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return new UserPasswordResource(session);
    }

    @Override
    public void close() {
    }
}
