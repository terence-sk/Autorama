package sk.umb.progea.autorama.sprava.service.impl;

import sk.umb.progea.autorama.advertisement.dao.AdvertisementDao;
import sk.umb.progea.autorama.advertisement.dao.CityDao;
import sk.umb.progea.autorama.advertisement.domain.Advertisement;
import sk.umb.progea.autorama.advertisement.domain.City;
import sk.umb.progea.autorama.sprava.service.AdService;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;
import sk.umb.progea.autorama.sprava.so.CitySo;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msvon on 19-Apr-16.
 */
@Stateless
@Remote(AdService.class)
public class AdServiceImpl implements AdService {

    @EJB
    private AdvertisementDao adDao;
    @EJB
    private CityDao cityDao;

    @Override
    public List<AdvertisementSo> getAll() {
        List<Advertisement> adList = adDao.getAll();
        return getFullResultSet(adList);
    }

    @Override
    public List<AdvertisementSo> getByCity(City c) {
        List<Advertisement> adList = adDao.getAdsByCity(c);
        return getFullResultSet(adList);
    }

    @Override
    public List<AdvertisementSo> getByTitle(String title) {
        List<Advertisement> adList = adDao.getAdsByTitle(title);
        return getFullResultSet(adList);
    }

    @Override
    public List<AdvertisementSo> getByColor(String color) {
        List<Advertisement> adList = adDao.getAdsByColor(color);
        return getFullResultSet(adList);
    }

    @Override
    public List<AdvertisementSo> getByBrand(String brand) {
        List<Advertisement> adList = adDao.getAdsByBrand(brand);
        return getFullResultSet(adList);
    }

    @Override
    public List<AdvertisementSo> getByKmDrivenMin(int kmMin) {
        List<Advertisement> adList = adDao.getAdsByKmDrivenMin(kmMin);
        return getFullResultSet(adList);
    }

    @Override
    public Long create(AdvertisementSo ad) {
        Advertisement a = convertToAd(ad);
        return adDao.create(a);
    }

    @Override
    public void remove(AdvertisementSo ad) {
        adDao.delete(adDao.get(ad.getId()));
    }

    @Override
    public AdvertisementSo getById(Long id) {
        Advertisement a = adDao.get(id);
        return convertToAdvertisementSO(a);
    }

    private List<AdvertisementSo> getFullResultSet(List<Advertisement> adList){

        List<AdvertisementSo> adSoList = new ArrayList<AdvertisementSo>();
        AdvertisementSo adSo;

        for(Advertisement a : adList){

            adSo = new AdvertisementSo();
            adSo.setId(a.getId());
            adSo.setBrand(a.getBrand());
            adSo.setColor(a.getColor());
            adSo.setContents(a.getContent());
            adSo.setTitle(a.getTitle());
            adSo.setCity(convertToCitySo(a.getCity()));
            adSo.setKmDrivenMonthly(a.getKmDrivenMonthly());
            adSoList.add(adSo);
        }
        return adSoList;
    }

    private Advertisement convertToAd(AdvertisementSo adSo){
        Advertisement ad = new Advertisement();
        ad.setBrand(adSo.getBrand());
        ad.setColor(adSo.getColor());
        ad.setContent(adSo.getContents());
        ad.setTitle(adSo.getTitle());
        ad.setCity(convertToCity(adSo.getCity()));
        ad.setKmDrivenMonthly(adSo.getKmDrivenMonthly());
        return ad;
    }

    private City convertToCity(CitySo city) {
        return cityDao.get(1l);
    }

    private CitySo convertToCitySo(City c){
        CitySo citySo = new CitySo();
        citySo.setCounty(c.getCounty());
        citySo.setName(c.getName());
        citySo.setId(c.getId());
        return citySo;
    }

    private AdvertisementSo convertToAdvertisementSO(Advertisement a){
        AdvertisementSo adSo = new AdvertisementSo();

        adSo.setId(a.getId());
        adSo.setBrand(a.getBrand());
        adSo.setColor(a.getColor());
        adSo.setContents(a.getContent());
        adSo.setTitle(a.getTitle());
        adSo.setCity(convertToCitySo(a.getCity()));
        adSo.setKmDrivenMonthly(a.getKmDrivenMonthly());

        return adSo;
    }


}
