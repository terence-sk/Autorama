package sk.umb.progea.autorama.advertisement.dao;

import sk.umb.progea.autorama.base.dao.BaseDao;
import sk.umb.progea.autorama.advertisement.domain.County;

import java.util.List;

/**
 * Created by msvon on 25-Mar-16.
 */
public interface CountyDao extends BaseDao<County, Long> {

    List<County> getByName(String name);

}
