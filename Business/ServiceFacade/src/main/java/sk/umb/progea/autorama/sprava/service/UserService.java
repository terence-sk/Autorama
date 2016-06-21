package sk.umb.progea.autorama.sprava.service;

import sk.umb.progea.autorama.sprava.so.UserSo;

import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
public interface UserService extends BaseService{
    // viacero ludi sa moze volat rovnako
    List<UserSo> getByFullName(String firstname, String surname);
    List<UserSo> getBySurname(String surname);
    // email a telefon by vsak mali byt unikatne
    UserSo getByEmail(String email);
    UserSo getByPhone(String phone);
}
