package org.lab9.entity;

import javax.persistence.*;


@Entity
@Table(name = "genres")
public class Genre {
    int id;
    int albumId;
    String albumName;
    int artistId;
    String genre;

    public Genre(){};
    public Genre(int albumId,String albumName,int artistId,String genre){
        this.albumId = albumId;
        this.albumName = albumName;
        this.genre = genre;
        this.artistId = artistId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "album_id")
    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Column(name = "album_name")
    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Column(name = "artist_id")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
