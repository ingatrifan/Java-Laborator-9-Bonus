package org.lab9.util;

import jdk.nashorn.internal.ir.IdentNode;
import org.lab9.entity.Album;
import org.lab9.entity.Genre;
import org.lab9.repo.AlbumRepository;
import org.lab9.repo.GenreRepository;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    public static List<Genre> getMaxAlbumSet(){
        GenreRepository genreRepository = new GenreRepository();
        List<Genre> genreList =genreRepository.getAlbums();
        List<Genre> result = new ArrayList<>();
        List<String> differentGenre = genreRepository.getDifferentGenre();
        List<Integer> differentArtist = genreRepository.getDifferentIds();
        for (Genre genre : genreList){
            if (differentArtist.contains(genre.getArtistId()) && differentGenre.contains(genre.getGenre())){
                result.add(genre);
                differentArtist.remove(new Integer(genre.getArtistId()));
                differentGenre.remove(genre.getAlbumName());
            }
        }
        return result;
    }
}
