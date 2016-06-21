package sk.umb.progea.autorama.advertisement.domain;

import sk.umb.progea.autorama.base.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * Created by msvon on 14-Mar-16.
 */
@Entity
@Table(name = "ar_advertisement")
@NamedQueries({
        @NamedQuery(name = "Advertisement.findAll", query = "SELECT a FROM Advertisement a"),
        @NamedQuery(name = "Advertisement.findByTitle", query = "SELECT a FROM Advertisement a WHERE a.title = :title"),
        @NamedQuery(name = "Advertisement.findByCity", query = "SELECT a FROM Advertisement a WHERE a.city = :city"),
        @NamedQuery(name = "Advertisement.findByColor", query = "SELECT a FROM Advertisement a WHERE a.color = :color"),
        @NamedQuery(name = "Advertisement.findByBrand", query = "SELECT a FROM Advertisement a WHERE a.brand = :brand"),
        @NamedQuery(name = "Advertisement.findByKmDriven", query = "SELECT a FROM Advertisement a WHERE a.kmDrivenMonthly = :kmDriven"),
        @NamedQuery(name = "Advertisement.findByKmDrivenMin", query = "SELECT a FROM Advertisement a WHERE a.kmDrivenMonthly >= :kmDriven"),
        @NamedQuery(name = "Advertisement.findByTitleLike", query = "SELECT a FROM Advertisement a WHERE lower(a.title) like :title")
        }) // TODO: Query s viac parametrami (napr. farba a znacka zaroven)
public class Advertisement extends BaseDomain implements Serializable{
    private String title;
    private String content;
    private String color;
    private String brand;
    private int kmDrivenMonthly; //kilometrov najazdenych mesacne

    // TODO Staci takto? malo by, nechcem predsa mazat mesto ak zmazem AD
    @ManyToOne(cascade = CascadeType.PERSIST)
    private City city;

    @Temporal(TemporalType.DATE)
    private Date dateStart; // kedy bol vlozeny
    @Temporal(TemporalType.DATE)
    private Date dateEnd; // kedy inzerat skonci

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKmDrivenMonthly() {
        return kmDrivenMonthly;
    }

    public void setKmDrivenMonthly(int km) {
        this.kmDrivenMonthly = km;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
