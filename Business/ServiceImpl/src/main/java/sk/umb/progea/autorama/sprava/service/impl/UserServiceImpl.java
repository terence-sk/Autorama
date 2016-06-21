package sk.umb.progea.autorama.sprava.service.impl;

import sk.umb.progea.autorama.advertisement.dao.UserDao;
import sk.umb.progea.autorama.advertisement.domain.User;
import sk.umb.progea.autorama.sprava.service.UserService;
import sk.umb.progea.autorama.sprava.so.UserSo;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msvon on 23-Apr-16.
 */
public class UserServiceImpl implements UserService {

    @EJB
    private UserDao dao;

    @Override
    public List<UserSo> getAll() {
        List<User> userList = dao.getAll();
        return getFullResultSet(userList);
    }

    @Override
    public List<UserSo> getByFullName(String firstname, String surname) {
        List<User> u = dao.getUserByFullName(firstname,surname);
        return getFullResultSet(u);
    }

    @Override
    public List<UserSo> getBySurname(String surname) {
        List<User> u = dao.getUserBySurname(surname);
        return getFullResultSet(u);
    }

    @Override
    public UserSo getByEmail(String email) {
        User u = dao.getUserByMail(email);

        if(u==null)
            return null;

        List<User> userList = new ArrayList<User>();
        userList.add(u);

        List<UserSo> result = getFullResultSet(userList);
        return result.get(0);
    }

    @Override
    public UserSo getByPhone(String phone) {
        User u = dao.getUserByPhone(phone);

        if(u==null)
            return null;

        List<User> userList = new ArrayList<User>();
        userList.add(u);

        List<UserSo> result = getFullResultSet(userList);
        return result.get(0);
    }

    private List<UserSo> getFullResultSet(List<User> usersList){

        if(usersList==null)
            return null;

        List<UserSo> users = new ArrayList<UserSo>();
        UserSo uSo;

        for(User user: usersList){
            uSo = new UserSo();

            uSo.setEmail(user.getEmail());
            uSo.setFirstname(user.getFirstname());
            uSo.setSurname(user.getSurname());
            uSo.setPhone(user.getPhone());

            users.add(uSo);
        }

        return users;
    }

}
