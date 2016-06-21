package sk.umb.progea.autorama.advertisement.dao.impl;

import sk.umb.progea.autorama.base.dao.impl.BaseDaoImpl;
import sk.umb.progea.autorama.advertisement.dao.CountyDao;
import sk.umb.progea.autorama.advertisement.domain.County;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by msvon on 25-Mar-16.
 */
public class CountyDaoImpl extends BaseDaoImpl<County, Long> implements CountyDao{

    public CountyDaoImpl() {super(County.class);}
    public void setEntityManager(EntityManager entityManager) {
        super.entityManager = entityManager;
    }

    @Override
    public List<County> getByName(String name) {
        Query q = entityManager.createNamedQuery("County.findByName", County.class);
        q.setParameter("name", name);
        return q.getResultList();
    }
}
