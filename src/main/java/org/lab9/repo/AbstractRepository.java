package org.lab9.repo;

import org.lab9.entity.Album;
import org.lab9.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface AbstractRepository<T> {
    default public void create(T t){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    default public T findById(int id,Class<T> genericClass){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        T t = entityManager.find(genericClass,id);
        entityManager.close();
        return  t;
    }
    default public Long count(String tableName){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT COUNT(a.id) FROM "+tableName+" a";
        Query query=entityManager.createQuery(queryString);
        Number results= (Number) query.getSingleResult();
        return (Long) results;
    }
    default public T findByRowNum(int rowNum, String tableName){
        PersistenceUtil persistenceUtil = PersistenceUtil.getPersistenceUtil();
        EntityManager entityManager = persistenceUtil.createEMFactory().createEntityManager();
        String queryString = "SELECT a FROM "+ tableName + " a";
        Query query=entityManager.createQuery(queryString).setFirstResult(rowNum).setMaxResults(1);
        T results= (T) query.getSingleResult();
        return results;

    }
}
