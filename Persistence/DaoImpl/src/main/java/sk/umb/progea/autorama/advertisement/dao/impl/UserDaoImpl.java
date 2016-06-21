package sk.umb.progea.autorama.advertisement.dao.impl;

import sk.umb.progea.autorama.base.dao.impl.BaseDaoImpl;
import sk.umb.progea.autorama.advertisement.dao.UserDao;
import sk.umb.progea.autorama.advertisement.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by msvon on 14-Mar-16.
 */
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl(){
        super(User.class);
    }

    public void setEntityManager(EntityManager entityManager) {
        super.entityManager = entityManager;
    }

    @Override
    public User getUserByPhone(String phone) {
        Query q = entityManager.createNamedQuery("User.findByPhone", User.class);
        q.setParameter("phone", phone);

        if(q.getResultList().isEmpty())
            return null;

        return (User)q.getResultList().get(0);
    }

    @Override
    public User getUserByMail(String mail) {
        Query q = entityManager.createNamedQuery("User.findByEmail", User.class);
        q.setParameter("email", mail);

        if(q.getResultList().isEmpty())
            return null;

        return (User)q.getResultList().get(0);
    }

    @Override
    public List<User> getUserByFullName(String firstname, String surname) {
        Query q = entityManager.createNamedQuery("User.findByFullName", User.class);
        q.setParameter("name", firstname);
        q.setParameter("surname", surname);

        if(q.getResultList().isEmpty())
            return null;

        return q.getResultList();
    }

    @Override
    public List<User> getUserBySurname(String surname) {
        Query q = entityManager.createNamedQuery("User.findBySurname", User.class);
        q.setParameter("surname", surname);

        if(q.getResultList().isEmpty())
            return null;

        return q.getResultList();
    }
}
