package com.example.demoarch;

import com.example.demoarch.domain.music.infra.document.Music;
import com.example.demoarch.domain.music.infra.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableReactiveMongoRepositories
@RequiredArgsConstructor
public class DemoArchApplication implements CommandLineRunner {

	private final MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoArchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux<Music> musics = Flux.just(new Music(null, "Music -1", null));

		for (int i = 0; i <= 1000; i++) {
			musics = musics.concatWith(Flux.just(new Music(null, "Music " + i, null)));
		}

		musicRepository.saveAll(musics).subscribe();
	}
}
