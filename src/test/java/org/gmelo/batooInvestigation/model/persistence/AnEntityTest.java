package org.gmelo.batooInvestigation.model.persistence;

import junit.framework.Assert;
import org.gmelo.batooInvestigation.model.AnEntity;
import org.gmelo.batooInvestigation.model.EntityWithDate;
import org.gmelo.batooInvestigation.util.RandomUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: GMelo
 * Date: 27/09/2013
 *
 * Tests to sanity-check the apparent bug when comparing entities inside a set.
 * this ensures that without the date there is no problem.
 *
 */

public class AnEntityTest extends SpringTestBase {

    /**
     * Tests the persistence of the Entity, fetches it and asserts that
     * it is the same.
     */
    @Test
    public void testPersistEntityWithoutDate() {
        EntityManager em = entityManagerFactory.createEntityManager();

        AnEntity entity = RandomUtils.createRandomAnEntity();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.clear();

        AnEntity returned = em.find(AnEntity.class, entity.getId());

        Assert.assertEquals(entity, returned);

    }

    /**
     * Tests the persistence of the Entity, fetches it and asserts that
     * it is the same when inside a set, this is to sanity-check the apparent
     * bug when comparing sets with dates inside.
     */
    @Test
    public void testPersistEntityWithoutDateInsideASet() {
        Set<AnEntity> setOne = new HashSet<AnEntity>();
        EntityManager em = entityManagerFactory.createEntityManager();

        AnEntity entity = RandomUtils.createRandomAnEntity();
        setOne.add(entity);
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.clear();

        AnEntity returned = em.find(AnEntity.class, entity.getId());
        Set<AnEntity> setTwo = new HashSet<AnEntity>();
        setTwo.add(returned);

        Assert.assertEquals(entity, returned);
        Assert.assertEquals(setOne, setTwo);


    }

    /**
     * Tests the persistence of the Entity, fetches it and asserts that
     * it is the same when inside a List, this is to sanity-check the apparent
     * bug when comparing sets with dates inside.
     */
    @Test
    public void testPersistEntityWithoutDateInsideAList() {
        List<AnEntity> setOne = new ArrayList<AnEntity>();
        EntityManager em = entityManagerFactory.createEntityManager();

        AnEntity entity = RandomUtils.createRandomAnEntity();
        setOne.add(entity);
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.clear();

        AnEntity returned = em.find(AnEntity.class, entity.getId());
        List<AnEntity> setTwo = new ArrayList<AnEntity>();
        setTwo.add(returned);

        Assert.assertEquals(entity, returned);
        Assert.assertEquals(setOne, setTwo);


    }
}
