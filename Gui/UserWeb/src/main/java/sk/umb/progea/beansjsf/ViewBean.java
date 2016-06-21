package sk.umb.progea.beansjsf;

import sk.umb.progea.autorama.sprava.service.AdService;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * Created by msvon on 11-May-16.
 */
@ManagedBean
public class ViewBean {
    @ManagedProperty(value = "#{param.id}")
    private Long id;

    @EJB
    private AdService adService;

    private AdvertisementSo adSo;


    public AdvertisementSo getAdSo() {
        return adSo;
    }

    public void setAdSo(AdvertisementSo adSo) {
        this.adSo = adSo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PostConstruct
    public void initList() {
        adSo = adService.getById(id);
    }

}
