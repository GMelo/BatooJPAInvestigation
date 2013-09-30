package org.gmelo.batooInvestigation.model.persistence;

import junit.framework.Assert;
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
 * Tests to check the Persistence of Entities with a date inside them, to inspect an apparent
 * bug in the comparison of persisted Entities with dates inside a Set.
 */

public class EntityWithDateTest extends SpringTestBase{


    /**
     * Tests the persistence of the Entity, fetches it and asserts that
     * it is the same.
     */
    @Test
    public void testPersistEntityWithDate() {
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityWithDate entityWithDate = RandomUtils.createRandomEntityWithDate();
        em.getTransaction().begin();
        em.persist(entityWithDate);
        em.getTransaction().commit();
        em.clear();

        EntityWithDate returned = em.find(EntityWithDate.class, entityWithDate.getId());

        Assert.assertEquals(entityWithDate, returned);

    }

    /**
     * Test to replicate the apparent bug found when comparing entities with
     * date inside a set.
     *
     */
    @Test
    public void testPersistEntityWithDateInsideASet() {
        Set<EntityWithDate> setOne = new HashSet<EntityWithDate>();
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityWithDate entityWithDate = RandomUtils.createRandomEntityWithDate();
        setOne.add(entityWithDate);
        em.getTransaction().begin();
        em.persist(entityWithDate);
        em.getTransaction().commit();
        em.clear();

        EntityWithDate returned = em.find(EntityWithDate.class, entityWithDate.getId());
        Set<EntityWithDate> setTwo = new HashSet<EntityWithDate>();
        setTwo.add(returned);

        Assert.assertEquals(entityWithDate, returned);
        Assert.assertEquals(setOne, setTwo);


    }

    /**
     * Tests the equality of a non persisted Entity
     * inside a Set
     */
    @Test
    public void testEntityWithDateInsideASet() {
        Set<EntityWithDate> setOne = new HashSet<EntityWithDate>();

        EntityWithDate entityWithDate = RandomUtils.createRandomEntityWithDate();
        setOne.add(entityWithDate);

        EntityWithDate returned = entityWithDate.clone();
        Set<EntityWithDate> setTwo = new HashSet<EntityWithDate>();
        setTwo.add(returned);

        Assert.assertEquals(entityWithDate, returned);
        Assert.assertEquals(setOne, setTwo);


    }

    /**
     * Tests the equality of a persisted Entity inside a list to
     * sanity-check the problem with the set.
     */
    @Test
    public void testPersistEntityWithDateInsideAList() {
        List<EntityWithDate> setOne = new ArrayList<EntityWithDate>();
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityWithDate entityWithDate = RandomUtils.createRandomEntityWithDate();
        setOne.add(entityWithDate);
        em.getTransaction().begin();
        em.persist(entityWithDate);
        em.getTransaction().commit();
        em.clear();

        EntityWithDate returned = em.find(EntityWithDate.class, entityWithDate.getId());
        List<EntityWithDate> setTwo = new ArrayList<EntityWithDate>();
        setTwo.add(returned);

        Assert.assertEquals(entityWithDate, returned);
        Assert.assertEquals(setOne, setTwo);


    }
}
