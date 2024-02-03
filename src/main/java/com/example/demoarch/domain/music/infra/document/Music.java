package com.example.demoarch.domain.music.infra.document;

import com.example.demoarch.domain.music.core.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    @Id
    private String id;
    private String name;
    private Artist artist;

}
