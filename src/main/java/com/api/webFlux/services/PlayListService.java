package com.api.webFlux.services;

import com.api.webFlux.document.PlayList;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {
	
	/**
	 * Como a programação não é mono, é flux.. e realitiva não retorna um List, mas sim um Flux
	 * 
	 * @return Flux<PlayList>
	 */
	public Flux<PlayList> findAll();
	
	/**
	 * Retrona zerou ou um elemento apenas (Mono)
	 * 
	 * @param id
	 * @return Mono<PlayList>
	 */
	public Mono<PlayList> findById(String id);
	
	/**
	 * Save
	 * 
	 * @param playList
	 * @return
	 */
	public Mono<PlayList> save(PlayList playList);

}
