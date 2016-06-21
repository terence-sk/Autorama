package sk.umb.progea.autorama.advertisement.dao.impl;

import org.junit.Before;
import org.junit.Test;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyCityFactory;
import sk.umb.progea.autorama.advertisement.domain.City;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by msvon on 25-Mar-16.
 */
public class CityDaoImplTest {

    private EntityTransaction transaction;
    private CityDaoImpl cityDao;

    @Before
    public void initializeDependencies(){
        EntityManager em = Persistence.createEntityManagerFactory("AutoramaPUtest").createEntityManager();

        cityDao = new CityDaoImpl();
        cityDao.setEntityManager(em);

        this.transaction = em.getTransaction();
    }

    @Test
    public void testCRUD() {
        transaction.begin();

        // na zaciatku tam nebude nic
        List<City> l = cityDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        City c = DummyCityFactory.generateCity(true);
        Long tid = cityDao.create(c);
        assertNotNull(tid);

        // teraz uz musi byt v db 1 zaznam
        l = cityDao.getAll();
        assertNotNull(l);
        assertEquals(1, l.size());

        // nacitaj vytvoreny zaznam
        City loaded = cityDao.get(tid);
        assertNotNull(loaded);
        assertNotNull(loaded.getName());
        assertNotNull(loaded.getCounty());

        cityDao.delete(loaded);

        // teraz uz nemoze byt v db ziadny zaznam
        l = cityDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        transaction.commit();
    }


}
