package com.vigilan.onegov.keycloak.spi.resource;

import com.vigilan.onegov.keycloak.spi.dto.UserPasswordBody;
import com.vigilan.onegov.keycloak.spi.dto.UserPasswordResponse;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class UserPasswordResource {

    private final KeycloakSession session;

    public UserPasswordResource(KeycloakSession session) {
        this.session = session;
    }

    @POST
    @Path("/users/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserPasswordResponse validatePassword(@PathParam("id") String id, UserPasswordBody userPasswordBody) {
        UserModel userModel = session.users().getUserById(session.getContext().getRealm(), id);
        UserCredentialModel cred = UserCredentialModel.password(userPasswordBody.getPassword());
        UserPasswordResponse userPasswordResponse = new UserPasswordResponse();
        if(session.userCredentialManager().isValid(session.getContext().getRealm(), userModel, cred)){
            userPasswordResponse.setValid(true);
        }
        return userPasswordResponse;
    }
}
