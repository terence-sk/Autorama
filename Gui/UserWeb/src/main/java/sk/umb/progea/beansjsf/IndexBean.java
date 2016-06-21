package sk.umb.progea.beansjsf;

import sk.umb.progea.autorama.sprava.service.AdService;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by msvon on 08-Apr-16.
 */
@ManagedBean
public class IndexBean implements Serializable{

    @EJB
    private AdService adService;

    private List<AdvertisementSo> adList;

    public List<AdvertisementSo> getAdList() {
        return adList;
    }

    public void setAdList(List<AdvertisementSo> adList) {
        this.adList = adList;
    }

    @PostConstruct
    public void initList() {
        Logger log = Logger.getLogger("IndexBean Logger");
        log.info("INICIALIZUJEM LIST");
        log.info("adService je : " + adService);
        adList = adService.getAll();
        // TODO City - posielat city ako parameter?
    }

}