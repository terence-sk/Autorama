package sk.umb.progea.autorama.advertisement.dao.impl;

import sk.umb.progea.autorama.advertisement.domain.County;
import sk.umb.progea.autorama.base.dao.impl.BaseDaoImpl;
import sk.umb.progea.autorama.advertisement.dao.CityDao;
import sk.umb.progea.autorama.advertisement.domain.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by msvon on 25-Mar-16.
 */
@Stateless
public class CityDaoImpl extends BaseDaoImpl<City, Long> implements CityDao {

    public CityDaoImpl(){super(City.class); }
    public void setEntityManager(EntityManager entityManager) {
        super.entityManager = entityManager;
    }

    @Override
    public List<City> getByCounty(County c) {
        Query q = entityManager.createNamedQuery("City.findByCounty", City.class);
        q.setParameter("county", c);
        return q.getResultList();
    }

    @Override
    public List<City> getByName(String name) {
        Query q = entityManager.createNamedQuery("City.findByName", City.class);
        q.setParameter("name", name);
        return q.getResultList();
    }
}
