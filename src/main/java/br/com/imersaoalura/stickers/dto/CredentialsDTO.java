package br.com.imersaoalura.stickers.dto;

import org.keycloak.representations.idm.CredentialRepresentation;

public class CredentialsDTO {

	public static CredentialRepresentation createPasswordCredentials(String password) {
		CredentialRepresentation passwordCredentials = new CredentialRepresentation();
		passwordCredentials.setTemporary(false);
		passwordCredentials.setType(CredentialRepresentation.PASSWORD);
		passwordCredentials.setValue(password);
		return passwordCredentials;
	}
}