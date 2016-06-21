package sk.umb.progea.autorama.sprava.service;

import sk.umb.progea.autorama.sprava.so.CountySo;

import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
public interface CountyService extends BaseService{
    CountySo getByName(String name);
}
