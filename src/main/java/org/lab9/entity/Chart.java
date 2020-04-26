package org.lab9.entity;

import javax.persistence.*;

@Entity
@Table(name = "chart")
public class Chart {
    public int id;
    public String albumName;
    public int albumId;
    public int position;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "album_name")
    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Column(name = "album_id")
    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Column(name = "position")
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
}
