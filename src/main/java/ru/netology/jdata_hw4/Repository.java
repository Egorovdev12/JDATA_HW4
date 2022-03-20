package ru.netology.jdata_hw4;

import ru.netology.jdata_hw4.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public String getPersonsByCity(String gCity) {
        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city", Person.class);
        query.setParameter("city", gCity);
        var resultList = query.getResultList();
        return resultList.toString();
    }
}