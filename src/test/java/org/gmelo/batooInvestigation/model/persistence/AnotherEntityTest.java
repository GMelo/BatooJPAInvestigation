package org.gmelo.batooInvestigation.model.persistence;


import junit.framework.Assert;
import org.gmelo.batooInvestigation.model.AnotherEntity;
import org.gmelo.batooInvestigation.util.RandomUtils;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * User: GMelo
 * Date: 27/09/2013
 *
 * Test to replicate the problem when persisting a map with the annotation (fetch=FetchType.EAGER)
 */

public class AnotherEntityTest extends SpringTestBase {

    /**
     * Test for the persistence of an object with a map with the (fetch=FetchType.EAGER)
     */
    @Test
    public void testPersistAnotherEntity() {

        EntityManager em = entityManagerFactory.createEntityManager();

        AnotherEntity entity = RandomUtils.createRandomAnotherEntity();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.clear();

        AnotherEntity returned = em.find(AnotherEntity.class, entity.getId());

        Assert.assertEquals(entity.getMap().entrySet(), returned.getMap().entrySet());
        Assert.assertEquals(entity, returned);
    }


}
