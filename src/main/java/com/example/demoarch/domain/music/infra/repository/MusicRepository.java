package com.example.demoarch.domain.music.infra.repository;

import com.example.demoarch.domain.music.infra.document.Music;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends ReactiveMongoRepository<Music, String> {}
