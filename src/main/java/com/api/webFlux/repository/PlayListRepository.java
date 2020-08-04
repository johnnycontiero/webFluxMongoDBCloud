package com.api.webFlux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.webFlux.document.PlayList;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {

}
