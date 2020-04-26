package org.lab9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.lab9.repo.AlbumRepository;
import org.lab9.repo.GenreRepository;

public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAlbumRepository(){
        AlbumRepository albumRepository = new AlbumRepository();
        assertEquals("Moore",albumRepository.findByName("Moore").get(0).getName());
        assertEquals(75, albumRepository.findByArtistId(75).get(0).getArtistId());
    }
    @Test
    public void testGenreRepository(){
        GenreRepository genreRepository = new GenreRepository();
        System.out.println(genreRepository.getUniqueGenresCount());
        assertEquals(java.util.Optional.of(16L),java.util.Optional.of(genreRepository.getUniqueGenresCount()));
        assertEquals(java.util.Optional.of(18L), java.util.Optional.ofNullable(genreRepository.getUniqueArtistCount()));
    }
}
