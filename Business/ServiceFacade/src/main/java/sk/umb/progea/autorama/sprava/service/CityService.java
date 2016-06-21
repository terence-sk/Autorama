package sk.umb.progea.autorama.sprava.service;

import sk.umb.progea.autorama.advertisement.domain.County;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;
import sk.umb.progea.autorama.sprava.so.CitySo;

import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
public interface CityService extends BaseService{
    CitySo getByName(String name);
    List<CitySo> getByCounty(County county);
    CitySo getById(Long id);
}
