package org.lab9.app;


import org.lab9.JDBC.ArtistDAO;
import org.lab9.entity.Album;
import org.lab9.entity.Artist;
import org.lab9.entity.Genre;
import org.lab9.repo.AlbumRepository;
import org.lab9.repo.ArtistRepository;
import org.lab9.util.Algorithm;
import org.lab9.util.DataFaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void generateFakeJPAData(){
        DataFaker.generateArtists(10);
        DataFaker.generateAlbums(10);
        DataFaker.generateGenres(35);
    }
    public static void main( String[] args )
    {
//        generateFakeJPAData();
        List<Genre> genres = Algorithm.getMaxAlbumSet();

        for (Genre genre : genres){
            System.out.println(genre.getAlbumName()+" "+genre.getGenre()+" "+genre.getArtistId());
        }
    }

}
