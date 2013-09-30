package org.gmelo.batooInvestigation.model;

import javax.persistence.*;

/**
 * User: GMelo
 * Date: 27/09/2013
 *
 * Simple JPA Annotated Entity
 */

@Entity
@Table(name = "ENTITY")
public class AnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FIELD")
    private String field;
    @Column(name = "IS")
    private Boolean is;

    public AnEntity() {
        //required for JPA
    }

    public AnEntity(String field, Boolean is) {
        this.field = field;
        this.is = is;
    }

    public Integer getId() {
        return id;
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
        if (!(o instanceof AnEntity)) return false;

        AnEntity anEntity = (AnEntity) o;

        if (field != null ? !field.equals(anEntity.field) : anEntity.field != null) return false;
        if (is != null ? !is.equals(anEntity.is) : anEntity.is != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (is != null ? is.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnEntity{" +
                "id=" + id +
                ", field='" + field + '\'' +
                ", is=" + is +
                '}';
    }
}
