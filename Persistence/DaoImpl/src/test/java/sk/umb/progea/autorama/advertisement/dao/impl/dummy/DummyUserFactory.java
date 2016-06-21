package sk.umb.progea.autorama.advertisement.dao.impl.dummy;

import sk.umb.progea.autorama.advertisement.domain.User;

/**
 * Created by msvon on 18-Mar-16.
 */
public class DummyUserFactory {

    public static User generateUser() {
        User o = new User();

        o.setEmail("msvonava@gmail.com");
        o.setFirstname("Martin");
        o.setSurname("Svonava");
        o.setPhone("090x");
        o.setPassword("$30#34nir");

        return o;
    }

}
