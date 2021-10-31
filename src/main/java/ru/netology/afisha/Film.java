package ru.netology.afisha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Film {
    private int id;
    private int idFilm;
    private String urlFilm;
    private String nameFilm;
    private String janreFilm;

}

