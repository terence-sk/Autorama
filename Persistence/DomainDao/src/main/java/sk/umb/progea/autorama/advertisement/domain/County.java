package sk.umb.progea.autorama.advertisement.domain;

import sk.umb.progea.autorama.base.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by msvon on 25-Mar-16.
 */
// KRAJ
@Entity
@Table(name = "ar_county")
@NamedQueries({
        @NamedQuery(name = "County.findAll", query = "SELECT c FROM County c"),
        @NamedQuery(name = "County.findByName", query = "SELECT c FROM County c WHERE c.name = :name")
})
public class County extends BaseDomain implements Serializable{

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "county")
    private List<City> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
