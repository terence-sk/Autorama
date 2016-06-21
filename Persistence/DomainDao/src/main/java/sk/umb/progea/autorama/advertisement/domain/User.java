package sk.umb.progea.autorama.advertisement.domain;

import sk.umb.progea.autorama.base.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by msvon on 14-Mar-16.
 */
@Entity
@Table(name = "ar_user")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
        @NamedQuery(name = "User.findByFullName", query = "SELECT u FROM User u WHERE u.firstname = :name AND u.surname = :surname"),
        @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname")
})
public class User extends BaseDomain implements Serializable{

    private String firstname;
    private String surname;
    private String email;
    private String phone;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Advertisement> adverts;

    public List<Advertisement> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advertisement> adverts) {
        this.adverts = adverts;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + firstname + ", surname=" + surname
                + ", adverts=" + adverts + ", getId()=" + getId() + "]";
    }

}
