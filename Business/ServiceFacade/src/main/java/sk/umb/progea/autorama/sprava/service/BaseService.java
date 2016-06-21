package sk.umb.progea.autorama.sprava.service;

import sk.umb.progea.autorama.base.domain.BaseDomain;
import sk.umb.progea.autorama.sprava.so.BaseSo;

import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
public interface BaseService <T extends BaseSo> {
    List<T> getAll();
}
