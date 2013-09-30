package org.gmelo.batooInvestigation.model.persistence;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManagerFactory;

/**
 * User: GMelo
 * Date: 27/09/2013
 *
 * Base class that loads the application context and autowires an EntityManagerFactory
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-conext.xml")
public abstract class SpringTestBase {

    @Autowired
    protected EntityManagerFactory entityManagerFactory;
}
