package com.api.webFlux.functionalReactiveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import com.api.webFlux.document.PlayList;
import com.api.webFlux.services.PlayListService;
import reactor.core.publisher.Mono;


//Anotação comentada pra não ter conflito de endpoints do controler
//@Component
public class PlayListHandler {

	@Autowired
	PlayListService playListService;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(playListService.findAll(), PlayList.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		
		String ID = request.pathVariable("id");
		
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(playListService.findById(ID), PlayList.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		
		final Mono<PlayList> playList = request.bodyToMono(PlayList.class);
		
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playList.flatMap(playListService::save), PlayList.class));
	}
}
