package br.com.imersaoalura.stickers.model;

import lombok.Builder;
import lombok.Data;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;

@Data
@Builder
public class CustomPrincipal {
	private String id;
	private String name;
	private String email;
	private String companyId;
	private AccessToken accessToken;
}
