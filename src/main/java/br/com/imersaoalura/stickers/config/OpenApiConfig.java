package br.com.imersaoalura.stickers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

	public static final String SERVER_LOCAL = "http://localhost:8080/";
	private static final String API_VERSION = "v1.0";
	private static final String API_TITLE = "Alura Stickers";
	private static final String API_DESCRIPTION = "API de Integração para Frontend";

	@Bean
	public OpenAPI api() {
		return new OpenAPI()
				.info(apiInfo())
				.servers(Arrays.asList(
						new Server().url(SERVER_LOCAL).description("Dev - Local")));
	}

	private Info apiInfo() {
		return new Info()
				.title(API_TITLE)
				.description(API_DESCRIPTION)
				.version(API_VERSION);
	}

}