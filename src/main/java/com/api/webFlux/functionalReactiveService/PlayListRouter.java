package com.api.webFlux.functionalReactiveService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PlayListRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(PlayListHandler handler){
		return RouterFunctions
				.route(GET("/playList").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/playList/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/playList").and(accept(MediaType.APPLICATION_JSON)), handler::save);
	}

}
