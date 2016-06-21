package sk.umb.progea.beansjsf;

import sk.umb.progea.autorama.sprava.service.AdService;
import sk.umb.progea.autorama.sprava.service.CityService;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;
import sk.umb.progea.autorama.sprava.so.CitySo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by msvon on 07-May-16.
 */
@ManagedBean
public class EditBean {
    @EJB
    private AdService adService;

    @EJB
    private CityService cityService;

    private List<AdvertisementSo> adList;
    private AdvertisementSo newAdd;

    private List<CitySo> cityList;

    public AdvertisementSo getNewAdd() {
        return newAdd;
    }
    public void setNewAdd(AdvertisementSo newAdd) {
        this.newAdd = newAdd;
    }
    public List<AdvertisementSo> getAdList() {
        return adList;
    }
    public void setAdList(List<AdvertisementSo> adList) {
        this.adList = adList;
    }
    public List<CitySo> getCityList() {
        return cityList;
    }
    public void setCityList(List<CitySo> cityList) {
        this.cityList = cityList;
    }

    public String addNewAdvertisement() {
        Long id = adService.create(newAdd);
        initList();
        return "add.xhtml?faces-redirect=true";
    }

    public String removeAdvertisement(AdvertisementSo ad) {
        adService.remove(ad);
        initList();
        return "add.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void initList() {
        System.out.println("PostConstruct");
        newAdd = new AdvertisementSo();
        adList = adService.getAll();
        // toto sa nemeni, netreba refreshovat
        if(cityList==null)
            cityList = cityService.getAll();
    }

}
