package br.com.imersaoalura.stickers.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;

import java.util.Collection;
import java.util.Map;

public class Account extends AbstractOAuth2TokenAuthenticationToken<Jwt> {

	private String id;
	private String fullName;
	private String email;

	public Account(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
		super(jwt, authorities);
		this.setAuthenticated(true);
		applyDataFromJwt(jwt);
	}

	private void applyDataFromJwt(Jwt jwt) {
		this.id = jwt.getSubject();
		this.fullName = jwt.getClaims().get("name").toString();
		this.email = jwt.getClaims().get("email").toString();
	}

	@Override
	public Map<String, Object> getTokenAttributes() {
		return this.getToken().getClaims();
	}

}
