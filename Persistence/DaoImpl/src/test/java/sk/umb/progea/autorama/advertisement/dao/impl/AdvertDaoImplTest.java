package sk.umb.progea.autorama.advertisement.dao.impl;

import org.junit.Before;
import org.junit.Test;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyAdvertFactory;
import sk.umb.progea.autorama.advertisement.dao.impl.dummy.DummyCityFactory;
import sk.umb.progea.autorama.advertisement.domain.Advertisement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by msvon on 20-Mar-16.
 */
public class AdvertDaoImplTest {

    private EntityTransaction transaction;
    private AdvertisementDaoImpl adDao;
    private CityDaoImpl cityDao;

    @Before
    public void initializeDependencies(){
        EntityManager em = Persistence.createEntityManagerFactory("AutoramaPUtest").createEntityManager();

        adDao = new AdvertisementDaoImpl();
        adDao.setEntityManager(em);

        cityDao = new CityDaoImpl();
        cityDao.setEntityManager(em);

        this.transaction = em.getTransaction();
    }

    @Test
    public void testCRUD() {
        transaction.begin();

        // na zaciatku tam nebude nic
        List<Advertisement> l = adDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        Advertisement ad = DummyAdvertFactory.generateAdvert();

        ad.setCity(DummyCityFactory.generateCity(false));

        Long tid = adDao.create(ad);
        assertNotNull(tid);

        // teraz uz musi byt v db 1 zaznam
        l = adDao.getAll();
        assertNotNull(l);
        assertEquals(1, l.size());

        // nacitaj vytvoreny zaznam
        Advertisement loaded = adDao.get(tid);
        assertNotNull(loaded);
        assertNotNull(loaded.getBrand());
        assertNotNull(loaded.getDateStart());
        assertNotNull(loaded.getCity());

        adDao.delete(loaded);

        // teraz uz nemoze byt v db ziadny zaznam
        l = adDao.getAll();
        assertNotNull(l);
        assertEquals(0, l.size());

        //  Musim implicitne zmazat aj mesto ktore bolo vytvorene v Adverte
        // pretoze sa nezmaze spolu so zmazanim advertu
        // (co je spravne, nechcem aby sa mi mazalo mesto po odstraneni inzeratu)
        cityDao.delete(cityDao.getAll().get(0));

        transaction.commit();
    }

}
