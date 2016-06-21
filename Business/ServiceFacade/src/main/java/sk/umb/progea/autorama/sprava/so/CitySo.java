package sk.umb.progea.autorama.sprava.so;

import sk.umb.progea.autorama.advertisement.domain.County;

import java.io.Serializable;

/**
 * Created by msvon on 23-Apr-16.
 */
public class CitySo extends BaseSo implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String name;
    private County county;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @Override
    public boolean equals(Object other) {
        return id!=null && id.equals((Long)other);
    }
    @Override
    public int hashCode() {
        return id != null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }

}
