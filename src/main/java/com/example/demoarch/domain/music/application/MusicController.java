package com.example.demoarch.domain.music.application;

import com.example.demoarch.domain.music.core.Music;
import com.example.demoarch.domain.music.infra.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/musics")
@RequiredArgsConstructor
public class MusicController {

    private final MusicRepository musicRepository;

    @GetMapping
    public Flux<Music> findAllMusics(){
        return musicRepository.findAll()
            .flatMap(music -> Mono.just(
                new Music(
                    music.getId(),
                    music.getName(),
                    music.getArtist()
                )
            ));
    }

}
