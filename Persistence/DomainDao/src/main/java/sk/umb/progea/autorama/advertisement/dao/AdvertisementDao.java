package sk.umb.progea.autorama.advertisement.dao;

import sk.umb.progea.autorama.base.dao.BaseDao;
import sk.umb.progea.autorama.advertisement.domain.Advertisement;
import sk.umb.progea.autorama.advertisement.domain.City;

import java.util.List;

/**
 * Created by msvon on 14-Mar-16.
 */
public interface AdvertisementDao extends BaseDao<Advertisement, Long> {
    List<Advertisement> getAdsByCity(City c);
    List<Advertisement> getAdsByTitle(String title);
    List<Advertisement> getAdsByColor(String color);
    List<Advertisement> getAdsByBrand(String brand);
    List<Advertisement> getAdsByKmDrivenMin(int km);
}
