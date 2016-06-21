package sk.umb.progea.autorama.advertisement.domain;

import sk.umb.progea.autorama.base.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by msvon on 25-Mar-16.
 */
@Entity
@Table(name = "ar_city")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
        @NamedQuery(name = "City.findByCounty", query = "SELECT c FROM City c WHERE c.county = :county")
        })
public class City extends BaseDomain implements Serializable{

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private County county; // v ktorom kraji sa mesto nachadza

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
