package com.nibnait.dao;

import com.nibnait.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by nibnait on 2016/8/19.
 */
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUser(String id) {

        String hql = "from User u where u.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);

        return (User)query.uniqueResult();
    }

    public List<User> getAllUser() {

        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public boolean delUser(String id) {

        String hql = "delete User u where u.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);

        return (query.executeUpdate() > 0);
    }

    public boolean updateUser(User user) {

        String hql = "update User u set u.userName = ?,u.age=? where u.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, user.getUserName());
        query.setInteger(1,user.getAge());
        query.setString(2, user.getId());

        return (query.executeUpdate() > 0);
    }
}
