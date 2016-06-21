package sk.umb.progea.autorama.sprava.service;

import sk.umb.progea.autorama.advertisement.domain.City;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;

import java.util.List;

/**
 * Created by msvon on 19-Apr-16.
 */
public interface AdService extends BaseService{
    List<AdvertisementSo> getByCity(City c);
    List<AdvertisementSo> getByTitle(String title);
    List<AdvertisementSo> getByColor(String c);
    List<AdvertisementSo> getByBrand(String c);
    List<AdvertisementSo> getByKmDrivenMin(int kmMin);
    Long create(AdvertisementSo ad);
    void remove(AdvertisementSo ad);
    AdvertisementSo getById(Long id);
}
