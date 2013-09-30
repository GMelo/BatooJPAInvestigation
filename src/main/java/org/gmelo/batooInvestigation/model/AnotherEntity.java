package org.gmelo.batooInvestigation.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * User: GMelo
 * Date: 21/09/2013
 *
 * A JPA annotated Entity with a Map
 */

@Entity
public class AnotherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FIRST_FIELD", length = 20)
    private String firstField;
    @Column(name = "BIG_DECIMAL")
    private BigDecimal bigDecimal;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="MAPPY")
    @MapKeyColumn(name="MAPPY_KEY")
    @Column(name="MAPPY_VALUE")
    private Map<String,Boolean> map = new HashMap<String, Boolean>();

    public AnotherEntity(){}

    public AnotherEntity(String firstField, BigDecimal bigDecimal, Map<String, Boolean> map) {
        this.firstField = firstField;
        this.bigDecimal = bigDecimal;
        this.map = map;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstField() {
        return firstField;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public Map<String, Boolean> getMap() {
        return map;
    }

    //boilerplate
    // equals and hashCode do not include ID
    //to allow comparison between persisted and non persisted entities
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnotherEntity)) return false;

        AnotherEntity that = (AnotherEntity) o;

        if (bigDecimal != null ? !bigDecimal.equals(that.bigDecimal) : that.bigDecimal != null) return false;
        if (firstField != null ? !firstField.equals(that.firstField) : that.firstField != null) return false;
        if (map != null ? !map.equals(that.map) : that.map != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstField != null ? firstField.hashCode() : 0;
        result = 31 * result + (bigDecimal != null ? bigDecimal.hashCode() : 0);
        result = 31 * result + (map != null ? map.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnotherEntity{" +
                "id=" + id +
                ", firstField='" + firstField + '\'' +
                ", bigDecimal=" + bigDecimal +
                ", map=" + map +
                '}';
    }
}
