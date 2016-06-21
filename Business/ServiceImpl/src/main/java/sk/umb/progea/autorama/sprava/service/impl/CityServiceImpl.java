package sk.umb.progea.autorama.sprava.service.impl;

import sk.umb.progea.autorama.advertisement.dao.CityDao;
import sk.umb.progea.autorama.advertisement.domain.City;
import sk.umb.progea.autorama.advertisement.domain.County;
import sk.umb.progea.autorama.sprava.service.CityService;
import sk.umb.progea.autorama.sprava.so.CitySo;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
@Stateless
@Remote(CityService.class)
public class CityServiceImpl implements CityService {

    @EJB
    private CityDao dao;

    @Override
    public CitySo getByName(String name) {
        List<City> cityList = dao.getByName(name);

        List<sk.umb.progea.autorama.sprava.so.CitySo> result = getFullResultSet(cityList);

        if(!result.isEmpty())
            return result.get(0);
        return null;
    }

    @Override
    public List<CitySo> getByCounty(County county) {
        List<City> cityList = dao.getByCounty(county);
        return getFullResultSet(cityList);
    }

    @Override
    public CitySo getById(Long id) {
        City city = dao.get(id);
        return convertCityToSo(city);
    }

    @Override
    public List<CitySo> getAll() {
        List<City> cityList = dao.getAll();
        return getFullResultSet(cityList);
    }

    private CitySo convertCityToSo(City c){
        CitySo cso = new CitySo();

        cso.setCounty(c.getCounty());
        cso.setId(c.getId());
        cso.setName(c.getName());

        return cso;
    }

    private List<CitySo> getFullResultSet(List<City> cities){
        List<CitySo> citySos = new ArrayList<CitySo>();
        CitySo cSo;

        for(City c: cities){
            cSo = new CitySo();

            cSo.setId(c.getId());
            cSo.setCounty(c.getCounty());
            cSo.setName(c.getName());

            citySos.add(cSo);
        }

        return citySos;
    }

}
