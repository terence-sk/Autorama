package sk.umb.progea.autorama.advertisement.dao;

import sk.umb.progea.autorama.base.dao.BaseDao;
import sk.umb.progea.autorama.advertisement.domain.User;

import java.util.List;

/**
 * Created by msvon on 14-Mar-16.
 */
public interface UserDao extends BaseDao<User, Long> {

    public List<User> getUserByFullName(String firstname, String surname);
    public List<User> getUserBySurname(String surname);
    public User getUserByMail(String mail);
    public User getUserByPhone(String phone);

}
