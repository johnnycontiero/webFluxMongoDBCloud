package com.api.webFlux.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.webFlux.document.PlayList;
import com.api.webFlux.services.PlayListService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
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
	
	@GetMapping(value="/playList/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, PlayList>> getPlaylistByWebflux(){

		System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
		
		// Intervalo entre cada resposta(stream) que será enviada ao cliente
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(6));
		
        Flux<PlayList> playlistFlux = playListService.findAll();

        return Flux.zip(interval, playlistFlux);
        
	}
	
	@GetMapping(value="/playList/mvc")
	public List<String> getPlaylistByMvc() throws InterruptedException {

		System.out.println("---Start get Playlists by MVC--- " + LocalDateTime.now());


		List<String> playlistList = new ArrayList<>();
		playlistList.add("PlayList 1");
		playlistList.add("PlayList 2");
		playlistList.add("PlayList 3");
		playlistList.add("PlayList 4");
		playlistList.add("PlayList 5");
		TimeUnit.SECONDS.sleep(10);

		return playlistList;

	}

}
