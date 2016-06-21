package sk.umb.progea.autorama.sprava.so;

import java.io.Serializable;

/**
 * Created by msvon on 23-Apr-16.
 */
public class UserSo extends BaseSo implements Serializable {

    // TODO: Spytat sa ci sem dat password - podla mna nie

    private String firstname;
    private String surname;
    private String email;
    private String phone;

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

}
