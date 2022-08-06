package br.com.imersaoalura.stickers.controller;

import br.com.imersaoalura.stickers.model.CustomPrincipal;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {

	protected CustomPrincipal getPrincipal() {
		if(SecurityContextHolder.getContext().getAuthentication() instanceof KeycloakAuthenticationToken){
			KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			AccessToken accessToken = principal.getKeycloakSecurityContext().getToken();
			return buildCustomPrincipal(principal, accessToken);
		}
		return null;
	}

	private CustomPrincipal buildCustomPrincipal(KeycloakPrincipal principal, AccessToken accessToken) {
		return CustomPrincipal
				.builder()
				.id(principal.getName())
				.accessToken(accessToken)
				.name(accessToken.getName())
				.email(accessToken.getEmail())
				.build();
	}

}