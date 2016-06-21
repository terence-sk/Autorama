package sk.umb.progea.autorama.advertisement.dao.impl;

import sk.umb.progea.autorama.base.dao.impl.BaseDaoImpl;
import sk.umb.progea.autorama.advertisement.domain.Advertisement;
import sk.umb.progea.autorama.advertisement.dao.AdvertisementDao;
import sk.umb.progea.autorama.advertisement.domain.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by msvon on 14-Mar-16.
 */
@Stateless
public class AdvertisementDaoImpl extends BaseDaoImpl<Advertisement, Long> implements AdvertisementDao {

    public AdvertisementDaoImpl() { super(Advertisement.class); }

    public void setEntityManager(EntityManager entityManager) {
        super.entityManager = entityManager;
    }

    @Override
    public List<Advertisement> getAdsByCity(City c) {
        Query q = entityManager.createNamedQuery("Advertisement.findByCity", Advertisement.class);
        q.setParameter("city", c);
        return q.getResultList();
    }

    @Override
    public List<Advertisement> getAdsByTitle(String title) {
        Query q = entityManager.createNamedQuery("Advertisement.findByTitleLike", Advertisement.class);
        q.setParameter("title", "%"+title+"%");
        return q.getResultList();
    }

    @Override
    public List<Advertisement> getAdsByColor(String color) {
        Query q = entityManager.createNamedQuery("Advertisement.findByColor", Advertisement.class);
        q.setParameter("color", color);
        return q.getResultList();
    }

    @Override
    public List<Advertisement> getAdsByBrand(String brand) {
        Query q = entityManager.createNamedQuery("Advertisement.findByBrand", Advertisement.class);
        q.setParameter("brand", brand);
        return q.getResultList();
    }

    @Override
    public List<Advertisement> getAdsByKmDrivenMin(int km) {
        Query q = entityManager.createNamedQuery("Advertisement.findByKmDrivenMin", Advertisement.class);
        q.setParameter("kmDriven", km);
        return q.getResultList();
    }
}
