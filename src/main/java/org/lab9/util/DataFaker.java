package org.lab9.util;

import com.github.javafaker.Faker;
import org.lab9.entity.Album;
import org.lab9.entity.Artist;
import org.lab9.entity.Genre;
import org.lab9.repo.AlbumRepository;
import org.lab9.repo.ArtistRepository;
import org.lab9.repo.GenreRepository;

import java.util.Random;

public class DataFaker {
    public static void generateArtists(int limit){
        ArtistRepository artistRepository = new ArtistRepository();
        Faker faker = new Faker();
        for (int iterator = 0; iterator < limit; iterator++){
            Artist a = new Artist(faker.artist().name(),faker.address().country());
            artistRepository.create(a);
        }
    }
    public static void generateAlbums(int limit){
        Faker faker = new Faker();
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        Random random = new Random();
        int artistRowCount =artistRepository.count("Artist").intValue();
        for (int iterator = 0; iterator < limit; iterator++){
            Artist artist = artistRepository.findByRowNum(random.nextInt(artistRowCount),"Artist");
            Album album = new Album(faker.gameOfThrones().house(),artist.getId(),1970+random.nextInt(50));
            albumRepository.create(album);
        }
    }
   public static void generateGenres(int limit){
       Faker faker = new Faker();
       AlbumRepository albumRepository = new AlbumRepository();
       GenreRepository genreRepository = new GenreRepository();
       for (int iterator = 0; iterator < limit; iterator++){
           Album album = albumRepository.findByRowNum(iterator,"Album");
           Genre genre = new Genre(album.getId(),album.getName(),album.getArtistId(),faker.music().instrument());
           genreRepository.create(genre);
       }
   }
}
