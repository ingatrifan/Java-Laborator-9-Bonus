package org.lab9.repo;


import org.lab9.entity.Album;
import org.lab9.entity.Genre;
import org.lab9.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GenreRepository implements AbstractRepository<Genre> {
    public Long getUniqueGenresCount(){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT COUNT(DISTINCT a.genre) FROM Genre a";
        Query query=entityManager.createQuery(queryString).setMaxResults(1);
        Number results= (Number) query.getSingleResult();
        return (Long) results;
    }
    public Long getUniqueArtistCount(){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT COUNT(DISTINCT a.artistId) FROM Genre a";
        Query query=entityManager.createQuery(queryString).setMaxResults(1);
        Number results= (Number) query.getSingleResult();
        return (Long) results;
    }
    public List<Genre> getAlbums(){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT a FROM Genre a ";
        Query query=entityManager.createQuery(queryString);
        List<Genre> genres= (List<Genre>) query.getResultList();
        return genres;
    }
    public List<Genre> getAlbumsByGenre(String genre){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT a FROM Genre a where a.genre = "+genre;
        Query query=entityManager.createQuery(queryString);
        List<Genre> genres= (List<Genre>) query.getResultList();
        return genres;
    }
    public List<Genre> getAlbumsById(int id){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT a FROM Genre a where a.artistId = "+id;
        Query query=entityManager.createQuery(queryString);
        List<Genre> genres= (List<Genre>) query.getResultList();
        return genres;
    }
    public List<String> getDifferentGenre(){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT DISTINCT a.genre FROM Genre a";
        Query query=entityManager.createQuery(queryString);
        List<String> genres= (List<String>) query.getResultList();
        return genres;
    }
    public List<Integer> getDifferentIds(){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT DISTINCT a.artistId FROM Genre a";
        Query query=entityManager.createQuery(queryString);
        List<Integer> genres= (List<Integer>) query.getResultList();
        return genres;
    }
}
