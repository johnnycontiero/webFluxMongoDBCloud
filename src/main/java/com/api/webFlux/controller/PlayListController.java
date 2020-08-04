package com.api.webFlux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.webFlux.document.PlayList;
import com.api.webFlux.services.PlayListService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Anotação comentada pra não ter conflito de endpoints do router
//@RestController
public class PlayListController {
	
	@Autowired
	PlayListService playListService;
	
	@GetMapping(value = "/playList")
	public Flux<PlayList> getAllPlayList(){
		return playListService.findAll();
	}
	
	@GetMapping(value = "/playList/{id}")
	public Mono<PlayList> getPlayListById(@PathVariable String id){
		return playListService.findById(id);
	}
	
	@PostMapping(value = "/playList")
	public Mono<PlayList> savePlayList(@RequestBody PlayList playList){
		return playListService.save(playList);
	}

}
