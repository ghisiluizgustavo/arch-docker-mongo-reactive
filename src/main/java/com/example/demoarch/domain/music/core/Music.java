package com.example.demoarch.domain.music.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    private String id;
    private String name;
    private Artist artist;



}
