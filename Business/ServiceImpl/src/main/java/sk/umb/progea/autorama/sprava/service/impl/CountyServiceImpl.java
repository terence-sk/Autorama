package sk.umb.progea.autorama.sprava.service.impl;

import sk.umb.progea.autorama.advertisement.dao.CountyDao;
import sk.umb.progea.autorama.advertisement.domain.County;
import sk.umb.progea.autorama.sprava.service.CountyService;
import sk.umb.progea.autorama.sprava.so.CountySo;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
public class CountyServiceImpl implements CountyService {
    @EJB
    CountyDao dao;

    @Override
    public CountySo getByName(String name) {
        List<County> countyList = dao.getByName(name);

        List<CountySo> result = getFullResultSet(countyList);

        if(!result.isEmpty())
            return result.get(0);

        return null;
    }

    @Override
    public List<CountySo> getAll() {
        List<County> countyList = dao.getAll();
        return getFullResultSet(countyList);
    }

    private List<CountySo> getFullResultSet(List<County> cList) {
        List<CountySo> cSo = new ArrayList<CountySo>();
        CountySo countySo;

        for(County c : cList){
            countySo = new CountySo();
            countySo.setName(c.getName());

            cSo.add(countySo);
        }
        return cSo;
    }


}
