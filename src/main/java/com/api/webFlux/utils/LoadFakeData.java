package com.api.webFlux.utils;

import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.webFlux.document.PlayList;
import com.api.webFlux.repository.PlayListRepository;
import reactor.core.publisher.Flux;


// Classe comentada pra nao afetar os dados do banco qdo a aplicação subir

/*
 * @Component public class LoadFakeData implements CommandLineRunner{
 * 
 * private final PlayListRepository playListRepository;
 * 
 * LoadFakeData(PlayListRepository playListRepository) { this.playListRepository
 * = playListRepository; }
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * playListRepository.deleteAll() .thenMany(Flux.just("API REST Spring Boot",
 * "Deploy de uma aplicação java no IBM Cloud", "Java 8", "Github",
 * "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
 * .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
 * .flatMap(playListRepository::save)) .subscribe(System.out::println); }
 * 
 * }
 */
