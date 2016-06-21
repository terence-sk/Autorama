package sk.umb.progea.autorama.advertisement.dao;

import sk.umb.progea.autorama.advertisement.domain.County;
import sk.umb.progea.autorama.base.dao.BaseDao;
import sk.umb.progea.autorama.advertisement.domain.City;

import java.util.List;

/**
 * Created by msvon on 25-Mar-16.
 */
public interface CityDao extends BaseDao<City, Long> {
    List<City> getByCounty(County c);
    List<City> getByName(String name);
}
