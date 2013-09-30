package org.gmelo.batooInvestigation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: GMelo
 * Date: 27/09/2013
 * <p/>
 * A JPA annotated Entity with Date field
 */

@Entity
@Table(name = "ENTITY_W_DATE")
public class EntityWithDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TODAY")
    private Date today;
    @Column(name = "FIELD")
    private String field;
    @Column(name = "IS")
    private Boolean is;

    public EntityWithDate() {
    }

    public EntityWithDate(Date today, String field, Boolean is) {
        this.today = today;
        this.field = field;
        this.is = is;
    }

    public Integer getId() {
        return id;
    }

    public Date getToday() {
        return today;
    }

    public String getField() {
        return field;
    }

    public Boolean getIs() {
        return is;
    }

    //boilerplate
    // equals and hashCode do not include ID
    //to allow comparison between persisted and non persisted entities

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityWithDate)) return false;

        EntityWithDate that = (EntityWithDate) o;

        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (is != null ? !is.equals(that.is) : that.is != null) return false;
        if (today != null ? !today.equals(that.today) : that.today != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = today != null ? today.hashCode() : 0;
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (is != null ? is.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EntityWithDate{" +
                "id=" + id +
                ", today=" + today +
                ", field='" + field + '\'' +
                ", is=" + is +
                '}';
    }

    public EntityWithDate clone() {
        return new EntityWithDate(this.getToday(), this.getField(), this.getIs());
    }

}
