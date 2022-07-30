package br.com.imersaoalura.stickers.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true,
		securedEnabled = true,
		jsr250Enabled = true)
@RequiredArgsConstructor
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http
				.authorizeRequests(registry -> registry.anyRequest().authenticated())
				.oauth2ResourceServer()
				.jwt().jwtAuthenticationConverter(keycloakJwtAuthenticationConverter);
	}
}
