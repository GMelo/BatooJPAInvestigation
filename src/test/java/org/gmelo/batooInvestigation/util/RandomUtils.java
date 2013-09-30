package org.gmelo.batooInvestigation.util;

import org.gmelo.batooInvestigation.model.AnEntity;
import org.gmelo.batooInvestigation.model.AnotherEntity;
import org.gmelo.batooInvestigation.model.EntityWithDate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * User: GMelo
 * Date: 27/09/2013
 *
 * Class that exposes static methods to generate random Entities.
 *
 */
public class RandomUtils {

    private static final Random random = new Random();
    private static final char[] chars = "abcdefghijklmnopqrstwyxz".toCharArray();

    public static EntityWithDate createRandomEntityWithDate() {
        return new EntityWithDate(getRandomDate(), getRandomString(), random.nextBoolean());
    }

    public static AnEntity createRandomAnEntity() {
        return new AnEntity(getRandomString(), random.nextBoolean());
    }

    public static AnotherEntity createRandomAnotherEntity() {
        return new AnotherEntity(getRandomString(), new BigDecimal(random.nextInt(1000)) , getRandomMap());
    }

    //Util methods
    private static String getRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(chars[random.nextInt(chars.length)]);
        }
        return builder.toString();
    }

    private static Map<String, Boolean> getRandomMap() {
        int itr = random.nextInt(3) + 2;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (int i = 0; i <= itr; i++) {
            map.put(getRandomString(), random.nextBoolean());
        }
        return map;
    }

    private static Date getRandomDate() {
        return new Date(System.currentTimeMillis() - random.nextInt(100000));
    }
}
