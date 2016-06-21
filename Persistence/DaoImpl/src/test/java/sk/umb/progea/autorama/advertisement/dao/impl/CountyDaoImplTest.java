package sk.umb.progea.autorama.advertisement.dao.impl;

import org.junit.Before;
import org.junit.Test;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyCityFactory;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyCountyFactory;
import sk.umb.progea.autorama.advertisement.domain.City;
import sk.umb.progea.autorama.advertisement.domain.County;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by msvon on 25-Mar-16.
 */
public class CountyDaoImplTest {


    private EntityTransaction transaction;
    private CountyDaoImpl countyDao;
    private CityDaoImpl cityDao;

    @Before
    public void initializeDependencies(){
        EntityManager em = Persistence.createEntityManagerFactory("AutoramaPUtest").createEntityManager();

        countyDao = new CountyDaoImpl();
        countyDao.setEntityManager(em);

        cityDao = new CityDaoImpl();
        cityDao.setEntityManager(em);

        this.transaction = em.getTransaction();
    }

    @Test
    public void testCRUD() {
        transaction.begin();

        List<City> cities = new ArrayList<City>();
        cities.add(DummyCityFactory.generateCity(false));

        // na zaciatku tam nebude nic
        List<County> l = countyDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        County c = DummyCountyFactory.generateCounty();
        c.setCities(cities);
        Long tid = countyDao.create(c);
        assertNotNull(tid);

        // teraz uz musi byt v db 1 zaznam
        l = countyDao.getAll();
        assertNotNull(l);
        assertEquals(1, l.size());

        // nacitaj vytvoreny zaznam
        County loaded = countyDao.get(tid);
        assertNotNull(loaded);
        assertNotNull(loaded.getName());
        assertNotNull(loaded.getCities());

        assertNotNull(cityDao.getAll());

        countyDao.delete(loaded);

        // teraz uz nemoze byt v db ziadny zaznam
        l = countyDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        transaction.commit();
    }


}
