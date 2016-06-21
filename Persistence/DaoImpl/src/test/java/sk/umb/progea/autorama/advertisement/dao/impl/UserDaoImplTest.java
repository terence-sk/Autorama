package sk.umb.progea.autorama.advertisement.dao.impl;

import org.junit.Before;
import org.junit.Test;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyAdvertFactory;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyUserFactory;
import sk.umb.progea.autorama.advertisement.domain.Advertisement;
import sk.umb.progea.autorama.advertisement.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by msvon on 18-Mar-16.
 */
public class UserDaoImplTest {

    private EntityTransaction transaction;
    private UserDaoImpl userDao;
    private AdvertisementDaoImpl adDao;

    @Before
    public void initializeDependencies(){
        EntityManager em = Persistence.createEntityManagerFactory("AutoramaPUtest").createEntityManager();
        userDao = new UserDaoImpl();
        userDao.setEntityManager(em);

        adDao = new AdvertisementDaoImpl();
        adDao.setEntityManager(em);

        this.transaction = em.getTransaction();
    }

    @Test
    public void testCRUD() {
        transaction.begin();

        // na zaciatku tam nebude nic
        List<User> l = userDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        User o = DummyUserFactory.generateUser();
        Long tid = userDao.create(o);
        assertNotNull(tid);

        // teraz uz musi byt v db 1 zaznam
        l = userDao.getAll();
        assertNotNull(l);
        assertEquals(1, l.size());

        // nacitaj vytvoreny zaznam
        User loaded = userDao.get(tid);
        assertNotNull(loaded);
        assertNotNull(loaded.getId());
        assertNotNull(loaded.getFirstname());
        assertNotNull(loaded.getSurname());
        assertEquals(o.getId(), loaded.getId());
        assertEquals(o.getFirstname(), loaded.getFirstname());
        assertEquals(o.getSurname(), loaded.getSurname());
        assertEquals(o.getEmail(), loaded.getEmail());

        // zmaz osobu
        userDao.delete(loaded);

        // teraz uz nemoze byt v db ziadny zaznam
        l = userDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        transaction.commit();
    }


    /*
    Svaty gral OneToMany vztahov, usetri to hodiny nervov
    http://stackoverflow.com/a/3044934/1869111

    V skratke - pri ukladani do DB sa JPA pozera LEN NA OWNERA (User)
    Takze darmo ja mam vytvoreny Advert v ktorom je nasetovany user
    lebo ked to ulozim do DB tak sa pozre na USERA tam ziadny advert nevidi
    a teda ulozi Advert ale s userom sa to nesparuje.
    (Co je divne kedze  vypis SQL ukazuje ze to uklada do db aj s IDckom uzivatela...)
    */
    @Test
    public void testUserAdverts(){
        transaction.begin();

        User loaded;
        User loaded2;
        User u = DummyUserFactory.generateUser();
        User u2 = DummyUserFactory.generateUser();

        Advertisement ad = DummyAdvertFactory.generateAdvert();
        Advertisement ad2 = DummyAdvertFactory.generateAdvert();

        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        ArrayList<Advertisement> ads2 = new ArrayList<Advertisement>();
        ads.add(ad); // lol
        ads2.add(ad2); // lol

        u.setAdverts(ads);
        u2.setAdverts(ads2);
        Long id = userDao.create(u);
        Long id2 = userDao.create(u2);

        loaded = userDao.get(id);
        loaded2 = userDao.get(id2);

        assertNotNull(loaded);
        assertNotNull(loaded2);
        assertNotNull(loaded.getAdverts());
        assertNotNull(loaded2.getAdverts());

        userDao.delete(loaded);

        // Narozdiel od mazania inzeratu kde sa MESTO nevymaze,
        // tu chcem aby sa samozmazali reklamy daneho usera
        // ale nikoho ineho, cize User2 tam musi mat svoju reklamu
        assertEquals(1, adDao.getAll().size());

        userDao.delete(loaded2);
        assertEquals(0, adDao.getAll().size());

        transaction.commit();

    }

}
